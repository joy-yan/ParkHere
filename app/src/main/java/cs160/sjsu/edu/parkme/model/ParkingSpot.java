package cs160.sjsu.edu.parkme.model;

/**
 * Created by joyyan on 11/1/17.
 */

import org.parceler.Parcel;

/**
 * Created by joyyan on 3/7/17.
 */
@Parcel
public class ParkingSpot {


    public String parkingSpotId = "";

    public String address = "";

    public String city = "";

    public String description = "";

    public String photoUrl = "";

    public String daily_rate = "";

    public String start_date = "";
    public String end_date = "";

    public String start_time = "";
    public String end_time = "";

    public double rating = 0;


    public String uid = "";

    public ParkingSpot() {}


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public String getAddress() {
        return address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDailyRate() {
        return daily_rate;
    }

    public void setDailyRate(String daily_rate) {
        this.daily_rate = daily_rate;
    }

    public String getStartDate() {
        return start_date;
    }

    public void setStartDate(String start_date) {
        this.start_date = start_date;
    }

    public String getEndDate() {
        return end_date;
    }

    public void setEndDate(String end_date) {
        this.end_date = end_date;
    }


    public void setStartTime(String start_time) {
        this.start_time = start_time;
    }

    public String getStartTime() {
        return start_time;
    }

    public void setEndTime(String end_time) {
        this.end_time = end_time;
    }

    public String getEndTime() {
        return end_time;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(description + "\n")
                .append("Address: " + address + "\n")
                .append("Phone: " + city + "\n")
                .append("Website: " + photoUrl+ "\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ParkingSpot)) {
            return false;
        }
        ParkingSpot parkSpot = (ParkingSpot) o;
        return parkingSpotId.equals(parkSpot.parkingSpotId)
                && address.equals(parkSpot.address);
    }
}


