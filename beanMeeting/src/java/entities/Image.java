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
public class Image implements Serializable {
    private int iduser;
    private int idpicture;
    private String photopath;
    private boolean profile;

    public Image() {
    }

    public Image(int iduser, int idpicture, String photopath, boolean profile) {
        this.iduser = iduser;
        this.idpicture = idpicture;
        this.photopath = photopath;
        this.profile = profile;
    }
    
        public Image(int iduser, String photopath, boolean profile) {
        this.iduser = iduser;
        this.photopath = photopath;
        this.profile = profile;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdpicture() {
        return idpicture;
    }

    public void setIdpicture(int idpicture) {
        this.idpicture = idpicture;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public boolean isProfile() {
        return profile;
    }

    public void setProfile(boolean profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Image{" + "iduser=" + iduser + ", idpicture=" + idpicture + ", photopath=" + photopath + ", profile=" + profile + '}';
    }

}
