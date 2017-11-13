/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entities.Image;
import entities.LocationFinder;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import managers.ImagesManager;
import managers.UserManager;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

/**
 *
 * @author Ecole
 */
@ManagedBean
@ViewScoped
public class TotalUser implements Serializable {

    UserMB unUser = new UserMB();
    InfoMB uneInfo = new InfoMB();
    private boolean premiereEtape;
    private boolean secondeEtape;
    
    
    
    public void toggleEtapes(boolean premier, boolean second){
        setPremiereEtape(premier);
        setSecondeEtape(second);
    }

    public UserMB getUnUser() {
        return unUser;
    }

    public void setUnUser(UserMB unUser) {
        this.unUser = unUser;
    }

    public InfoMB getUneInfo() {
        return uneInfo;
    }

    public boolean isPremiereEtape() {
        return premiereEtape;
    }

    public void setPremiereEtape(boolean premiereEtape) {
        this.premiereEtape = premiereEtape;
    }

    public boolean isSecondeEtape() {
        return secondeEtape;
    }

    public void setSecondeEtape(boolean secondeEtape) {
        this.secondeEtape = secondeEtape;
    }
    
    public void setUneInfo(InfoMB uneInfo) {
        this.uneInfo = uneInfo;
    }

    public void cleanData() {
        this.unUser.setBirthdate(new Date(this.unUser.getYear()-1900, this.unUser.getMonth(), this.unUser.getDay()));
        this.uneInfo.setStreet(this.uneInfo.getStreetnumber() + " " + this.uneInfo.getStreetname());
        this.uneInfo.setSize(this.uneInfo.getMetres() + "." + this.uneInfo.getCentimetres());
    }

    public void setLocation() {
        String JSONstr = "test";
        JSONObject JSONobj;
        JSONArray results;
        JSONObject geo;
        JSONObject location;
        String lng;
        String lat;
        try {
            JSONstr = LocationFinder.readThatJSON("https://maps.googleapis.com/maps/api/geocode/json?address=" + this.uneInfo.getZipcode() + "&key=AIzaSyCLOtMMS-9f6QdJ8KTGcithFC9B3E5TWAo");
            JSONobj = new JSONObject(JSONstr);
            results = JSONobj.getJSONArray("results");
            geo = (JSONObject) results.getJSONObject(0).get("geometry");
            location = (JSONObject) geo.get("location");
            lng = location.getString("lng");
            lat = location.getString("lat");
            System.out.println(Double.parseDouble(lng));
            this.uneInfo.setLongitude(Double.parseDouble(lng));
            this.uneInfo.setLatitude(Double.parseDouble(lat));
        } catch (Exception ex) {
            System.out.println("ERREUR : Zipcode null");
        }

    }
    
    

    public String action() {
        cleanData();
        setLocation();
        addToDB(this.unUser, this.uneInfo);
        return "index.html";
    }
    
    public void addToDB(UserMB unUser, InfoMB uneInfo){
        if (uneInfo.getMetres() == null || uneInfo.getCentimetres() == null){
            uneInfo.setSize("0.0");
        }
        UserManager.addToDB(unUser, uneInfo);
        UsersMB.updateUsers();
    }

    public String cssButtonH() {
        String retour = "";
        if (this.unUser.getGender().equals("M")) {
            retour = "man selectedman";
        }
        return retour;
    }

    public String cssButtonF() {
        String retour = "";
        if (this.unUser.getGender().equals("F")) {
            retour = "woman selectedwoman";
        }
        return retour;
    }

    public String cssButtonMbshipLow() {
        String retour = "opt";
        if (this.unUser.getMembership_lvl() == 0) {
            retour = "opt selected";
        }
        return retour;
    }

    public String cssButtonMbshipHigh() {
        String retour = "opt";
        if (this.unUser.getMembership_lvl() == 1) {
            retour = "opt selected";
        }
        return retour;
    }

    public TotalUser() {
    }

    @PostConstruct
    public void initData() {
        this.unUser.setGender("M");
        setPremiereEtape(true);
    }

}
