package com.example.mysecondapp.model_data;

import com.example.mysecondapp.model.AmenityModel;
import com.example.mysecondapp.model.RoomModel;

import java.util.Date;

public class UserBookings {
    public Date getBookingTimestamp() {
        return bookingTimestamp;
    }

    public void setBookingTimestamp(Date bookingTimestamp) {
        this.bookingTimestamp = bookingTimestamp;
    }


    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setRm(RoomModel[] rm) {
        this.rm = rm;
    }

    public AmenityModel[] getAm() {
        return am;
    }

    public void setAm(AmenityModel[] am) {
        this.am = am;
    }

    private Date bookingTimestamp;
    private RoomModel rm[];
    private AmenityModel am[];
    // private    UserModel um;
    private Date checkIn;
    private Date checkOut;

    public UserBookings(Date checkIn,Date checkOut){
    this.bookingTimestamp=new Date();
    this.checkIn=checkIn;
    this.checkOut=checkOut;
    }

}
