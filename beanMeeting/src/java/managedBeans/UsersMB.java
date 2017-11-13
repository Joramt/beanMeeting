/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entities.Image;
import entities.Message;
import entities.Position;
import entities.Rating;
import entities.User;
import entities.UserInfo;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import managers.ConnexionManager;
import managers.EmailManager;
import managers.FavorisManager;
import managers.ImagesManager;
import managers.MessagesManager;
import managers.RatingManager;
import managers.UsersManager;
import managers.WinksManager;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Ruben
 */
@ManagedBean
@SessionScoped
public class UsersMB implements Serializable {

    private static ArrayList<User> allUsers;
    private ArrayList<User> mesFavoris;
    private int numFavoris; //nombre de favoris
    private ArrayList<User> mesBisous;
    private int numBisous; //nombre de Bisous
    private ArrayList<Message> mesInboxMessages;
    private ArrayList<Message> mesOutboxMessages;
    private int numMessages; //nombre de messages inbox
    private String nickname;
    private String pwd;

    private User userTo;
    
    private User currentUser;
    private Message message;
    
    @ManagedProperty(value="#{connexionMB}")
    private ConnexionMB laConnexion;
    
    @ManagedProperty(value="#{statusMB.status}")
    private HashMap<Integer, Boolean> status;
    
    @ManagedProperty(value="#{statusMB.position}")
    private HashMap<Integer, Position> position;
    
    private String rating;
    
    public UsersMB() {
    }

    @PostConstruct
    public void initData() {
        System.out.println("Dans le USERSMB");
        allUsers = UsersManager.getAll();
        setCurrentUser(new User());
    }
    
    public static void updateUsers(){
        
        allUsers = UsersManager.getAll();
    }
    
    public void connect(){
        /*System.out.println("PWD" + this.laConnexion.getPwd());
        System.out.println("NCK" + this.laConnexion.getNickname());*/
        ConnexionMB uneConnexion = new ConnexionMB(this.nickname, this.pwd);
        // true si le user est bien dans la DB
        boolean isUserInDB = ConnexionManager.checkIfUserExist(uneConnexion);
        
        if(isUserInDB){
            setCurrentUser(UsersManager.getUserByNickname(this.nickname));
            Position laPosition = UsersManager.getPositionByUserId(currentUser.getIduser());
            
            System.out.println(laPosition);
            System.out.println(currentUser.getIduser());
            
            //Status.addConnectedUser(currentUser.getIduser(), laPosition);
            status.put(currentUser.getIduser(), false);
            position.put(currentUser.getIduser(), laPosition);
            System.out.println(status.toString());
            System.out.println(status.size());
        }
        else
            setCurrentUser(new User());
    }
    
    public String disconnect(){
        
        System.out.println("Avant" + status.size());
        System.out.println(status.toString());
        System.out.println("Contains" + status.containsKey(currentUser.getIduser()));
        
        status.remove(currentUser.getIduser());
        System.out.println("APRES" + status.size());
        System.out.println(status.toString());
        System.out.println("Contains" + status.containsKey(currentUser.getIduser()));
        
        setCurrentUser(new User());
        return "index.xhtml";
        
        
    }

