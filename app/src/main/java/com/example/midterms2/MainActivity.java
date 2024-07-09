package com.example.midterms2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutMain = findViewById(R.id.layout_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case 1:
                layoutMain.setBackgroundColor(R.id.menu_red);
                return true;
            case 2:
                layoutMain.setBackgroundColor(R.id.menu_green);
                return true;
            case 3:
                layoutMain.setBackgroundColor(R.id.menu_yellow);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}