package com.example.mysecondapp.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.example.mysecondapp.R;

public class RoomModel {
    private final int id;
    private String roomTitle;
    private String roomCode;
    private String brief;
    private String description;
    private int rating;
    private  int costPerDay;
    private boolean booked;
    private boolean available;

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
    private CardView room_listing_obj;
    private CardView room_booking_obj;
    static private int idCount=0;


    public  int getId() {
        Log.i("MainActivityy",this.id+"");
        return this.id;
    }

    public String getRoomTitle() {
        return this.roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
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

public RoomModel(String roomTitle,String brief,String description,int rating,int costPerDay){
    this.id=idCount++; // initially id will set to zero and count will be 1
    Log.e("tag", idCount+"");
    this.roomTitle = roomTitle;
    this.roomCode= roomCode;
    this.description= description;
    this.brief=brief;
    this.rating=rating;
    this.costPerDay=costPerDay;
    this.roomCode = "A"+(this.id*100);
    this.available=true;
    this.booked=false;
}
    @Override()
    public boolean equals(Object other) {
        // This is unavoidable, since equals() must accept an Object and not something more derived
        if (other instanceof RoomModel) {
            // Note that I use equals() here too, otherwise, again, we will check for referential equality.
            // Using equals() here allows the Model class to implement it's own version of equality, rather than
            // us always checking for referential equality.
            RoomModel roomModel = (RoomModel) other;
            return roomModel.getId()==(this.getId());
        }
        return false;
    }
    public CardView getRoomForListing(@NonNull LayoutInflater inflater){
        room_listing_obj = (CardView) inflater.inflate(R.layout.roomcard, null);
        ((TextView)room_listing_obj.findViewById(R.id.list_room_price)).setText("$"+this.costPerDay);
        ((TextView)room_listing_obj.findViewById(R.id.list_room_title)).setText(this.roomTitle);
        ((TextView)room_listing_obj.findViewById(R.id.list_room_brief)).setText(this.brief);
        if(this.available){
        ((Button)room_listing_obj.findViewById(R.id.list_add_to_selection_btn)).setText(this.booked?"Booked!":"Add to Booking");

        }else{
            ((Button)room_listing_obj.findViewById(R.id.list_book_btn)).setText("N/A");
            ((Button)room_listing_obj.findViewById(R.id.list_book_btn)).setEnabled(false);
            ((Button)room_listing_obj.findViewById(R.id.list_add_to_selection_btn)).setText("Not available!");
            ((Button)room_listing_obj.findViewById(R.id.list_add_to_selection_btn)).setEnabled(false);

        }
        //method 1
        return room_listing_obj;
    }
    public CardView getRoomIfBooked(@NonNull LayoutInflater inflater){
        if(!this.booked && this.available){
            Log.e("Room","Room not available");
            return null;
        }
        room_booking_obj = (CardView) inflater.inflate(R.layout.booking_list_item, null);
        ((TextView)room_booking_obj.findViewById(R.id.booking_title_list)).setText(this.roomCode+":"+this.roomTitle+"@$"+this.costPerDay+this.isBooked());
        Log.e("Room","returning room");

        return room_booking_obj;
    }
    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }
}
