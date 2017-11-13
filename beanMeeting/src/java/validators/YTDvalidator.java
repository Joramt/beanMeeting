/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import java.util.regex.Pattern;
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
@FacesValidator("ytdvalidator")
public class YTDvalidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        
        if(((String)value).matches("^[A-Z]*"))
            sendMessage("Nombre seulement", context, component);
        
    }
    
  
    
    private void sendMessage(String texte, FacesContext context, UIComponent component) {
        FacesMessage msg = new FacesMessage(texte);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(component.getClientId(), msg);
    }
    
}
