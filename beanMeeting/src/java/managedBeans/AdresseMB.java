/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ecole
 */
@ManagedBean
@SessionScoped
public class AdresseMB implements Serializable{
    
    private String streetname;
    private String streetnumber;
    private String country;
    private String zipcode;
    private int latitude;
    private int longitude;
    private String street;

    public AdresseMB(String street, String country, String zipcode, int latitude, int longitude) {
        this.street = street;
        this.country = country;
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AdresseMB(String streetname, String streetnumber, String country, String zipcode, int latitude, int longitude, String street) {
        this.streetname = streetname;
        this.streetnumber = streetnumber;
        this.country = country;
        this.zipcode = zipcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
    }

    public AdresseMB() {
    }
    
    
    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    
    public AdresseMB action(){
        street = streetnumber + " " + streetname;
        AdresseMB uneAdresse = new AdresseMB(this.streetname, this.streetnumber, this.country, this.zipcode, 0, 0, this.street);
        return uneAdresse;
    }

    @Override
    public String toString() {
        return "AdresseMB{" + "country=" + country + ", zipcode=" + zipcode + ", latitude=" + latitude + ", longitude=" + longitude + ", street=" + street + '}';
    }

    

   
    
    

    
}
