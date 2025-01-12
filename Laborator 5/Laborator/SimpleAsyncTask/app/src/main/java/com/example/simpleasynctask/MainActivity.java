package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.text_result);
        buttonStart = findViewById(R.id.button_start);

        buttonStart.setOnClickListener(v -> {
            // Pornim sarcina asincronă
            new MyAsyncTask().execute();
        });
    }

    // Clasă internă care extinde AsyncTask
    private class MyAsyncTask extends AsyncTask<Void, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textResult.setText("Sarcina a început...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            // Simulăm o sarcină de lungă durată
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000); // Așteaptă 1 secundă
                    publishProgress(i * 20); // Actualizăm progresul
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Sarcina s-a terminat!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textResult.setText("Progres: " + values[0] + "%");
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textResult.setText(result);
        }
    }
}
