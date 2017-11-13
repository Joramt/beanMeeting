/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entities.Position;
import java.io.Serializable;
import java.sql.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ecole
 */
@ManagedBean
@RequestScoped
public class UserMB implements Serializable {

    /* Nécéssaire pour construire un user pour la DB */
    private String firstname;
    private String familyname;
    private String gender;
    private String nickname;
    private String email;
    private int membership_lvl;
    private int mail_avert;
    private Date birthdate;
    private String pwd;
    private int userid;
    private Position unPosition;
   

    /* Nécéssaire pour construire une birthdate de type Date */
    private int year;
    private int month;
    private int day;
    private boolean checkboxSelect;
    
    

    public UserMB() {
    }

    public UserMB(String firstname, String familyname, String gender, String nickname, String email, int membership_lvl, int mail_avert, Date birthdate) {
        this.firstname = firstname;
        this.familyname = familyname;
        this.gender = gender;
        this.nickname = nickname;
        this.email = email;
        this.membership_lvl = membership_lvl;
        this.mail_avert = mail_avert;
        this.birthdate = birthdate;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public void setgenreTo(int num){
        if(num == 0)
            setGender("M");
        else
            setGender("F");
        
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
    
    public boolean getCheckboxSelect() {
        return checkboxSelect;
    }

    public void setCheckboxSelect(boolean checkboxSelect) {
        this.checkboxSelect = checkboxSelect;
        if(checkboxSelect)
            mail_avert = 1;
        else
            mail_avert = 0;
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

    public Position getUnPosition() {
        return unPosition;
    }

    public void setUnPosition(Position unPosition) {
        this.unPosition = unPosition;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void createUser() {
        birthdate = new Date(this.year-1900, this.month, this.day);
        UserMB unUser = new UserMB(this.firstname, this.familyname, this.gender, this.nickname, this.email, this.membership_lvl, this.mail_avert, this.birthdate );
        System.out.println(unUser);
        //return "fromRegToIndex";
    }
    
    @PostConstruct
    public void setDefaultData(){
        gender = "M";
        checkboxSelect = true;
    }

    @Override
    public String toString() {
        return "UserMB{" + "firstname=" + firstname + ", familyname=" + familyname + ", gender=" + gender + ", nickname=" + nickname + ", email=" + email + ", membership_lvl=" + membership_lvl + ", mail_avert=" + mail_avert + ", birthdate=" + birthdate + "}";
    }
    
    
   

}
