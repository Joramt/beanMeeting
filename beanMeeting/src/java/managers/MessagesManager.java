/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Message;
import java.util.ArrayList;
import mappers.FavorisMapper;
import mappers.MessagesMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ruben
 */
public class MessagesManager {
    public static ArrayList<Message> getAllInbox(int idUser) {
        ArrayList<Message> retour = new ArrayList<Message>();
        SqlSession session = ConnexionBD.getSession();
        MessagesMapper mapper = session.getMapper(MessagesMapper.class);
        retour = mapper.getInboxById(idUser);
        return retour;
    }

        public static ArrayList<Message> getAllOutbox(int idUser) {
        ArrayList<Message> retour = new ArrayList<Message>();
        SqlSession session = ConnexionBD.getSession();
        MessagesMapper mapper = session.getMapper(MessagesMapper.class);
        retour = mapper.getOutboxById(idUser);
        return retour;
    }

    public static void send(Message message) {
        SqlSession session = ConnexionBD.getSession();
        MessagesMapper mapper = session.getMapper(MessagesMapper.class);
        int retour = mapper.addMessage(message);
        session.commit();
    }

    public static void delete(Message message) {
        SqlSession session = ConnexionBD.getSession();
        MessagesMapper mapper = session.getMapper(MessagesMapper.class);
        int retour = mapper.deleteMessageInbox(message.getIdmessage());
        session.commit();
    }
}
