package com.example.pairprogramming3;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button takePicture;
    ImageView photo;
    TouchListener touchListener;
    static final int REQUEST_IMAGE= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePicture = findViewById(R.id.takePicture);
        photo = findViewById(R.id.photo);
        touchListener = new TouchListener(this);
        photo.setOnTouchListener(touchListener);
    }

    public void takePicture(View view){
        Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePicIntent, REQUEST_IMAGE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }
    public void rotatePhoto(int rotation){
        photo.animate().rotation(rotation).start();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap thumbnail = (Bitmap) extras.get("data");
            photo.setImageBitmap(thumbnail);
        }
    }

}