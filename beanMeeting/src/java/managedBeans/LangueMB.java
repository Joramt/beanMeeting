/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ruben
 */
@ManagedBean
@ViewScoped
public class LangueMB implements Serializable {

    private static String locale = "en";

  public void setLocale(String locale1) {
    this.locale = locale1;
  }

  public synchronized String getLocale() {
    return locale;
  }

  public synchronized void changeLanguage() {
    if (!locale.contains("en")) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
        setLocale("en");
    } else {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
        setLocale("fr");
    }
  }
}
