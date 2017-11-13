/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entities.Rating;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


/**
 *
 * @author Ecole
 */
public interface RatingMapper {
    
    @Insert("Insert into rating (idfrom, idto, rate) VALUES (#{idfrom}, #{idto}, #{rate}) ")
    int addRating(Rating unerating);
    
    @Select("SELECT COUNT(*) as NbNote FROM rating where idto = #{idUser} ")
    String getNbVote(int idUser);
    
    @Select(" SELECT AVG(rate) as moyenne FROM rating where idto = #{idUser} ")
    String getAvg(int idUser);
}
