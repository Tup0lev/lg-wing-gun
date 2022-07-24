package com.example.lgwinggunsimulatorup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer playa ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView LiterallyJustaHalfOfAGunPic = findViewById(R.id.imageView);
        LiterallyJustaHalfOfAGunPic.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try{
                TuTuPlaysBangBang();
                }
                catch (Exception e){
                    System.out.println("it was at this moment he fucked up");
                }
                return true;
            }
        });





    }

    public void TuTuPlaysBangBang() throws Exception{
        if (playa == null) {
            playa = MediaPlayer.create(this, R.raw.american_school_sound);
            int Position = playa.getCurrentPosition();
            playa.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    try{
                        stopPlayer();}
                    catch (Exception e){
                        System.out.println("I can't believe this shit");
                    }
                }
            });
        }   

        playa.start();
        OmgImFuckingBlind();

    }



    public void stop() throws Exception {
        stopPlayer();
    }

    private void stopPlayer() throws Exception{
        if (playa != null) {
            TurnDatDamnThingOff();
            playa.release();
            playa = null;

            //Toast.makeText(this, "Motherfuckers always tryin' to keep a playa' down", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        try{
            stopPlayer();}
        catch (Exception e){
            System.out.println("BOOOOO HOOOOOOO HOOOOOOOO WAAAAAAAAAAAAAAAAA");
        }
    }



    public void OmgImFuckingBlind() throws CameraAccessException, InterruptedException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String camid = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(camid, true);


    }


    public void TurnDatDamnThingOff() throws CameraAccessException, InterruptedException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String camid = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(camid, false);
    }

}