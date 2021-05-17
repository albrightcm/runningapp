//Authors: Cole Albright and Dalton Smith

package ude.esom.runningapp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ude.esom.runningapp.PastRun;
import ude.esom.runningapp.R;
import ude.esom.runningapp.RealmManager;

public class HistoryFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private RealmManager<PastRun> realmManager;

    private List<PastRun> pastRuns = new ArrayList<>();

    private RecyclerView mPastRuns;
    private PastRunAdapter mAdapter;

    public static HistoryFragment newInstance(int index) {
        HistoryFragment fragment = new HistoryFragment();
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
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);

        realmManager = new RealmManager<>();
        realmManager.initialize(getContext());

        mPastRuns = (RecyclerView) view.findViewById(R.id.past_runs);

        mPastRuns.setLayoutManager(new LinearLayoutManager(getContext()));

        pastRuns = realmManager.getEntries(PastRun.class);

        mAdapter = new PastRunAdapter(pastRuns);
        mPastRuns.setAdapter(mAdapter);

        return view;
    }

    public void updateRuns()
    {
        pastRuns = realmManager.getEntries(PastRun.class);
        mAdapter.notifyDataSetChanged();
    }
}
