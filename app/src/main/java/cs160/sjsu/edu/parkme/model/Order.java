package cs160.sjsu.edu.parkme.model;

/**
 * Created by joyyan on 11/5/17.
 */

public class Order {

    public String orderId = "";

    public String sellerId = "";

    public String buyerId = "";

    public String parkingSpotId = "";

    public String start_date = "";

    public String durantion = "";

    public boolean isPaid = false;

    public Order(String orderId, String sellerId, String buyerId,
                 String parkingSpotId, String start_date, String durantion, boolean isPaid) {
        this.orderId = orderId;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.parkingSpotId = parkingSpotId;
        this.start_date = start_date;
        this.durantion = durantion;
        this.isPaid = isPaid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getDurantion() {
        return durantion;
    }

    public void setDurantion(String durantion) {
        this.durantion = durantion;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
