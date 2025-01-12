package com.example.simplejavathread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView textResult;
    private Button buttonStart;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        */

        textResult = findViewById(R.id.text_result);
        buttonStart = findViewById(R.id.button_start);

        handler = new Handler(Looper.getMainLooper());

        buttonStart.setOnClickListener(v -> {
            textResult.setText("Sarcina a început...");
            new Thread(() -> {
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
            }).start();
        });
    }
}
