package ro.cunbm.fakeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener  {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btnStart);
        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.btnStop);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(this, MyPlayerService.class);

        if (v.getId() == R.id.btnStart) {
            i.putExtra(MyPlayerService.EXTRA_PLAYLIST, "main");
            i.putExtra(MyPlayerService.EXTRA_SHUFFLE, true);

            startService(i);
        }
        else {
            stopService(i);
        }
    }
}