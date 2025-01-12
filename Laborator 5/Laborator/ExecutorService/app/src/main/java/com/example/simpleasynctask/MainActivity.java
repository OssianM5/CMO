package com.example.simpleasynctask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView textResult;
    private Button buttonStart;
    private ExecutorService executorService;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.text_result);
        buttonStart = findViewById(R.id.button_start);

        executorService = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());

        buttonStart.setOnClickListener(v -> {
            textResult.setText("Sarcina a început...");
            executorService.execute(() -> {
                // Simulăm o sarcină de lungă durată
                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(1000); // Așteaptă 1 secundă
                        int progress = i * 20;
                        handler.post(() -> textResult.setText("Progres: " + progress + "%"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.post(() -> textResult.setText("Sarcina s-a terminat!"));
            });
        });
    }
}
