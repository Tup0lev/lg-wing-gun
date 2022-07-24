package com.example.lgwinggunsimulatordown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.icu.text.Transliterator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.PointerIcon;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private ImageView daImage;
    MediaPlayer player ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daImage = findViewById(R.id.imageView);

//        daImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    muzzleflash();
//                    bang();
//                    flashoff();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });



        }




    public void bang(View v) throws Exception{
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.newshot);
            int Position = player.getCurrentPosition();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    try{
                    stopPlayer();}
                    catch (Exception e){

                    }
                }
            });
        }

        player.start();
        muzzleflash();
        Thread.sleep(50);
        flashoff();
    }



    public void stop(View v) throws Exception {
        stopPlayer();
    }

    private void stopPlayer() throws Exception{
        if (player != null) {
            flashoff();
            player.release();
            player = null;

            //Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        try{
        stopPlayer();}
        catch (Exception e){

        }
    }

    public void muzzleflash() throws CameraAccessException, InterruptedException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String camid = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(camid, true);


    }


        public void flashoff() throws CameraAccessException, InterruptedException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String camid = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(camid, false);

    }


}




//    public void bang(){
//        System.out.println("asdf");
//        playa = MediaPlayer.create(this, R.raw.gunshot);
//        playa.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                playa.stop();
//                playa.release();
//            }
//        });
//
//        playa.start();











