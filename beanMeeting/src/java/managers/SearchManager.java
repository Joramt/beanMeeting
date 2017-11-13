/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.User;
import java.util.ArrayList;
import managedBeans.ConnexionMB;
import managedBeans.InfoMB;
import managedBeans.SearchMB;
import mappers.ConnexionMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ecole
 */
public class SearchManager {
    public static ArrayList<Integer> filterUser(SearchMB uneRecherche){
        ArrayList<Integer> retour = new ArrayList<Integer>();
        SqlSession session = ConnexionBD.getSession();
        retour = (ArrayList) session.selectList("mappers.SearchMapperXML.getDynamic", uneRecherche);
       
        return retour;
    }
}
