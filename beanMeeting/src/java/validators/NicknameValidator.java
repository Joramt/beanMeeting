/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import entities.SingletonChecker;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;

/**
 *
 * @author Ecole
 */
@FacesValidator("connectNickname")
public class NicknameValidator implements Validator {
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        
        if(SingletonChecker.checkExistance((String)value, "user", "nickname") == false)
            sendMessage("Vous devez vous inscrire avant de vous connecter", context, component);       
        
    }
    
    private void sendMessage(String texte, FacesContext context, UIComponent component) {
        FacesMessage msg = new FacesMessage(texte);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(component.getClientId(), msg);
    }
}
