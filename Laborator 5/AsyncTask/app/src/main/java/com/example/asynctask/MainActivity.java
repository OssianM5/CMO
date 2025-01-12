package com.example.asynctask;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ImageView imageView;
    private TextView textView;

    // Imagini simulate folosind resurse drawable
    private int[] imageResources = {
            R.drawable.img0,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9
    };

    private String[] imageTexts = {
            "Imagine 0",
            "Imagine 1",
            "Imagine 2",
            "Imagine 3",
            "Imagine 4",
            "Imagine 5",
            "Imagine 6",
            "Imagine 7",
            "Imagine 8",
            "Imagine 9"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creare layout dinamic
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(View.TEXT_ALIGNMENT_CENTER);
        layout.setBackgroundColor(Color.WHITE);

        imageView = new ImageView(this);
        textView = new TextView(this);

        // Setează dimensiunile ImageView
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(250, 250);
        imageView.setLayoutParams(imageParams);

        // Adaugă ImageView și TextView în layout
        layout.addView(imageView);
        layout.addView(textView);

        setContentView(layout);

        // Start AsyncTask pentru a actualiza imaginile
        new ImageUpdater().execute();
    }

    private class ImageUpdater extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < imageResources.length; i++) {
                // Publică indexul curent pentru actualizare UI
                publishProgress(i);
                try {
                    // Întârziere de 2 secunde între imagini
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int index = values[0];
            imageView.setImageResource(imageResources[index]);
            textView.setText(imageTexts[index]);
        }
    }
}
