package com.example.zhucan.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    GridLayout gv;
    //地雷数组
    int[] RL;
    //地雷数量
    int count;

    int i;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridLayout) findViewById(R.id.activity_main);
        RandomLandmine randomLandmine = new RandomLandmine(96);
        RL = randomLandmine.setrandomLM();
        final int[] a = {
                R.drawable.ic_0, R.drawable.ic_1, R.drawable.ic_2, R.drawable.ic_3, R.drawable.ic_4, R.drawable.ic_5, R.drawable.ic_6, R.drawable.ic_7, R.drawable.ic_8, R.drawable.ic_bong
        };
        for (i = 0; i < 96; i++) {


            ImageButton view = new ImageButton(this);

            Roundlandmine roundlandmine = new Roundlandmine(i + 1, 8, 96);
            roundlandmine.setroundld();
            final int t = roundlandmine.getnum(RL);
            view.setId(i);
            view.setBackgroundResource(R.drawable.ic_action_name);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bong b = new Bong();
                    switch (b.getint(v.getId() + 1, RL)) {
                        case 0:
                            v.setBackgroundResource(a[t]);
                            break;
                        case 1:
                            v.setBackgroundResource(R.drawable.ic_bong);
                            Toast.makeText(MainActivity.this,"嘣!你踩到地雷了",Toast.LENGTH_SHORT).show();
                            break;
                    }

                }
            });


            GridLayout.Spec rowSpec = GridLayout.spec(i / 8);
            GridLayout.Spec columnSpec = GridLayout.spec(i % 8);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
            params.setGravity(Gravity.CLIP_VERTICAL);
            gv.addView(view, params);
            params.setMargins(1, 1, 1, 1);

        }


    }


}
