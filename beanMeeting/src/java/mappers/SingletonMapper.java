/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;


import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Ecole
 */
public interface SingletonMapper {
    
    @Select ("select #{param2} from ${param1} where ${param2}=#{param3}")
    List<String> checkExistance(String table, String column, String strToCheck);
    
}
