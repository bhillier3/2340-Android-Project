package edu.gatech.donationapp_77;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class InventoryListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_list);

        Item[] inventory = (Item[]) getIntent().getParcelableArrayListExtra("list").toArray();
        //View v =

        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(getListView().getContext(),
                android.R.layout.simple_list_item_1, inventory);
        getListView().setAdapter(adapter);

        //onListItemClick(getListView(), this, getSelectedItemPosition(), getSelectedItemId());
    }
}
