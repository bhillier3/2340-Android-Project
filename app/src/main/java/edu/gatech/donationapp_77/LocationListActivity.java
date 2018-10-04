package edu.gatech.donationapp_77;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class LocationListActivity extends Activity {

    private RecyclerView locRecyclerView;
    private RecyclerView.Adapter locAdapter;
    private RecyclerView.LayoutManager locLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        locRecyclerView = (RecyclerView) findViewById(R.id.locRecView);

        locLayoutManager = new LinearLayoutManager(this);
        locRecyclerView.setLayoutManager(locLayoutManager);

        // pass actual data in (list of Locations)
        locAdapter = new LocationAdapter();
        locRecyclerView.setAdapter(locAdapter);

    }

}
