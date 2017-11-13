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

/**
 *
 * @author Ecole
 */
@FacesValidator("validatorYear")
public class YearValidator implements Validator {
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {

        if ((Integer)value > 1997)
            sendMessage("Vous devez être agé d'au moins 18 ans", context, component);
        
    }

    private void sendMessage(String texte, FacesContext context, UIComponent component) {
        FacesMessage msg = new FacesMessage(texte);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(component.getClientId(), msg);
    }
}
