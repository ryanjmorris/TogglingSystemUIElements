package com.ryanjmorris.amnestyprograms.togglingsystemuielements;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnClickListener
{
    //The button will act as one to work between all three buttons.
    private Button darkButton;
    //These variables will be able to track whether or not the user has clicked on of the
    //buttons successfully or not.
    private int count = 0, counth = 0, countf = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        darkButton = (Button) findViewById(R.id.enabledark);
        darkButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.enabledark:
                if (count == 0)
                {
                    darkUI(v);
                    count++;
                }
                else
                {
                    lightUI(v);
                    count--;
                }
                break;

            case R.id.hidenav:
                if (counth == 0)
                {
                    navRemove(v);
                    counth++;
                }
                else
                {
                    navReinstate(v);
                    counth--;
                }
                break;

            case R.id.enablefull:
                if (countf == 0)
                {
                    showFullscreen(v);
                    countf++;
                }
                else
                {
                    removeFullscreen(v);
                    countf--;
                }
                break;
        }
    }

    /*
    This takes the view, and brings it into a darker state. A darker state will
    allow for extra battery life considering the screen does not take up as much of the
    batter as it normally would.
     */
    public void darkUI(View v)
    {
        int currentVis = v.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE)
                == View.SYSTEM_UI_FLAG_LOW_PROFILE)
        {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        else
        {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        v.setSystemUiVisibility(newVis);
    }

    /*
    This method brings back the visiblity to normal, instead of the
    dark view it was previously in.
     */
    public void lightUI(View v)
    {
        int currentVis = v.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE)
                == View.SYSTEM_UI_FLAG_LOW_PROFILE)
        {
            newVis = View.SYSTEM_UI_LAYOUT_FLAGS;
        }
        else
        {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        v.setSystemUiVisibility(newVis);
    }

    /*
    This method will hide the navigation controls.
     */
    public void navRemove(View v)
    {
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    /*
    This method will reinstate the navigation controls.
     */
    public void navReinstate(View v)
    {
        v.setSystemUiVisibility(View.SYSTEM_UI_LAYOUT_FLAGS);
    }

    /*
    This method will show an entire fullscreen for the application.
     */
    public void showFullscreen(View v)
    {
        //This will request to the Android device to stop showing the action bar.
        //requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);

        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    /*
    This method will remove the application from fullscreen mode.
     */
    public void removeFullscreen(View v)
    {
        v.setSystemUiVisibility(View.SYSTEM_UI_LAYOUT_FLAGS);
    }

}
