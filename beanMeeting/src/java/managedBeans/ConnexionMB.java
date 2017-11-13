    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import managers.ConnexionManager;

/**
 *
 * @author Ecole
 */
@ManagedBean
@SessionScoped
public class ConnexionMB implements Serializable {
    
    private String nickname;
    private String pwd;
    
    
    public ConnexionMB(String nickname, String pwd) {
        this.nickname = nickname;
        this.pwd = pwd;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public void connect(){
        
    }
    
    /**
     * Creates a new instance of ConnexionMB
     */
    public ConnexionMB() {
    }
    
}
