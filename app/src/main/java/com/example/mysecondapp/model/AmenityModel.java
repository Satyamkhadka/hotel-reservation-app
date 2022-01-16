package com.example.mysecondapp.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.example.mysecondapp.R;

public class AmenityModel {
    private final int id;
    private String amenityTitle;
    private String amenityCode;
    private String brief;
    private String description;
    private int rating;
    private  int costPerDay;
    private boolean booked;
    private boolean available;
    private CardView amenity_booking_obj;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    private String imageLink;
    private CardView amenity_listing_obj;
    static private int idCount=0;


    public  int getId() {
        Log.i("MainActivityy",this.id+"");
        return this.id;
    }

    public String getAmenityTitle() {
        return this.amenityTitle;
    }

    public void setAmenityTitle(String amenityTitle) {
        this.amenityTitle = amenityTitle;
    }

    public String getAmenityCode() {
        return amenityCode;
    }

    public void setAmenityCode(String amenityCode) {
        this.amenityCode = amenityCode;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public AmenityModel(String amenityTitle,String brief,String description,int rating,int costPerDay){
        this.id=idCount++; // initially id will set to zero and count will be 1
        Log.e("tag", idCount+"");
        this.amenityTitle = amenityTitle;
        this.amenityCode= amenityCode;
        this.description= description;
        this.brief=brief;
        this.rating=rating;
        this.costPerDay=costPerDay;
        this.amenityCode = "A"+(this.id*100);
        this.available=true;
        this.booked=false;
    }
    @Override()
    public boolean equals(Object other) {
        // This is unavoidable, since equals() must accept an Object and not something more derived
        if (other instanceof AmenityModel) {
            // Note that I use equals() here too, otherwise, again, we will check for referential equality.
            // Using equals() here allows the Model class to implement it's own version of equality, rather than
            // us always checking for referential equality.
            AmenityModel amenityModel = (AmenityModel) other;
            return amenityModel.getId()==(this.getId());
        }
        return false;
    }
    public CardView getAmenityForListing(LayoutInflater inflater){
        amenity_listing_obj = (CardView) inflater.inflate(R.layout.amenitycard, null);
        ((TextView)amenity_listing_obj.findViewById(R.id.list_amenity_price)).setText("$"+this.costPerDay);
        ((TextView)amenity_listing_obj.findViewById(R.id.list_amenity_title)).setText(this.amenityTitle);
        ((TextView)amenity_listing_obj.findViewById(R.id.list_amenity_brief)).setText(this.brief);
        if(available){
            ((Button)amenity_listing_obj.findViewById(R.id.list_add_to_selection_btn)).setText(this.booked?"Booked!":"Add to Booking");

        }else{
            ((Button)amenity_listing_obj.findViewById(R.id.list_book_btn)).setText("N/A");
            ((Button)amenity_listing_obj.findViewById(R.id.list_book_btn)).setEnabled(false);
            ((Button)amenity_listing_obj.findViewById(R.id.list_add_to_selection_btn)).setText("Not available!");
            ((Button)amenity_listing_obj.findViewById(R.id.list_add_to_selection_btn)).setEnabled(false);
        }
        return amenity_listing_obj;
    }
    public CardView getAmenityIfBooked(@NonNull LayoutInflater inflater){
        if(!this.booked && this.available){
            return null;
        }
        amenity_booking_obj = (CardView) inflater.inflate(R.layout.booking_list_item, null);
        ((TextView)amenity_booking_obj.findViewById(R.id.booking_title_list)).setText(this.amenityCode+":"+this.amenityTitle+"@$"+this.costPerDay);
        //method 1
        return amenity_booking_obj;
    }
    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }
}
