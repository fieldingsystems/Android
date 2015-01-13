package com.example.alexc_000.scadavisor;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class LiveCardMenuActivity extends Activity {

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // Open the options menu right away.
        openOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scada_visor_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.status:
                // start the Status livecard service
                startService(new Intent(this, StatusLiveCardService.class));
                return true;

            case R.id.alarms:
                // start the Alarm service
                startService(new Intent(this, AlarmLiveCardService.class));
                return true;

            case R.id.action_stop:
                // Stop the service which will unpublish the live card.
                stopService(new Intent(this, ScadaVisorHome.class));
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
