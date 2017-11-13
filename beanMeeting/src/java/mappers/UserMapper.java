/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import managedBeans.InfoMB;
import managedBeans.UserMB;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 *
 * @author Ecole
 */
public interface UserMapper {
    
    @Insert("insert into userinfo (userid, eyecolor, haircolor, size, weight, nationality, drugs, tobacco, alcohol) VALUES (#{userid}, #{eyecolor}, #{haircolor}, #{size}, #{weight}, #{nationality}, #{drugs}, #{tobacco}, #{alcohol})")
    public void addInfoToDB(InfoMB uneInfo);
    
    @Insert("insert into useradress (userid, country, zipcode, street, latitude, longitude) VALUES (#{userid}, #{country}, #{zipcode}, #{street}, #{latitude}, #{longitude})")
    public void addAdressToDB(InfoMB uneInfo);
    
    @Insert("insert into user (firstname, familyname, gender, nickname, email, membership_lvl, mail_avert, birthdate, pwd) VALUES (#{firstname}, #{familyname}, #{gender}, #{nickname}, #{email}, #{membership_lvl}, #{mail_avert}, #{birthdate}, #{pwd})")
    @Options(useGeneratedKeys = true, keyProperty = "userid", keyColumn = "iduser", flushCache=true)
    public void addUserToDB(UserMB unUser);
}
