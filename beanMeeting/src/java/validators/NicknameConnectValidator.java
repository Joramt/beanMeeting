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
@FacesValidator("nicknameValidator")
public class NicknameConnectValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        
        if(SingletonChecker.checkExistance((String)value, "user", "nickname") == true)
            sendMessage("Le pseudo que vous avez choisi existe deja", context, component);
        else if(((String)value).length() < 2 )
            sendMessage("Votre pseudo est trop court", context, component);
        else if(((String)value).length() > 20 )
            sendMessage("Votre nom pseudo trop long", context, component);
       
    }
    
    private void sendMessage(String texte, FacesContext context, UIComponent component) {
        FacesMessage msg = new FacesMessage(texte);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(component.getClientId(), msg);
    }
}
