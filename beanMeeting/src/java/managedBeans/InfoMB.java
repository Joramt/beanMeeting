/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ecole
 */
@ManagedBean
@RequestScoped
public class InfoMB implements Serializable {
    
    private String eyecolor;
    private String haircolor;
    private String size;
    private String weight;
    private String nationality;
    private String metres;
    private String centimetres;
    private int drugs;
    private int tobacco;
    private int alcohol;
    private boolean drugsChecked;
    private boolean tobaccoChecked;
    private boolean alcoholChecked;
    private String streetname;
    private String streetnumber;
    private String country;
    private String zipcode;
    private double latitude;
    private double longitude;
    private String street;
    private int userid;

    public InfoMB(String eyecolor, String haircolor, String size, String weight, String nationality, String metres, String centimetres, int drugs, int tobacco, int alcohol, int userid) {
        this.eyecolor = eyecolor;
        this.haircolor = haircolor;
        this.size = size;
        this.weight = weight;
        this.nationality = nationality;
        this.metres = metres;
        this.centimetres = centimetres;
        this.drugs = drugs;
        this.tobacco = tobacco;
        this.alcohol = alcohol;
        this.userid = userid;
    }
    
    public String getMetres() {
        return metres;
    }

    public boolean isDrugsChecked() {
        return drugsChecked;
    }

    public void setDrugsChecked(boolean drugsChecked) {
        this.drugsChecked = drugsChecked;
        if(drugsChecked)
            this.drugs = 1;
        else
            this.drugs = 0;
    }

    public boolean isTobaccoChecked() {
        return tobaccoChecked;
        
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    

    public void setTobaccoChecked(boolean tobaccoChecked) {
        this.tobaccoChecked = tobaccoChecked;
        if(tobaccoChecked)
            this.tobacco = 1;
        else
            this.tobacco = 0;
    }

    public boolean isAlcoholChecked() {
        return alcoholChecked;
    }

    public void setAlcoholChecked(boolean alcoholChecked) {
        this.alcoholChecked = alcoholChecked;
        if(alcoholChecked)
            this.alcohol = 1;
        else
            this.tobacco = 0;
    }
    
    public void setMetres(String metres) {
        this.metres = metres;
    }

    public String getCentimetres() {
        return centimetres;
    }

    public void setCentimetres(String centimetres) {
        this.centimetres = centimetres;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getDrugs() {
        return drugs;
    }

    public void setDrugs(int drugs) {
        this.drugs = drugs;
    }

    public int getTobacco() {
        return tobacco;
    }

    public void setTobacco(int tobacco) {
        this.tobacco = tobacco;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }
    
    public void action(){
        size = metres + " " + centimetres;
        InfoMB uneInfo = new InfoMB(this.eyecolor, this.haircolor, this.size, this.weight, this.nationality, this.metres, this.centimetres, this.drugs, this.tobacco, this.alcohol, this.userid);
        System.out.println(uneInfo.toString());
    }

    @Override
    public String toString() {
        return "InfoMB{" + "eyecolor=" + eyecolor + ", haircolor=" + haircolor + ", size=" + size + ", weight=" + weight + ", nationality=" + nationality + ", metres=" + metres + ", centimetres=" + centimetres + ", drugs=" + drugs + ", tobacco=" + tobacco + ", alcohol=" + alcohol + ", drugsChecked=" + drugsChecked + ", tobaccoChecked=" + tobaccoChecked + ", alcoholChecked=" + alcoholChecked + ", streetname=" + streetname + ", streetnumber=" + streetnumber + ", country=" + country + ", zipcode=" + zipcode + ", latitude=" + latitude + ", longitude=" + longitude + ", street=" + street + '}';
    }

    
    
    
    
    public InfoMB() {
    }
    
}
