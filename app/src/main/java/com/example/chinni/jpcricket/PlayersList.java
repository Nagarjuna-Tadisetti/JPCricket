package com.example.chinni.jpcricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PlayersList extends AppCompatActivity {
    String[] mobileArray = {"Virat Kohli","Rohit Sharma","Ravindra Jadeja","Ajinkya Rahane",
            "Ravichandran Ashwin","Cheteshwar Pujara","Murali Vijay","Lokesh Rahul"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.players_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.players);
        listView.setAdapter(adapter);

        ListView lv = (ListView) findViewById(R.id.players);
        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long a){
                Intent intent = new Intent(PlayersList.this,PlayerDetails.class);
                String name = ((TextView) v.findViewById(R.id.label)).getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
}
