package com.example.mysecondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mysecondapp.model.ReceiptModel;
import com.example.mysecondapp.model_data.RoomsAndAmenities;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ReceiptActivity extends AppCompatActivity {
    private LinearLayout receipts_linear_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        receipts_linear_layout = findViewById(R.id.receipt_linear_layout);
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
        ReceiptModel receiptModel = ReceiptModel.getReceiptInstance();
        receiptModel.calculateGrandTotal();

        TextView heading=new TextView(this);
        heading.setGravity(Gravity.CENTER);
        heading.setText("Bill for \n");
        heading.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        heading.setTypeface(null,Typeface.BOLD);

        receipts_linear_layout.addView(heading);

        TextView roomTotal=new TextView(this);
        roomTotal.setText("Rooms Total:"+ReceiptModel.roomsTotal);
        roomTotal.setGravity(Gravity.CENTER);
        roomTotal.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        receipts_linear_layout.addView(roomTotal);

        TextView amenitiesTotal=new TextView(this);
        amenitiesTotal.setText("Amenities Total:"+ReceiptModel.amenitiesTotal);
        amenitiesTotal.setGravity(Gravity.CENTER);
        amenitiesTotal.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        receipts_linear_layout.addView(amenitiesTotal);

        TextView vatAmount=new TextView(this);
        vatAmount.setText("VAT Amount:"+ReceiptModel.vatAmount);
        vatAmount.setGravity(Gravity.CENTER);
        vatAmount.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        receipts_linear_layout.addView(vatAmount);

        TextView serviceChargeAmount=new TextView(this);
        serviceChargeAmount.setText("Service Charge Amount:"+ReceiptModel.serviceChargeAmount);
        serviceChargeAmount.setGravity(Gravity.CENTER);
        serviceChargeAmount.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        receipts_linear_layout.addView(serviceChargeAmount);

        TextView grandTotal=new TextView(this);
        grandTotal.setText("-------------------- \n Grand Total:"+ReceiptModel.grandTotal);
        grandTotal.setGravity(Gravity.CENTER);
        grandTotal.setTypeface(null,Typeface.BOLD);
        grandTotal.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        receipts_linear_layout.addView(grandTotal);
    }
}