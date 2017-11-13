/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.sun.xml.rpc.processor.util.StringUtils;
import java.io.Serializable;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Ecole
 */
public class User implements Serializable {

    private int iduser;
    private String firstname;
    private String familyname;
    private char gender;
    private String nickname;
    private int membership_lvl;
    private int mail_avert;
    private Date birthdate;
    private int idto;
    private int idpicture;
    private String photopath;
    private Position unePosition;
    private String email;
    private String pwd;
    private boolean membership;
    private boolean avertMail;

    public User() {
    }

    public User(int iduser, String firstname, String familyname, char gender, String nickname, int membership_lvl, int mail_avert, Date birthdate, int idto, int idpicture, String photopath) {
        this.iduser = iduser;
        this.firstname = firstname;
        this.familyname = familyname;
        this.gender = gender;
        this.nickname = nickname;
        this.membership_lvl = membership_lvl;
        this.mail_avert = mail_avert;
        this.birthdate = birthdate;
        this.idto = idto;
        this.idpicture = idpicture;
        this.photopath = photopath;
    }

    @Override
    public String toString() {
        return "User{" + "iduser=" + iduser + ", firstname=" + firstname + ", familyname=" + familyname + ", gender=" + gender + ", nickname=" + nickname + ", membership_lvl=" + membership_lvl + ", mail_avert=" + mail_avert + ", birthdate=" + birthdate + '}';
    }

    public boolean estPremium() {
        return (this.membership_lvl == 1);
    }

    public int getIduser() {
        return iduser;
    }

    public Position getUnePosition() {
        return unePosition;
    }

    public void setUnePosition(Position unePosition) {
        this.unePosition = unePosition;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getGender() {
        return (gender == 'f' ? "Female" : "Male");
    }

    public void setGender(String gender) {
        char[] charArray = gender.toCharArray();
        this.gender = charArray[0];
    }

    public String getNickname() {
        return StringUtils.capitalize(nickname);
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getMembership_lvl() {
        return membership_lvl;
    }

    public void setMembership_lvl(int membership_lvl) {
        this.membership_lvl = membership_lvl;
    }

    public int getMail_avert() {
        return mail_avert;
    }

    public void setMail_avert(int mail_avert) {
        this.mail_avert = mail_avert;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getIdto() {
        return idto;
    }

    public void setIdto(int idto) {
        this.idto = idto;
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

    public int getAge() {
        Date date = new Date(97, 01, 01);
        if (birthdate != null) {
            date = birthdate;
        }
        return getDiffYears(date, new Date());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isMembership() {
        return membership_lvl == 1;
    }

    public boolean isAvertMail() {
        return (this.mail_avert == 1);
    }

    public void setAvertMail(boolean avertMail) {
        this.avertMail = avertMail;
        this.mail_avert = avertMail ? 1 : 0;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
        this.membership_lvl = membership ? 1 : 0;
    }

    private static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH)
                || (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
