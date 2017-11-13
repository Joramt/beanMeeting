/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ecole
 */
public class Rating {
    private String idfrom;
    private String idto;
    private String rate;

    public Rating(String idfrom, String idto, String rate) {
        this.idfrom = idfrom;
        this.idto = idto;
        this.rate = rate;
    }

    public Rating() {
    }

    public String getIdfrom() {
        return idfrom;
    }

    public void setIdfrom(String idfrom) {
        this.idfrom = idfrom;
    }

    public String getIdto() {
        return idto;
    }

    public void setIdto(String idto) {
        this.idto = idto;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    
    
}
