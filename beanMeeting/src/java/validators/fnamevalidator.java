/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Ecole
 */
@FacesValidator("fnamevalidator")
public class fnamevalidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        
        
        if(((String)value).length() < 2 )
            sendMessage("Votre nom est trop court", context, component);
        else if(((String)value).length() > 20 )
            sendMessage("Votre nom est trop long", context, component);
          
    }
    
    private void sendMessage(String texte, FacesContext context, UIComponent component){
        FacesMessage msg = new FacesMessage("");
        msg = new FacesMessage(texte);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(component.getClientId(), msg);
    }
    
}
