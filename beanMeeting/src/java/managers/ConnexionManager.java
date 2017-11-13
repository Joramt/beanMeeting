/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import mappers.ConnexionMapper;
import entities.User;
import java.util.ArrayList;
import managedBeans.ConnexionMB;
import mappers.FavorisMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ecole
 */
public class ConnexionManager {
    public static boolean checkIfUserExist(ConnexionMB infoConnexion){
        SqlSession session = ConnexionBD.getSession();
        ConnexionMapper mapper = session.getMapper(ConnexionMapper.class);

        ConnexionMB retour = mapper.checkIdAndPwd(infoConnexion);
        return (retour != null);
    }
}
