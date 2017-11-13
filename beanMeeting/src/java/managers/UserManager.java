/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Image;
import entities.User;
import java.util.ArrayList;
import managedBeans.InfoMB;
import managedBeans.UserMB;
import mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ecole
 */
public class UserManager {
    public static void addToDB(UserMB unUser, InfoMB uneInfo) {
        SqlSession session = ConnexionBD.getSession();
        UserMapper mapper;
        mapper = session.getMapper(UserMapper.class);
        
        mapper.addUserToDB(unUser);
        session.commit();
       
        Image imageUser = new Image(unUser.getUserid(), "defaultphoto.jpg", true);
        ImagesManager.addImage(imageUser);
            
        
        System.out.println(unUser.getUserid());
        
        uneInfo.setUserid(unUser.getUserid());
        
        mapper.addAdressToDB(uneInfo);
        session.commit();
        
        mapper.addInfoToDB(uneInfo);
        session.commit();
    };
    
}
