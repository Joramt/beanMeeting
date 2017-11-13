/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.SingletonChecker;
import java.util.List;
import mappers.FavorisMapper;
import mappers.SingletonMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ecole
 */
public class SingletonManager {
    
    public static boolean checkExistance(SingletonChecker unSingleton){
        boolean retour = true;
        SqlSession session = ConnexionBD.getSession();
        SingletonMapper mapper = session.getMapper(SingletonMapper.class);
        String strToCheck = unSingleton.getStrToCheck();
        String column = unSingleton.getColumn();
        String table = unSingleton.getTable();

        List<String> nickname = mapper.checkExistance(table, column, strToCheck);
        
        if(nickname.size() == 0)
            retour = false;
        
        System.out.println("comeone");
        System.out.println("Results : " + nickname.size());
        return retour;
    }
}
