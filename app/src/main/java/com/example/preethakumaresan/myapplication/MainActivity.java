package com.example.preethakumaresan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button incrButt;
    private int count = 0;
    TextView countView;

    private void incrementCount() {
        countView = (TextView) findViewById(R.id.countView);
        count += 1;
        countView.setText(String.valueOf(count));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shared = getSharedPreferences("colorCount", Context.MODE_PRIVATE);

        count = shared.getInt("count", 0);

        countView = (TextView) findViewById(R.id.countView);

        incrButt = (Button) findViewById(R.id.incrButt);

        countView.setText(String.valueOf(count));
        incrButt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                incrementCount();
            }
        });
    }

    //To display about page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.aboutMenu) {
            Intent settingsIntent = new Intent(this, AboutPage.class);
            startActivity(settingsIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}


