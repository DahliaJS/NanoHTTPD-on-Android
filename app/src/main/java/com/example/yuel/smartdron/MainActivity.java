package com.example.yuel.smartdron;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static final int PORT = 3000;
    public static Server server = new Server(PORT);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView text = findViewById(R.id.server);
        String startTxt = "Server is now started";

        //Server
        try {
            server.start();

            Log.i("", startTxt);
            text.setText(startTxt);
            Log.i("CANREAD", String.valueOf(Environment.getExternalStorageDirectory().canRead()));
            Log.i("PATH", Environment.getExternalStorageDirectory().getAbsolutePath() + "/www/");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (server != null)
            server.stop();
    }

}