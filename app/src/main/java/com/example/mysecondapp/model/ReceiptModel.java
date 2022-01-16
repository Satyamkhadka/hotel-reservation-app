package com.example.mysecondapp.model;

import com.example.mysecondapp.model_data.RoomsAndAmenities;

public class ReceiptModel {
    final static private double vat =0.13;
    final static private double serviceCharge = 0.01;
    static private ReceiptModel rm;
    public static double roomsTotal;
    public static double amenitiesTotal;
    public static double vatAmount;
    public static double serviceChargeAmount;
    public static double grandTotal;
    static private RoomsAndAmenities roomsAndAmenities;


    private ReceiptModel(){

    }
    public static void calculateGrandTotal(){
        roomsTotal=0;
        amenitiesTotal=0;
        grandTotal=0;
        serviceChargeAmount=0;
        for (RoomModel rm:roomsAndAmenities.getAllRoomsForListing()) {
            if(rm!=null){
                if(rm.isAvailable() && rm.isBooked()){
                    roomsTotal+=rm.getCostPerDay();
                }
            }
        };
        for (AmenityModel am:roomsAndAmenities.getAllAmenitiesForListing()) {
            if(am!=null){
                if(am.isAvailable() && am.isBooked()){
                    amenitiesTotal+=am.getCostPerDay();
                }
            }
        };
        double total= roomsTotal+amenitiesTotal;
        vatAmount = vat*total;
        serviceChargeAmount = serviceCharge*total;
        grandTotal = total+vatAmount+serviceChargeAmount;
    }

    public static ReceiptModel getReceiptInstance(){
        if(rm==null){
            rm=new ReceiptModel();
            roomsAndAmenities= RoomsAndAmenities.getInstance();
        }
        calculateGrandTotal();
        return rm;
    }

}
