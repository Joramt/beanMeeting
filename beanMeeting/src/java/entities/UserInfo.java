/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Ruben
 */
public class UserInfo implements Serializable {

    private int userid;
    private String eyecolor;
    private String haircolor;
    private String size;
    private String weight;
    private String nationality;
    private boolean drugs;
    private boolean tobacco;
    private boolean alcohol;

    public UserInfo() {
    }

    public UserInfo(int userid, String eyecolor, String haircolor, String size, String weight, String nationality, boolean drugs, boolean tobacco, boolean alcohol) {
        this.userid = userid;
        this.eyecolor = eyecolor;
        this.haircolor = haircolor;
        this.size = size;
        this.weight = weight;
        this.nationality = nationality;
        this.drugs = drugs;
        this.tobacco = tobacco;
        this.alcohol = alcohol;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public boolean isDrugs() {
        return drugs;
    }

    public void setDrugs(boolean drugs) {
        this.drugs = drugs;
    }

    public boolean isTobacco() {
        return tobacco;
    }

    public void setTobacco(boolean tobacco) {
        this.tobacco = tobacco;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "userid=" + userid + ", eyecolor=" + eyecolor + ", haircolor=" + haircolor + ", size=" + size + ", weight=" + weight + ", nationality=" + nationality + ", drugs=" + drugs + ", tobacco=" + tobacco + ", alcohol=" + alcohol + '}';
    }

    public String txtSize() {
        return String.format("%.2f", Float.valueOf(this.size)) + "m";
    }

    public String txtWeight() {
        return String.format("%.2f", Float.valueOf(this.weight)) + "kg";
    }

    public String txtDrugs() {
        return this.drugs ? "oui" : "non";
    }

    public String txtTobacco() {
        return this.tobacco ? "oui" : "non";
    }

    public String txtAlcohol() {
        return this.alcohol ? "oui" : "non";
    }

}
