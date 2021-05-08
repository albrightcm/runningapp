package ude.esom.runningapp.ui.main;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.core.location.LocationEngineRequest;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.lang.ref.WeakReference;
import java.text.DecimalFormat;

import ude.esom.runningapp.PastRun;
import ude.esom.runningapp.R;
import ude.esom.runningapp.RealmManager;

import static android.graphics.Color.rgb;
import static android.os.Looper.getMainLooper;

public class MapFragment extends Fragment implements OnMapReadyCallback{

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    private RealmManager<PastRun> realmManager;

    private MapView mapView;
    private MapboxMap mapboxMap;
    private LocationEngine locationEngine;
    private final long DEFAULT_INTERVAL_IN_MILLISECONDS = 2000L;
    private final long DEFAULT_MAX_WAIT_TIME = DEFAULT_INTERVAL_IN_MILLISECONDS * 5;
    private MainActivityLocationCallback callback = new MainActivityLocationCallback(this);
    private static final DecimalFormat df = new DecimalFormat("##.##");
    private TextView paceText;
    private TextView distanceText;
    private TextView timeText;
    private long startTime = 0;
    private double distance = 0;
    private boolean isRunning = false;
    private double minSpeed = Double.MAX_VALUE;
    private double maxSpeed = 0.0;
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int paceMinutes = (int) ((seconds/distance)/60);
            int paceSeconds = (int) ((seconds/distance) % 60);
            int hours = seconds / 3600;
            int minutes = seconds % 3600 / 60;
            seconds = seconds % 60;
            timeText.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            distanceText.setText(df.format(distance));
            if(paceMinutes < 100) {
                paceText.setText(String.format("%02d:%02d", paceMinutes, paceSeconds));
            }

            double speedMph = (distance/seconds)/3600;

            if (speedMph > maxSpeed) maxSpeed = speedMph;
            if (speedMph < minSpeed) minSpeed = speedMph;

            timerHandler.postDelayed(this, 1000);
        }
    };

    @SuppressLint("MissingPermission")
    private void initLocationEngine() {
        locationEngine = LocationEngineProvider.getBestLocationEngine(getContext());

        LocationEngineRequest request = new LocationEngineRequest.Builder(DEFAULT_INTERVAL_IN_MILLISECONDS)
                .setPriority(LocationEngineRequest.PRIORITY_HIGH_ACCURACY)
                .setMaxWaitTime(DEFAULT_MAX_WAIT_TIME).build();
        locationEngine.requestLocationUpdates(request, callback, getMainLooper());
        locationEngine.getLastLocation(callback);
    }

    public static MapFragment newInstance(int index) {
        MapFragment fragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

        realmManager = new RealmManager<>();
        realmManager.initialize(getContext());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Mapbox.getInstance(requireContext(), getString(R.string.mapbox_access_token));

        View root = inflater.inflate(R.layout.map_fragment, container, false);
        mapView = (MapView) root.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


        paceText = root.findViewById(R.id.text_pace);
        distanceText = root.findViewById(R.id.text_miles);
        timeText = root.findViewById(R.id.text_time);
        Button run = root.findViewById(R.id.button_run);

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRunning = !isRunning;
                if (isRunning){
                    startTime = System.currentTimeMillis();
                    distance = 0;
                    minSpeed = Double.MAX_VALUE;
                    maxSpeed = 0;
                    run.setBackgroundColor(rgb(200, 0, 0));
                    run.setText("Stop Run");
                    timerHandler.postDelayed(timerRunnable, 0);
                    LocationComponent locationComponent = mapboxMap.getLocationComponent();
                    locationComponent.setCameraMode(CameraMode.TRACKING);
                } else{
                    timerHandler.removeCallbacks(timerRunnable);

                    long millis = System.currentTimeMillis() - startTime;
                    int seconds = (int) (millis / 1000);
                    double averageSpeed = (distance/seconds)/3600;

                    PastRun pastRun = new PastRun(distance, averageSpeed, minSpeed, maxSpeed, 0);

                    realmManager.create(pastRun);

                    run.setBackgroundColor(rgb(0, 255, 0));
                    run.setText("Start Run");
                }
            }
        });

        return root;
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
            @SuppressLint("MissingPermission")
            @Override
            public void onStyleLoaded(@NonNull Style style) {
                if (PermissionsManager.areLocationPermissionsGranted(getContext())) {
                    LocationComponent locationComponent = mapboxMap.getLocationComponent();
                    LocationComponentActivationOptions locationComponentActivationOptions = LocationComponentActivationOptions.builder(getContext(), style).useDefaultLocationEngine(false).build();
                    locationComponent.activateLocationComponent(locationComponentActivationOptions);
                    locationComponent.setLocationComponentEnabled(true);
                    locationComponent.setCameraMode(CameraMode.TRACKING);
                    locationComponent.setRenderMode(RenderMode.COMPASS);
                    locationEngine = LocationEngineProvider.getBestLocationEngine(getContext());
                    LocationEngineRequest request = new LocationEngineRequest.Builder(DEFAULT_INTERVAL_IN_MILLISECONDS).setPriority(LocationEngineRequest.PRIORITY_HIGH_ACCURACY).setMaxWaitTime(DEFAULT_MAX_WAIT_TIME).build();
                    locationEngine.requestLocationUpdates(request, callback, getMainLooper());
                    locationEngine.getLastLocation(callback);
                }
            }
        });
    }

    private static class MainActivityLocationCallback implements LocationEngineCallback<LocationEngineResult> {
        private final WeakReference<MapFragment> activityWeakReference;

        MainActivityLocationCallback(MapFragment activity) {
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void onSuccess(LocationEngineResult result) {
            MapFragment activity = activityWeakReference.get();
            if (activity != null) {
                Location location = result.getLastLocation();
                if (location == null) {
                    return;
                }
                if (activity.mapboxMap != null && result.getLastLocation() != null) {
                    double oldLat, newLat, oldLong, newLong;
                    if(activity.mapboxMap.getLocationComponent().getLastKnownLocation() == null){
                        oldLat = result.getLastLocation().getLatitude();
                        oldLong = result.getLastLocation().getLongitude();
                        System.out.print("1");
                    } else {
                        oldLat = activity.mapboxMap.getLocationComponent().getLastKnownLocation().getLatitude();
                        oldLong = activity.mapboxMap.getLocationComponent().getLastKnownLocation().getLongitude();
                    }

                    activity.mapboxMap.getLocationComponent().forceLocationUpdate(result.getLastLocation());

                    newLat = result.getLastLocation().getLatitude();
                    newLong = result.getLastLocation().getLongitude();

                    double dLat = (newLat - oldLat) *
                            Math.PI / 180.0;
                    double dLon = (newLong - oldLong) *
                            Math.PI / 180.0;
                    oldLat = (oldLat) * Math.PI / 180.0;
                    newLat = (newLat) * Math.PI / 180.0;
                    double a = Math.pow(Math.sin(dLat / 2), 2) +
                            Math. pow(Math.sin(dLon / 2), 2) *
                                    Math.cos(oldLat) * Math.cos(newLat);
                    double rad = 6371;
                    double c = 2 * Math.asin(Math.sqrt(a));
                    activity.distance += rad * c;
                }
            }
        }

        @Override
        public void onFailure(@NonNull Exception exception) {

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
        timerHandler.removeCallbacks(timerRunnable);
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
        if (locationEngine != null) {
            locationEngine.removeLocationUpdates(callback);
        }
    }
}
