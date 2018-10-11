package edu.gatech.donationapp_77;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class LocationListActivity extends Activity {

    private RecyclerView locRecyclerView;
    private LocationAdapter adapter;
    private LinearLayoutManager locLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        initRecyclerView();
    }

    private void initRecyclerView() {
        locRecyclerView = findViewById(R.id.locRecView);
        adapter = new LocationAdapter(this);
        locRecyclerView.setAdapter(adapter);
        locLayoutManager = new LinearLayoutManager(this);
        locRecyclerView.setLayoutManager(locLayoutManager);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(
                locRecyclerView.getContext(), locLayoutManager.getOrientation());
        locRecyclerView.addItemDecoration(mDividerItemDecoration);
    }

}
