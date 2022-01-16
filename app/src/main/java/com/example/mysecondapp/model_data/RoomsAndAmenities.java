package com.example.mysecondapp.model_data;

import android.app.Application;
import android.util.Log;

import com.example.mysecondapp.model.AmenityModel;
import com.example.mysecondapp.model.RoomModel;
public class RoomsAndAmenities {

    public static RoomModel[] totalRooms;
    public static AmenityModel[] totalAmenities;
    static private boolean init = false;
  private static RoomsAndAmenities rms = null;
    private static void createDummyRooms(){

        totalRooms = new RoomModel[10];
        totalAmenities = new AmenityModel[10];
        init = true;

        totalRooms[0] = new RoomModel("south facing room", "come here", "This is a nice room very nice", 0,150);
        totalRooms[1] = new RoomModel("Room with balcony",  "This room views a magnificient view of the city scape", "Lyrics\n" +
                "\n" +
                "Standing now\n" +
                "Calling all the people here to see the show\n" +
                "Calling for my demons now to let me go\n" +
                "I need something, give me something wonderful\n" +
                "\n" +
                "I believe\n" +
                "She won't take me somewhere I'm not supposed to be\n" +
                "You can't steal the things that god has given me\n" +
                "No more pain and no more shame and misery\n" +
                "\n" +
                "You can't take me down\n" +
                "You can't break me down\n" +
                "You can't take me down\n" +
                "\n" +
                "You can't take me down\n" +
                "You can't break me down\n" +
                "You can't take me down\n" +
                "\n" +
                "Love and hate\n" +
                "How much more are we supposed to tolerate\n" +
                "Can't you see there's more to me than my mistakes\n" +
                "Sometimes I get this feeling - makes me hesitate\n" +
                "\n" +
                "I believe\n" +
                "She won't take me somewhere I'm not supposed to be\n" +
                "You can't steal the things that god has given me\n" +
                "No more pain and no more shame and misery\n" +
                "\n" +
                "You can't take me down\n" +
                "You can't break me down\n" +
                "You can't take me down\n" +
                "\n" +
                "You can't break me down\n" +
                "You can't take me down\n" +
                "You can't break me down\n" +
                "\n" +
                "I can see a place of trouble\n" +
                "And I'm on the verge\n" +
                "For the love of everybody\n" +
                "I need something more\n" +
                "\n" +
                "Now I feel some days of trouble\n" +
                "I'm in the house of war\n" +
                "For the love of everybody\n" +
                "Look behind the wall\n" +
                "\n" +
                "Standing now\n" +
                "Calling all the people here to see the show\n" +
                "Calling for my demons now to let me go\n" +
                "I need something, give me something wonderful", 0,150);
        totalRooms[2] = new RoomModel("south facing room", "come here", "This is a nice room very nice", 0,200);
        totalRooms[3] = new RoomModel("south facing room", "come here", "This is a nice room very nice", 0,300);
        totalRooms[4] = new RoomModel("south facing room", "come here", "This is a nice room very nice", 0,250);
        totalAmenities[0] = new AmenityModel("Swimming Pool","Luxurious Swimming pool","A luxirous swimming pool for all your needs",2,10);
        totalAmenities[1] = new AmenityModel("Swimming Pool","Luxurious Swimming pool","A luxirous swimming pool for all your needs",2,10);
        totalAmenities[2] = new AmenityModel("Swimming Pool","Luxurious Swimming pool","A luxirous swimming pool for all your needs",2,10);
        totalAmenities[3] = new AmenityModel("Swimming Pool","Luxurious Swimming pool","A luxirous swimming pool for all your needs",2,10);
        totalAmenities[4] = new AmenityModel("Swimming Pool","Luxurious Swimming pool","A luxirous swimming pool for all your needs",2,10);

        totalRooms[0].setAvailable(false);
        totalAmenities[0].setAvailable(false);
    }
    // for creating static class will always return same instance of this class
    private  RoomsAndAmenities() {

    }
    public static RoomsAndAmenities getInstance(){
        if(!init){
            createDummyRooms();
        }
        if(rms==null){
            rms= new RoomsAndAmenities();
        }
            return rms;
    }

    public int getTotalRoomsCount() {
        if(!init){
            createDummyRooms();
        }
        int count = 0;
        for (int i = 0; i < totalRooms.length; i++) {
            if (totalRooms[i] != null) {
                count++;
            }
        }
        return count;
    }

    public RoomModel[] getAllRoomsForListing() {
        return totalRooms;
    }
    public static RoomModel getRoomForListing(int i) {
        try{
            return totalRooms[i];

        }catch (Exception e){
            Log.e("ROOMS",e.toString());
            return null;
        }
    }
public static int getTotalBookedRoomsNumber(){
        int count=0;
    for (int i = 0; i < totalRooms.length; i++) {
        if (totalRooms[i] != null) {
            if(totalRooms[i].isBooked()) {
                count++;
            }
        }
    }
            Log.e("Rooms",count+" rooms booked.");
    return count;
}
public static RoomModel[] getAllBookedRooms(){
        if(getTotalBookedRoomsNumber()==0){
            return null;
        }
        RoomModel rm[] = new RoomModel[getTotalBookedRoomsNumber()];
        int count = 0;
    for (int i = 0; i < totalRooms.length; i++) {
        if (totalRooms[i] != null) {
            if(totalRooms[i].isBooked()) {
                rm[count] = totalRooms[i];
                count++;
                Log.e("Room_Bug ok"," Room is  booked");
            }
        }
    }
    Log.e("Room_Bug",count+" rooms booked in obj.");
    return rm;
}
    public static int getTotalBookedAmenitiesNumber(){
        int count=0;
        for (int i = 0; i < totalAmenities.length; i++) {
            if (totalAmenities[i] != null) {
                if(totalAmenities[i].isBooked()) {
                    count++;
                }
            }
        }
        return count;
    }
    public static AmenityModel[] getAllBookedAmenities(){
        if(getTotalBookedAmenitiesNumber()==0){
            return null;
        }
        AmenityModel am[] = new AmenityModel[getTotalBookedAmenitiesNumber()];
        int count = 0;
        for (int i = 0; i < totalAmenities.length; i++) {
            if (totalAmenities[i] != null) {
                if(totalAmenities[i].isBooked()) {
                    am[count] = totalAmenities[i];
                    count++;
                }
            }
        }
        return am;
    }
    public int getTotalAmenitiesCount() {
        if(!init){
            createDummyRooms();
        }
        int count = 0;
        for (int i = 0; i < totalAmenities.length; i++) {
            if (totalAmenities[i] != null) {
                count++;
            }
        }
        return count;
    }

    public AmenityModel[] getAllAmenitiesForListing() {
        return totalAmenities;
    }
    public static AmenityModel getAmenityForListing(int i) {
        try{
            return totalAmenities[i];

        }catch (Exception e){
            Log.e("Amenity",e.toString());
            return null;
        }
    }
}
