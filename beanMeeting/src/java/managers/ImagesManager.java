/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.Image;
import java.util.ArrayList;
import mappers.ImagesMapper;
import org.apache.ibatis.session.SqlSession;
import service.ConnexionBD;

/**
 *
 * @author Ruben
 */
public class ImagesManager {

    //photo par user ID

    public static ArrayList<Image> getPhotosUserById(int idUser) {
        ArrayList<Image> retour = new ArrayList<>();
        SqlSession session = ConnexionBD.getSession();
        ImagesMapper mapper = session.getMapper(ImagesMapper.class);

        retour = mapper.getPhotosUserById(idUser);
        return retour;
    }

    public static void addImage(Image image) {
        SqlSession session = ConnexionBD.getSession();
        ImagesMapper mapper = session.getMapper(ImagesMapper.class);
        int retour = mapper.addImage(image);
        session.commit();
    }

    public static void deleteImage(int idpicture) {
        SqlSession session = ConnexionBD.getSession();
        ImagesMapper mapper = session.getMapper(ImagesMapper.class);
        int retour = mapper.deleteImage(idpicture);
        session.commit();
    }

    public static void setImage(Image image) {
        SqlSession session = ConnexionBD.getSession();
        ImagesMapper mapper = session.getMapper(ImagesMapper.class);
        int retour = mapper.clearProfileImage(image.getIduser());
        session.commit();
        retour = mapper.setImage(image.getIdpicture());
        session.commit();
    }
}
