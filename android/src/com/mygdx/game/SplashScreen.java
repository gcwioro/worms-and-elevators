package com.mygdx.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Muhi on 04.04.2017.
 */

public class SplashScreen extends Activity {


    private Intent intent;


    /**
     *  onCreate-Method is used to set the content view of the class to the main menu activity.
     * Further the thread which is within the method is used to make the splash screen sleep for 3000
     * milliseconds before it switches to the main menu screen.
     *
     * @param savedInstanceState ... Bundle
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Thread timerThread = new Thread() {

            public void run(){

                try{

                    sleep(3000);

                }catch (InterruptedException e){

                    e.printStackTrace();
                }
                finally {


                    intent = new Intent(SplashScreen.this,MainMenu.class);
                    startActivity(intent);
                }
            }
        };

        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}