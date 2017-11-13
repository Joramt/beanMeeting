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
@FacesValidator("passwordValidator")
public class PwdValidator implements Validator {
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        
        if(((String)value).length() < 5 )
            sendMessage("Votre mot de passe doit faire 5 lettre au minimum", context, component);
        else if(((String)value).length() > 20 )
            sendMessage("Votre mot de passe trop long", context, component);
        else if( ((String)value).matches("^[a-zA-Z]+") )
            sendMessage("Votre mot de passe doit contenir au moins un chiffre", context, component);

        else if(!((String)value).substring(0,1).matches("[A-Z]"))
            sendMessage("Votre mot de passe doit commencer par une majuscule", context, component);
    }
    
    private void sendMessage(String texte, FacesContext context, UIComponent component) {
        FacesMessage msg = new FacesMessage(texte);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(component.getClientId(), msg);
    }
}