    //Setters et Getters
    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<User> allUsers) {
        this.allUsers = allUsers;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public ConnexionMB getLaConnexion() {
        return laConnexion;
    }

    public void setLaConnexion(ConnexionMB laConnexion) {
        this.laConnexion = laConnexion;
    }

    public HashMap<Integer, Position> getPosition() {
        return position;
    }

    public void setPosition(HashMap<Integer, Position> position) {
        this.position = position;
    }
    
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public HashMap<Integer, Boolean> getStatus() {
        return status;
    }

    public void setStatus(HashMap<Integer, Boolean> status) {
        this.status = status;
    }
    
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        //Favoris
        this.mesFavoris = FavorisManager.getAllFavoris(currentUser.getIduser());
        this.numFavoris = this.mesFavoris.size();
    }

    public ArrayList<User> getMesFavoris() {
        return mesFavoris;
    }

    public void setMesFavoris(ArrayList<User> mesFavoris) {
        this.mesFavoris = mesFavoris;
    }

    public int getNumFavoris() {
        return numFavoris;
    }

    public void setNumFavoris(int numFavoris) {
        this.numFavoris = numFavoris;
    }

    public ArrayList<User> getMesBisous() {
        return mesBisous;
    }

    public void setMesBisous(ArrayList<User> mesBisous) {
        this.mesBisous = mesBisous;
    }

    public int getNumBisous() {
        this.mesBisous = WinksManager.getAllWinks(currentUser.getIduser());
        numBisous = this.mesBisous.size();
        return numBisous;
    }

    public void setNumBisous(int numBisous) {
        this.numBisous = numBisous;
    }

    public ArrayList<Message> getMesInboxMessages() {
        this.mesInboxMessages = MessagesManager.getAllInbox(currentUser.getIduser());
        this.numMessages = this.mesInboxMessages.size();
        message = new Message();
        return mesInboxMessages;
    }

    public void setMesInboxMessages(ArrayList<Message> mesInboxMessages) {
        this.mesInboxMessages = mesInboxMessages;
    }

    public ArrayList<Message> getMesOutboxMessages() {
        this.mesOutboxMessages = MessagesManager.getAllOutbox(currentUser.getIduser());
        return mesOutboxMessages;
    }

    public void setMesOutboxMessages(ArrayList<Message> mesOutboxMessages) {
        this.mesOutboxMessages = mesOutboxMessages;
    }

    public int getNumMessage() {
        this.mesInboxMessages = MessagesManager.getAllInbox(currentUser.getIduser());
        this.numMessages = this.mesInboxMessages.size();
        return numMessages;
    }

    public void setNumMessage(int numMessage) {
        this.numMessages = numMessage;
    }

    public int getNumMessages() {
        return numMessages;
    }

    public void setNumMessages(int numMessages) {
        this.numMessages = numMessages;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
       
    //pour savoir s'utilisateur est favoris ou non
    public String isFavorite(User userToTest) {
        boolean retour = false;
        for (User user : mesFavoris) {
            if (user.getIduser() == userToTest.getIduser()) {
                retour = true;
                break;
            }
        }
        return (retour ? "star" : "star-o");
    }

    //Action pour aller au profile
    public String toProfile(User userTo) {
        this.userTo = userTo;
        return "profile";
    }

    //Action pour aller au profile
    public String toProfileUserId(int userId) {
        this.userTo = UsersManager.getUserById(userId);
        return "profile";
    }

    //Action pour aller au favoris
    public String toFavorites() {
        return "favoris";
    }

    //Action pour aller au profile
    public String toMessage(User userTo) {
        this.userTo = userTo;
        this.message = new Message();
        return "message";
    }

    //Pour Ajouter ou enlever favorite
    public void addRemoveFavorite(User userToTest) {
        boolean retour = true;
        for (User user : mesFavoris) {
            if (user.getIduser() == userToTest.getIduser()) {
                FavorisManager.deleteFavourite(currentUser.getIduser(), userToTest.getIduser());
                mesFavoris.remove(user);
                retour = false;
                break;
            }
        }
        if (retour) {
            FavorisManager.addFavourite(currentUser.getIduser(), userToTest.getIduser());
            sendNotification(currentUser, "Favoris");
            mesFavoris.add(userToTest);
        }
        this.numFavoris = this.mesFavoris.size();
    }

    //Pour savoir si on a un utilisateur connecté et changé le menu
    public boolean isConnected() {
        return (currentUser.getIduser() != 0);
    }

    //pour trouver les photos par UserId
    public ArrayList<Image> getPhotosByUserID(int userId) {
        return ImagesManager.getPhotosUserById(userId);
    }

    //pour trouver les info par UserId
    public UserInfo getInfoByUserID(int userId) {
        return UsersManager.getInfoUserById(userId);
    }

    //pour cacher le profile du meme utilisateur
    public boolean isNotMe(int userId) {
        return (userId != currentUser.getIduser());
    }

    //Winks
    public void sendWink(User userToSend) {
        this.userTo = userToSend;
        WinksManager.addWink(currentUser.getIduser(), userToSend.getIduser());
        sendNotification(userToSend, "Bisous");
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", currentUser.getNickname() + ": Ton bisous à " + userToSend.getNickname() + " a été envoyé");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteWink(User userToDelete) {
        WinksManager.deleteWink(userToDelete.getIduser(), currentUser.getIduser());
    }

    //Envoyer courriel
    public String send(Message message) {
        message.setIdfrom(currentUser.getIduser());
        message.setIdto(userTo.getIduser());
        message.setDate(new Date());
        message.setRead(0);
        MessagesManager.send(message);
        return "courriel";
    }

    //Envoyer message
    public void deleteMessage(Message message) {
        MessagesManager.delete(message);
    }

    //Lecture message
    public String readMessage(Message message) {
        this.message = message;
        this.userTo = UsersManager.getUserById(message.getIdfrom());
        return "readMessage.xhtml";
    }

    //Repondre message
    public String replyMessage(Message message) {
        this.message = message;
        this.message.setObjet("RE: " + this.message.getObjet());
        this.message.setMessage("<div><br></div><span style=\"color: rgb(51, 51, 255);\">===========================<br>Ancien message</span><div><span style=\"font-size: 13.3333px; color: rgb(51, 51, 255);\">===========================</span></div><div><br></div>" + this.message.getMessage());
        this.userTo = UsersManager.getUserById(message.getIdfrom());
        return "message.xhtml";
    }

    //Ajouter une image et le sauver dans le repertoire d'images
    public void addImage(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        if (uploadedFile != null) {
            try {
                //ajoute l'information image à la base de données
                Image image = new Image(currentUser.getIduser(), uploadedFile.getFileName(), false);
                ImagesManager.addImage(image);
                //saugarde l'image en un fichier
                ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String folder = ctx.getRealPath("/images");
                File file = new File(folder, uploadedFile.getFileName());
                if (!file.exists()){
                    file.createNewFile();
                }                
                Files.copy(uploadedFile.getInputstream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                RequestContext.getCurrentInstance().execute("PF('fileUploadWidgetVar').reset();");
            } catch (IOException ex) {
                Logger.getLogger(UsersMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //delete une image
    public void deleteImage(Image image) {
        ImagesManager.deleteImage(image.getIdpicture());
    }

    //set une image
    public void setImage(Image image) {
        ImagesManager.setImage(image);
    }
    
    //Envoyer un courriel
    public void sendNotification(User userToSend, String type){
        if (userToSend.getMail_avert()==1){
            EmailManager.sendMail(userToSend, type);
        }
    }
    
    //update user
    public void updateUser(){
        UsersManager.updateUser(currentUser);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", currentUser.getNickname() + ": Ton profile a été modifié");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    //update user to premium
    public void changeToPremium(){
        currentUser.setMembership_lvl(1);
        UsersManager.updateUser(currentUser);        
    }
    
    //Check limite photos
    public boolean checkLimit(){
        int limite = 2;
        int quantitePhoto = getPhotosByUserID(currentUser.getIduser()).size();
        if (currentUser.estPremium()){
            limite = 5;
        }
        return (quantitePhoto<limite);
    }
    
    //ratings
    public String ratingValue(User user){
        String retour = "0";
        if (user!=null){
            retour = RatingManager.ratings(user);
        }
        if (retour==null)
            retour ="0";
        retour = String.format("%.2f", Float.valueOf(retour));
        return retour;
    }
    
    public String votes(User user){
        String retour = "0";
        if (user!=null){
            retour = RatingManager.votes(user);
        }        
        if (retour==null)
            retour ="0";
        //retour = String.format("%.2f", Float.valueOf(retour));
        return retour;
    }
    
    public void addVote(User user){
        Rating rating = new Rating(String.valueOf(currentUser.getIduser()), String.valueOf(user.getIduser()), this.rating);
        RatingManager.addVote(rating);
        this.rating = "0";
    }
}
