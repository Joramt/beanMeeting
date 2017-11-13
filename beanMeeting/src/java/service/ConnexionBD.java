/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author jlidou
 */
public class ConnexionBD {
    public static SqlSession getSession (){
     SqlSession session = null;
        
        InputStream input = null;
        try {
            String resource = "service/myBatis.xml";
            input = Resources.getResourceAsStream(resource);
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(input);
            ssf.getConfiguration().addMappers("mappers");
            session = ssf.openSession();
            
        } catch (IOException ex) {
  
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
           
            }
        }
        
        return session;
    }
}
