package com.sandipbhattacharya.simplelistviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // Object-reference of our ListView
    ListView lvMonth;
    // String array to store the months that we'll generate programmatically
    String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the object by calling findViewById() which returns a reference to our ListView
        lvMonth = findViewById(R.id.lvMonth);
        // Populate months
        months = new DateFormatSymbols().getMonths();
        // Next, create the ArrayAdapter instance having the month list
        // To customize the appearance of the ListView, create a new XML file and use that in ArrayAdapter
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this, R.layout.list_item, months);

        // Example of ArrayAdapter without custom XML file
        //ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, months);

        // To display items in the list, call setAdapter() to associate an adapter with the list
        lvMonth.setAdapter(monthAdapter);
        // To set OnItemClickListener, simply write
        lvMonth.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Here, parent	is the AdapterView where the click happened.
        // view	is the view within the AdapterView that was clicked. This will be a view provided by the adapter.
        // position	is the position of the view in the adapter.
        // id is the database row id of the item that was clicked.
        String month = parent.getItemAtPosition(position).toString();
        //String month = months[position];
        //String month = ((TextView) view).getText().toString();
        //String month = lvMonth.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), "Clicked: "+month, Toast.LENGTH_SHORT).show();
    }
}
