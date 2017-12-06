package cs160.sjsu.edu.parkme.model;

import java.util.ArrayList;

/**
 * Created by joyyan on 11/5/17.
 */

public class User {

    public String uid = "";

    public String name = "";

    public String address = "";

    public String city = "";

    public String email = "";

    public String phone = "";

    public String profileURI = "";


    public User(String uid, String name, String address, String city, String email,
                String phone, String profileURI) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.profileURI = profileURI;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileURI() {
        return profileURI;
    }

    public void setProfileURI(String profileURI) {
        this.profileURI = profileURI;
    }
}
