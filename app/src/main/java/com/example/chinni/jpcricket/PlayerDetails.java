package com.example.chinni.jpcricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

public class PlayerDetails extends AppCompatActivity {
    private String TAG = PlayerDetails.class.getSimpleName();

    HashMap<String, String[]> playerDetails = new HashMap<>();
    public PlayerDetails() {
        String[] virat = {"Virat Kohli","India, Delhi, India Under 19s, Royal Challengers Bangalore", "Top-order batsman", "Right-hand bat", "Right-arm medium"};
        String[] rohit = {"Rohit Sharma","India, Deccan Chargers, India A, India Green, India Under-19s, Mumbai, Mumbai Cricket Association President's XI, Mumbai Indians, Mumbai Under-19s", "Top-order batsman", "Right-hand bat", "Right-arm offbreak"};
        String[] jadeja = {"Ravindra Jadeja"," India, Chennai Super Kings, Gujarat Lions, India Under-19s, Kochi Tuskers Kerala, Rajasthan Royals, Saurashtra, West Zone", "Allrounder", "Left-hand bat", "Slow left-arm orthodox"};
        String[] rahane = {"Ajinkya Rahane"," India, India A, India Blue, India Emerging Players, India Under-19s, Mumbai, Mumbai Indians, Rajasthan Royals, Rising Pune Supergiants", "Top-order batsman", "Right-hand bat", "Right-arm medium"};
        String[] ashwin = {"Ravichandran Ashwin","India, Chennai Super Kings, Dindigul Dragons, Rising Pune Supergiants, Tamil Nadu, Worcestershire", "Bowling allrounder", "Right-hand bat", "Right-arm offbreak"};
        String[] pujara = {"Cheteshwar Pujara","India, Derbyshire, India A, India Green, India Under-19s, Kings XI Punjab, Kolkata Knight Riders, Nottinghamshire, Royal Challengers Bangalore, Saurashtra, Saurashtra Under-16s, Saurashtra Under-19s, Yorkshire", "Top-order batsman", "Right-hand bat", "Legbreak"};
        String[] vijay = {"Murali Vijay","India, Chennai Super Kings, Delhi Daredevils, Kings XI Punjab, Lyca Kovai Kings, Tamil Nadu", "Opening batsman", "Right-hand bat", "Right-arm offbreak"};
        String[] rahul = {"Lokesh Rahul","India, Bangalore Brigadiers (Urban), India Under-19s, India Under-23s, Karnataka, Karnataka State Cricket Association Colts XI, Royal Challengers Bangalore, South Zone, Sunrisers Hyderabad", "Opening batsman", "Right-hand bat", "Right-arm medium"};

        playerDetails.put("Virat Kohli", virat);
        playerDetails.put("Rohit Sharma", rohit);
        playerDetails.put("Ravindra Jadeja", jadeja);
        playerDetails.put("Ajinkya Rahane", rahane);
        playerDetails.put("Ravichandran Ashwin", ashwin);
        playerDetails.put("Cheteshwar Pujara", pujara);
        playerDetails.put("Murali Vijay", vijay);
        playerDetails.put("Lokesh Rahul", rahul);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String[] player = playerDetails.get(name);
        TextView tv_name = (TextView)findViewById(R.id.name);
        tv_name.setText(player[0]);
        TextView tv_teams = (TextView)findViewById(R.id.Major_teams);
        tv_teams.setText(player[1]);
        TextView tv_role = (TextView)findViewById(R.id.role);
        tv_role.setText(player[2]);
        TextView tv_batting = (TextView)findViewById(R.id.batting);
        tv_batting.setText(player[3]);
        TextView tv_bowling = (TextView)findViewById(R.id.bowling);
        tv_bowling.setText(player[4]);
    }
}
