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

    private String name;

    private String address;

    private String phone;

    private String ParkSpotUrl;

    private String thumbUrl;

    private String app_fields;

    private String app_due;

    public ParkingSpot() {}


    public ParkingSpot(String name, String address, String phone, String ParkSpotUrl,
                       String thumbUrl, String application_due, String app_fields) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.app_fields = app_fields;
        this.ParkSpotUrl = ParkSpotUrl;
        this.thumbUrl = thumbUrl;
        this.app_due = application_due;
    }

    public String getApp_fields() {
        return app_fields;
    }

    public void setApp_fields(String app_fields) {
        this.app_fields = app_fields;
    }

    public String getApp_due() {
        return app_due;
    }

    public void setApp_due(String app_due) {
        this.app_due = app_due;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String location) {
        this.address = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParkSpotUrl() {
        return ParkSpotUrl;
    }

    public void setParkSpotUrl(String ParkSpotUrl) {
        this.ParkSpotUrl = ParkSpotUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getAppDue() {
        return app_due;
    }

    public void setAppDue(String application_due) {
        this.app_due = application_due;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\n")
                .append("Application Deadline: " + app_due + "\n")
                .append("Phone: " + phone + "\n")
                .append("Website: " + ParkSpotUrl + "\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ParkingSpot)) {
            return false;
        }
        ParkingSpot ParkSpot = (ParkingSpot) o;
        return name.equals(ParkSpot.getName())
                && address.equals(ParkSpot.address);
    }
}


