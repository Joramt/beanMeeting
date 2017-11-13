/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entities.FromTo;
import entities.User;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Ruben
 */
public interface WinksMapper {
       //get tous les bisous d'un user
    @Select("select * from wink join user on idfrom=iduser join picture on user.iduser=picture.iduser where idto=#{id} and profile=1")
    ArrayList<User> getById (int id); 
    
    //Pour ajouter un bisous
    @Insert("insert into wink (idfrom, idto) VALUES (#{idfrom}, #{idto})")
    int addWink(FromTo favoris);
    
    //Pour Enlever un bisous
    @Delete("delete from wink  where idfrom=#{idfrom} and idto=#{idto}")
    int deleteWink(FromTo favoris); 
}
