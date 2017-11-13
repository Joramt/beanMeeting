/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.FromTo;
import entities.User;
import java.util.ArrayList;
;
import mappers.FavorisMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ruben
 */


public class FavorisManager {

    public static ArrayList<User> getAllFavoris(int idUser) {
        ArrayList<User> retour = new ArrayList<User>();
        SqlSession session = ConnexionBD.getSession();
        FavorisMapper mapper = session.getMapper(FavorisMapper.class);

        retour = mapper.getById(idUser);
        return retour;
    }

    public static void addFavourite(int idfrom, int idto) {
        FromTo favourite = new FromTo(idfrom, idto);
        SqlSession session = ConnexionBD.getSession();
        FavorisMapper mapper = session.getMapper(FavorisMapper.class);
        int retour = mapper.addFavourite(favourite);
        session.commit();
    }

    public static void deleteFavourite(int idfrom, int idto) {
        FromTo favourite = new FromTo(idfrom, idto);
        SqlSession session = ConnexionBD.getSession();
        FavorisMapper mapper = session.getMapper(FavorisMapper.class);
        int retour = mapper.deleteFavourite(favourite);
        session.commit();
    }
}
