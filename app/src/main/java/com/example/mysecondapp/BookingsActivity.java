package com.example.mysecondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mysecondapp.model.AmenityModel;
import com.example.mysecondapp.model.ReceiptModel;
import com.example.mysecondapp.model.RoomModel;
import com.example.mysecondapp.model_data.RoomsAndAmenities;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class BookingsActivity extends AppCompatActivity {

    private LinearLayout bookings_linear_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        // bottom navigation part
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_3);
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

        RoomsAndAmenities rms =  RoomsAndAmenities.getInstance();


        ((FloatingActionButton) findViewById(R.id.checkout_from_booking_btn)).setOnClickListener(v -> {
            // handle click
            Intent receipt = new Intent(BookingsActivity.this,ReceiptActivity.class);

            startActivity(receipt);

        });

        bookings_linear_layout = (LinearLayout) findViewById(R.id.booking_linear_layout);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RoomModel rm[] = rms.getAllBookedRooms();
        AmenityModel am[] = rms.getAllBookedAmenities();
        Log.i("Bookings","Adding rooms");
        for(int i=0;rm!=null&&i<rm.length;i++) {

            if(rm[i]==null){
                continue;
            }
            CardView room = rm[i].getRoomIfBooked(inflater);
            RoomModel roomModel= rm[i];

            bookings_linear_layout.addView(room);

            ((ImageButton) room.findViewById(R.id.unbook_item)).setOnClickListener(v -> {
                // handle click
                roomModel.setBooked(false);
                startActivity(getIntent());
            });
        }
        Log.i("Bookings","Adding amenities");

        for(int i=0;am!=null&&i<am.length;i++) {
            if(am[i]==null){
                continue;
            }
            CardView amenity = am[i].getAmenityIfBooked(inflater);
            AmenityModel amenityModel=am[i];
            bookings_linear_layout.addView((amenity));

            ((ImageButton) amenity.findViewById(R.id.unbook_item)).setOnClickListener(v -> {
                // handle click
                amenityModel.setBooked(false);
                startActivity(getIntent());
            });
        }

    }
}

