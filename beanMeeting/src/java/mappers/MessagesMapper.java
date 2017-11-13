/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entities.FromTo;
import entities.Message;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Ruben
 */
public interface MessagesMapper {

    //get tous les message d'un user

    @Select("select * from message join user on idfrom=iduser  where idto=#{id}")
    ArrayList<Message> getInboxById(int id);

    //get tous les message d'un user
    @Select("select * from message join user on idto=iduser where idfrom=#{id}")
    ArrayList<Message> getOutboxById(int id);

    //Pour ajouter un message
    //@Insert("INSERT INTO message (idfrom, idto, objet, message, date, read) VALUES (#{idfrom}, #{idto}, #{objet}, #{message}, #{date}, #{read})")
    @Insert("insert into message (idfrom, idto, objet, message) VALUES (#{idfrom}, #{idto}, #{objet}, #{message})")
    int addMessage(Message message);

    //Pour Enlever un message
    @Delete("delete from message where idmessage=#{idmessage}")
    int deleteMessageInbox(int idmessage);
}
