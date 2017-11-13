/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Rating;
import entities.User;
import mappers.RatingMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ruben
 */
public class RatingManager {
    //obtenir les ratings par utilisateur
    public static String ratings(User user){
        String retour = "0";
        SqlSession session = ConnexionBD.getSession();
        RatingMapper mapper = session.getMapper(RatingMapper.class);

        retour = mapper.getAvg(user.getIduser());
        return retour;
    }
    
    //obtenir les votes par utilisateur
    public static String votes(User user){
        String retour = "0";
        SqlSession session = ConnexionBD.getSession();
        RatingMapper mapper = session.getMapper(RatingMapper.class);

        retour = mapper.getNbVote(user.getIduser());
        return retour;
    }
    
    //obtenir les ratings par utilisateur
    public static void addVote(Rating unerating){
        SqlSession session = ConnexionBD.getSession();
        RatingMapper mapper = session.getMapper(RatingMapper.class);
        int retour = mapper.addRating(unerating);
        session.commit();
    }
}
