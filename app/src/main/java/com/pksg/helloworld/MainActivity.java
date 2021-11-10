package com.pksg.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtMenu = findViewById(R.id.txtMenu);
        txtMenu.setText("Testing");

       // boolean isFlashAvailable = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);


    }

     public void Turn_On(View view){

             CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
             String cameraId1 = null;
             try {
                 cameraId1 = camManager.getCameraIdList()[0];
                 camManager.setTorchMode(cameraId1, true);   //Turn ON
             } catch (CameraAccessException e) {
                 e.printStackTrace();
             }


    }

    public void Turn_Off(View view){

            CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null;
            try {
                cameraId = camManager.getCameraIdList()[0];
                camManager.setTorchMode(cameraId, false);   //Turn OFF
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

    }

    public void Vibrate(View view) {
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        final VibrationEffect vibrationEffect1;

        // this is the only type of the vibration which requires system version Oreo (API 26)
        // this effect creates the vibration of default amplitude for 1000ms(1 sec)
        vibrationEffect1 = VibrationEffect.createOneShot(5000, VibrationEffect.DEFAULT_AMPLITUDE);
        // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        //     vibrationEffect1 = VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK);


        // it is safe to cancel other vibrations currently taking place
        vibe.cancel();
        vibe.vibrate(vibrationEffect1);
        //}
    }

    public void StopVibe(View view) {
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibe.cancel();

    }
}