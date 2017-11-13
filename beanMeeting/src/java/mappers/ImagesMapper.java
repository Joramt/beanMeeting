/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entities.Image;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Ruben
 */
public interface ImagesMapper {
    
    //get photos pour user byId
    @Select("select * from picture where iduser=#{id} order by profile DESC")
    ArrayList<Image> getPhotosUserById(int id);
    
    //Pour ajouter une Image
    @Insert("insert into picture (iduser, photopath, profile) VALUES (#{iduser}, #{photopath}, #{profile})")
    int addImage(Image image);
    
    //Pour Enlever une Image
    @Delete("delete from picture  where idpicture=#{idpicture}")
    int deleteImage(int idpicture); 
    
    //Pour devenir tous le profile vars d'un utilisateur in false
    @Update("update picture set profile=0 WHERE iduser=#{idUser}")
    int clearProfileImage(int idUser);
    
    //Pour devenir tous le profile vars d'un utilisateur in false
    @Update("update picture set profile=1 WHERE idpicture=#{idpicture}")
    int setImage(int idpicture);
}
