package ude.esom.runningapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ude.esom.runningapp.PastRun;
import ude.esom.runningapp.R;
import ude.esom.runningapp.RealmManager;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PastRunAdapter extends RecyclerView.Adapter<PastRunAdapter.ViewHolder> {

    private List<PastRun> localDataSet;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private static final DecimalFormat df = new DecimalFormat("##.##");


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            // Define click listener for the ViewHolder's View
            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public PastRunAdapter(List<PastRun> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);



        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        PastRun run = localDataSet.get(position);
        viewHolder.getTextView().setText(String.format("%s - Distance: %f",
                dateFormat.format(run.getDatePerformed()),
                run.getDistanceTraveled()));
        viewHolder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seconds = run.getSeconds();
                double dist = run.getDistanceTraveled();
                int paceMinutes = (int) ((seconds / dist) / 60);
                int paceSeconds = (int) ((seconds / dist) % 60);
                int hours = seconds / 3600;
                int minutes = seconds % 3600 / 60;
                int acseconds = seconds % 60;

                TextView calories = v.getRootView().findViewById(R.id.calories_history);
                TextView avgspeed = v.getRootView().findViewById(R.id.avg_history);
                TextView distance = v.getRootView().findViewById(R.id.distance_history);
                TextView maxspeed = v.getRootView().findViewById(R.id.max_history);
                TextView minspeed = v.getRootView().findViewById(R.id.min_history);
                TextView time = v.getRootView().findViewById(R.id.time_history);
                TextView pace = v.getRootView().findViewById(R.id.pace_history);

                calories.setText(String.valueOf(run.getCaloriesBurned()));
                distance.setText(df.format(run.getDistanceTraveled()));
                time.setText(String.format("%02d:%02d:%02d", hours, minutes, acseconds));
                pace.setText(String.format("%02d:%02d", paceMinutes, paceSeconds));
                avgspeed.setText(df.format(Math.round(run.getAverageSpeed()*100)/100));
                minspeed.setText(df.format(Math.round(run.getMinSpeed()*100)/100));
                maxspeed.setText(df.format(Math.round(run.getMaxSpeed()*100)/100));
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
