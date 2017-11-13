/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import managedBeans.ConnexionMB;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Ecole
 */
public interface ConnexionMapper {
    
    @Select ("Select * from user where nickname = #{nickname} AND pwd = #{pwd}")
    ConnexionMB checkIdAndPwd(ConnexionMB lesInfos);
}
