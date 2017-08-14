package com.zxl.mycustomer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zxl.mycustomer.satellite.SatelliteMenu;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private SatelliteMenu satelliteMenu;
    private Button btn_set_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        satelliteMenu= (SatelliteMenu) findViewById(R.id.sm_menu);
        satelliteMenu.setOnMenuItemClickListener(new SatelliteMenu.onMenuItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btn_set_position= (Button) findViewById(R.id.btn_set_position);
        btn_set_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //随机调整位置,0:左上;1:左下;2:右上;3:右下。
                Random rand=new Random();
                int position=rand.nextInt(4);
                switch (position) {
                    case 0:
                        satelliteMenu.setPosition(SatelliteMenu.Position.POS_LEFT_TOP);
                        break;
                    case 1:
                        satelliteMenu.setPosition(SatelliteMenu.Position.POS_LEFT_BOTTOM);
                        break;
                    case 2:
                        satelliteMenu.setPosition(SatelliteMenu.Position.POS_RIGHT_TOP);
                        break;
                    case 3:
                        satelliteMenu.setPosition(SatelliteMenu.Position.POS_RIGHT_BOTTOM);
                        break;
                }

            }
        });
    }
}
