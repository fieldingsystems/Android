package com.example.alexc_000.scadavisor;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;


public class StatusMenuActivity extends Activity{

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Open the options menu right away.
        openOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.status_live_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gustina:
                // start new activity
                startActivity(new Intent(this, GustinaBearActivity.class));
                return true;

            case R.id.back:
                // Stop the service which will unpublish the live card.
                stopService(new Intent(this, StatusMenuActivity.class));
                startService(new Intent(this, ScadaVisorHome.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        // Nothing else to do, finish the Activity.
        finish();
    }
}
