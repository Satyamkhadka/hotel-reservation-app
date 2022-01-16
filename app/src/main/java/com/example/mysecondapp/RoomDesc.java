package com.example.mysecondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysecondapp.model.RoomModel;
import com.example.mysecondapp.model_data.RoomsAndAmenities;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class RoomDesc extends AppCompatActivity {
    private  RoomModel rm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_desc);

        // bottom navigation part
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_1);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.page_1:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page_2:
                        startActivity(new Intent(getApplicationContext(),Aminity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.page_3:
                        startActivity(new Intent(getApplicationContext(),BookingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return true;
            }
        });


        Intent callingIntent = getIntent();
        if(callingIntent!=null){
            Log.e("RoomDesc",callingIntent.getIntExtra("roomId",0)+"");
            rm = RoomsAndAmenities.getRoomForListing((int)callingIntent.getIntExtra("roomId",0));
            ((TextView)findViewById(R.id.desc_room_title)).setText(rm.getRoomCode()+":"+rm.getRoomTitle());
            ((TextView)findViewById(R.id.desc_room_brief)).setText(rm.getBrief());
            ((TextView)findViewById(R.id.desc_room_price)).setText("$"+rm.getCostPerDay());
            ((TextView)findViewById(R.id.desc_room_desc)).setText(rm.getDescription());
            ((ImageView)findViewById(R.id.desc_room_img)).setImageResource(rm.getImage());

        }else {
            finish();
            super.onBackPressed();
        }
    }
}