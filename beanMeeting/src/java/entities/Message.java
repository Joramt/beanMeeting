/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ruben
 */
public class Message implements Serializable {
  private int idmessage;
  private int idfrom;
  private int idto;
  private String objet;
  private String message;
  private Date date;
  private int read;
  private String nickname;

    public Message() {
    }

    public Message(int idmessage, int idfrom, int idto, String objet, String message, Date date, int read) {
        this.idmessage = idmessage;
        this.idfrom = idfrom;
        this.idto = idto;
        this.objet = objet;
        this.message = message;
        this.date = date;
        this.read = read;
    }

    public int getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
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

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int isRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Message{" + "idmessage=" + idmessage + ", idfrom=" + idfrom + ", idto=" + idto + ", objet=" + objet + ", message=" + message + ", date=" + date + ", read=" + read + ", nickname=" + nickname + '}';
    }   
           
}
