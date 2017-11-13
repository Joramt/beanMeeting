/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.FromTo;
import entities.User;
import java.util.ArrayList;
import mappers.WinksMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ruben
 */
public class WinksManager {
        public static ArrayList<User> getAllWinks(int idUser) {
        ArrayList<User> retour = new ArrayList<User>();
        SqlSession session = ConnexionBD.getSession();
        WinksMapper mapper = session.getMapper(WinksMapper.class);
        retour = mapper.getById(idUser);
        return retour;
    }

    public static void addWink(int idfrom, int idto) {
        FromTo wink = new FromTo(idfrom, idto);
        SqlSession session = ConnexionBD.getSession();
        WinksMapper mapper = session.getMapper(WinksMapper.class);
        int retour = mapper.addWink(wink);
        session.commit();
    }

    public static void deleteWink(int idfrom, int idto) {
        FromTo wink = new FromTo(idfrom, idto);
        SqlSession session = ConnexionBD.getSession();
        WinksMapper mapper = session.getMapper(WinksMapper.class);
        int retour = mapper.deleteWink(wink);
        session.commit();
    }
}
