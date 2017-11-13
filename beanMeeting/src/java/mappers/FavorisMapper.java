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
public interface FavorisMapper {
    //get tous les favoris d'un user
    @Select("select * from favorite join user on idto=iduser join picture on user.iduser=picture.iduser where idfrom=#{id} and profile=1")
    ArrayList<User> getById (int id); 
    
    //Pour ajouter un favoris
    @Insert("insert into favorite (idfrom, idto) VALUES (#{idfrom}, #{idto})")
    int addFavourite(FromTo favoris);
    
    //Pour Enlever un favoris
    @Delete("delete from favorite  where idfrom=#{idfrom} and idto=#{idto}")
    int deleteFavourite(FromTo favoris);
}
