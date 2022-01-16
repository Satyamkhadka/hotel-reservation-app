package com.example.mysecondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.mysecondapp.model.AmenityModel;
import com.example.mysecondapp.model_data.RoomsAndAmenities;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

public class Aminity extends AppCompatActivity {

    private LinearLayout amenities_linear_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aminity);
        // bottom navigation part
        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.page_2);
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

        // initializing dummy data
        RoomsAndAmenities r = RoomsAndAmenities.getInstance();
        // showing available amenities
        amenities_linear_layout = (LinearLayout) findViewById(R.id.amenity_linear_layout);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.e("tag",r.getTotalAmenitiesCount()+"");
        for(int i=0;i<r.getTotalAmenitiesCount();i++){
            AmenityModel am = RoomsAndAmenities.getAmenityForListing(i);
            CardView amenity = am.getAmenityForListing(inflater);
            amenities_linear_layout.addView((amenity));
            ((Button)amenity.findViewById(R.id.list_book_btn)).setOnClickListener(v -> {
                // handle click
                // handle click
                if(!am.isBooked()){
                    am.setBooked(true);
                    Button b = (Button)v;
                    b.setText("Booked!");
                }
                startActivity(new Intent(getApplicationContext(),BookingsActivity.class));
                overridePendingTransition(0,0);
                Snackbar snackbar = Snackbar
                        .make(amenity, "Room booked.Please see all of your booking at bookings section.", Snackbar.LENGTH_LONG);
                snackbar.show();

            });
            ((Button)amenity.findViewById(R.id.list_add_to_selection_btn)).setOnClickListener(v -> {
                // handle click
                if(!am.isBooked()){
                    am.setBooked(true);
                    Button b = (Button)v;
                    b.setText("Booked!");
                }

                Snackbar snackbar = Snackbar
                        .make(amenity, "Room selected,View all selected in checking section", Snackbar.LENGTH_LONG);
                snackbar.show();
            });



        }
    }
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.roomcard, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}