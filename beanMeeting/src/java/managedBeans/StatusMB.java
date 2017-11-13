/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entities.Position;
import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import managers.UsersManager;

/**
 *
 * @author Ruben
 */
@ManagedBean
@ApplicationScoped
public class StatusMB implements Serializable {

    private HashMap<Integer, Boolean> status; //userId, nothing.  If the key exists the user is online
    private HashMap<Integer, Position> position; //userId, position
    
    
    /**
     * Creates a new instance of statusMB
     */
    public StatusMB() {
    }

    @PostConstruct
    public void initData() {
        System.out.println("Dans le StatusMB");
        status = new HashMap<>();
        position = new HashMap<>();/*
        
        status.put(4, false);
        position.put(4, new Position(45.5017, 73.5673));*/
    }
    
    public void addConnectedUser(int idUser, Position unePosition){
        System.out.println("test");
        System.out.println(idUser);
        System.out.println(unePosition);
        status.put(idUser, false);
        position.put(idUser, unePosition);
    }
    
    public HashMap<Integer, Boolean> getStatus() {
        return status;
    }

    public void setStatus(HashMap<Integer, Boolean> status) {
        this.status = status;
    }

    public HashMap<Integer, Position> getPosition() {
        return position;
    }

    public void setPosition(HashMap<Integer, Position> position) {
        this.position = position;
    }

    //get all user online
    public ArrayList<User> getAll() {
        ArrayList<User> retour = new ArrayList<User>();
        for (Entry<Integer, Boolean> entry : status.entrySet()) {
            int userId = entry.getKey();
            User user = UsersManager.getUserById(userId);
            retour.add(user);
        }
        return retour;
    }

    //if it is a status, then the user is online
    public String isOnline(int userId) {
        return (status.containsKey(userId) ? "true" : "false");
    }

    //if it not a status, then the user is offline
    public String isOffline(int userId) {
        return (status.containsKey(userId) ? "false" : "true");
    }
    
    public String numOnline(User user){        
        return String.valueOf(status.size()-(status.containsKey(user.getIduser()) ? 1 : 0));
    }
    
    
    //formula pris de http://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi
    public static double CalculeDistance(Position position1, Position position2) {

        final int R = 6371; // Radius of the earth
        double lat1 = position1.getLatitude();
        double lat2 = position2.getLatitude();
        double lon1 = position1.getLongitude();
        double lon2 = position2.getLongitude();
        double el1 = 0; //altitude
        double el2 = 0; //altitude
        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    //if it is a position information
    public String isLocated(int userId) {
        return (position.containsKey(userId) ? "true" : "false");
    }

    public String distance(int userId1, int userId2) {
        String retour = "-m";
        if (position.containsKey(userId1) && position.containsKey(userId2)) {
            double dist = CalculeDistance(position.get(userId1), position.get(userId2));
            if (dist < 1000) {
                retour = String.format("%.0f", dist) + "m";
            } else {
                retour = String.format("%.1f", dist / 1000) + "km";
            }
        }
        return retour;
    }
}
