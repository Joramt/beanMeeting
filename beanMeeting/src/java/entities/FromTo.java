/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Ruben
 */
public class FromTo implements Serializable {

    private int id;
    private int idfrom;
    private int idto;

    public FromTo() {
    }

    public FromTo(int idfrom, int idto) {
        this.id = 0;
        this.idfrom = idfrom;
        this.idto = idto;
    }

    public FromTo(int id, int idfrom, int idto) {
        this.id = id;
        this.idfrom = idfrom;
        this.idto = idto;
    }

    public int getIdfrom() {
        return idfrom;
    }

    public void setIdfrom(int idfrom) {
        this.idfrom = idfrom;
    }

    public int getIdto() {
        return idto;
    }

    public void setIdto(int idto) {
        this.idto = idto;
    }

    @Override
    public String toString() {
        return "fromTo{" + "id=" + id + ", idfrom=" + idfrom + ", idto=" + idto + '}';
    }

}
