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
@FacesValidator("emailValidator")
public class EmailValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        
        if( !((String)value).contains("@") )
            sendMessage("Votre email doit au moins contenir un '@'", context, component);
        else if( !((String)value).contains(".") )
            sendMessage("Votre email doit au moins contenir un '.'", context, component);
        else if(!((String)value).substring( ((String)value).indexOf("@"), ((String)value).length()).contains(".") )
            sendMessage("Votre email doit finir par une extension ( .foo) ", context, component);
        else if(((String)value).substring( (((String)value).indexOf("@")+1), ((String)value).length()).equals("@") )
            sendMessage("Votre email doit contenir un nom de domaine( bar@foo) ", context, component);
        else if(((String)value).substring( (((String)value).indexOf("@")+1), (((String)value).lastIndexOf(".")) ).isEmpty() )
           sendMessage("Votre email doit contenir un nom de domaine( bar@foo) ", context, component);
        else if(((String)value).substring( (((String)value).indexOf(".")+1), ((String)value).length()).isEmpty() )
            sendMessage("L'extension de votre email ne peut Ãªtre vide ( bar@bar.foo )", context, component);
    }
    
    private void sendMessage(String texte, FacesContext context, UIComponent component) {
        FacesMessage msg = new FacesMessage(texte);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(component.getClientId(), msg);
    }
    
}
