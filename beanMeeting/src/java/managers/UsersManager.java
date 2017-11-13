/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Image;
import entities.Position;
import entities.User;
import entities.UserInfo;
import java.io.Serializable;
import java.util.ArrayList;
import mappers.UsersMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ruben
 */
public class UsersManager implements Serializable {

    //All the Users
    public static ArrayList<User> getAll() {
        ArrayList<User> retour = new ArrayList<User>();
        SqlSession session = ConnexionBD.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);

        retour = mapper.getAll();
        return retour;
    }

    //USer par ID
    public static User getUserByNickname(String userNickname) {
        User retour = new User();
        SqlSession session = ConnexionBD.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);

        retour = mapper.getUserByNickname(userNickname);
        return retour;
    }
    
    public static User getUserById(int idUser) {
        User retour = new User();
        SqlSession session = ConnexionBD.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);

        retour = mapper.getUserById(idUser);
        return retour;
    }

    //info par user ID
    public static UserInfo getInfoUserById(int idUser) {
        UserInfo retour = new UserInfo();
        SqlSession session = ConnexionBD.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);

        retour = mapper.getInfoUserById(idUser);
        return retour;
    }
    
    public static Position getPositionByUserId(int idUser){
        Position retour = new Position();
        SqlSession session = ConnexionBD.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);

        retour = mapper.getPositionByUserId(idUser);
        return retour;
    }

    //update user
    public static void updateUser(User user){
        SqlSession session = ConnexionBD.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        int retour = mapper.updateUser(user);
        session.commit(); 
    }
    
}
