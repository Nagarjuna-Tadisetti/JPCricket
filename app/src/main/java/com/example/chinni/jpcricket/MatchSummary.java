package com.example.chinni.jpcricket;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MatchSummary extends AppCompatActivity {
    private String TAG = MatchSummary.class.getSimpleName();
    String url = "http://cricapi.com/api/cricketScore?apikey=0E6GCx2OlMUHZ8vaMzCKs9yXHBw2";
    String summary_url;
    private ProgressDialog pDialog;
    HashMap<String, String> summary_hp = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_summary);
        Intent i = getIntent();
        String unique_id = i.getStringExtra("unique_id");
        summary_url = url+"&unique_id="+unique_id;

        new GetContacts().execute();
        String msg = summary_hp.get("score");

        TextView tv = (TextView)findViewById(R.id.summaryText);
        tv.setText(msg);
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MatchSummary.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(summary_url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                        String score = jsonObj.getString("score");
                        summary_hp.put("score", score);
                        Log.e(TAG, "score"+score);
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            TextView tv = (TextView)findViewById(R.id.summaryText);
            String msg = summary_hp.get("score");
            Log.e(TAG, "msg"+msg);
            tv.setText(msg.replace("amp;", ""));

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MatchSummary.this);

            // Setting Dialog Title
            alertDialog.setTitle("Like JPCricket app?");

            // Setting Dialog Message
            alertDialog.setMessage("Please give rating to our app...");

            // Setting Icon to Dialog
            //alertDialog.setIcon(R.drawable.save);

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("RATE", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.july.cricinfo")));
                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // User pressed No button. Write Logic Here
                    Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                }
            });

            // Setting Netural "Cancel" Button
            alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // User pressed Cancel button. Write Logic Here
                    Toast.makeText(getApplicationContext(), "You clicked on Cancel",
                            Toast.LENGTH_SHORT).show();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

    }
}
