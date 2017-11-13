/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entities.Position;
import entities.User;
import entities.UserInfo;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Ruben
 */
public interface UsersMapper {
    //get tous les users
    @Select("SELECT * FROM user join  picture on picture.iduser=user.iduser where profile=1 order by user.iduser DESC LIMIT 50")
    ArrayList<User> getAll ();
    
    //get user byId
    @Select("SELECT * FROM user join  picture on picture.iduser=user.iduser where profile=1 and user.iduser=#{id}")
    User getUserById(int id);

    //get userInfo pour user byId
    @Select("select * from userinfo where userid=#{id}")
    UserInfo getInfoUserById(int id);
    
    @Select("select * from user where nickname=#{nickname}")
    User getUserByNickname(String nickname);
    
    @Select("SELECT latitude, longitude FROM useradress where userid=#{id}")
    Position getPositionByUserId(int userid);

    //Pour update une user
    @Update("UPDATE user SET firstname=#{firstname}, familyname=#{familyname}, nickname=#{nickname}, email=#{email}, membership_lvl=#{membership_lvl}, mail_avert=#{mail_avert}, birthdate=#{birthdate}, pwd=#{pwd} WHERE iduser=#{iduser}")
    int updateUser(User user);
    
}
