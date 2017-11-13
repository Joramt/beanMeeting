/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import managers.SearchManager;
import managers.UsersManager;

/**
 *
 * @author Ecole
 */
@ManagedBean
@RequestScoped
public class SearchMB implements Serializable{

    private String eyecolor;
    private String haircolor;
    private String sizemin;
    private String sizemax;
    private String weightmax;
    private String weightmin;
    private String nationality;
    private String metresmin;
    private String metresmax;
    private String centimetresmin;
    private String centimetresmax;
    private String country;
    private String titre;
    private int drugs;
    private int tobacco;
    private int alcohol;
    private boolean drugsChecked;
    private boolean tobaccoChecked;
    private boolean alcoholChecked;
    private boolean resultDone;
    private ArrayList<Integer> searchResult;
    private ArrayList<User> lesUsers;
    
    @PostConstruct
    public void initData(){
        searchResult = new ArrayList<Integer>();
        lesUsers = new ArrayList<User>();
        resultDone = true;
        metresmax = "0";
        metresmin = "0";
        centimetresmax = "0";
        centimetresmin = "0";
        titre = "Trouvez la personne qu'il vous faut";
    }
    
    public SearchMB(String eyecolor, String haircolor, String sizemax, String sizemin, String weightmax, String weightmin, String nationality, String metresmin, String metresmax, String centimetresmin, String centimetresmax, String country, int drugs, int tobacco, int alcohol, boolean drugsChecked, boolean tobaccoChecked, boolean alcoholChecked) {
        this.eyecolor = eyecolor;
        this.haircolor = haircolor;
        this.sizemax = sizemax;
        this.sizemin = sizemin;
        this.weightmax = weightmax;
        this.weightmin = weightmin;
        this.nationality = nationality;
        this.metresmin = metresmin;
        this.metresmax = metresmax;
        this.centimetresmin = centimetresmin;
        this.centimetresmax = centimetresmax;
        this.country = country;
        this.drugs = drugs;
        this.tobacco = tobacco;
        this.alcohol = alcohol;
        this.drugsChecked = drugsChecked;
        this.tobaccoChecked = tobaccoChecked;
        this.alcoholChecked = alcoholChecked;
    }
    
    
    
    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public boolean isResultDone() {
        return resultDone;
    }
    
    public void setResultDone(boolean resultDone) {
        this.resultDone = resultDone;
    }

    public ArrayList<User> getLesUsers() {
        return lesUsers;
    }

    public void setLesUsers(ArrayList<User> lesUsers) {
        this.lesUsers = lesUsers;
    }
    
    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public String getSizemin() {
        return sizemin;
    }

    public void setSizemin(String sizemin) {
        this.sizemin = sizemin;
    }

    public ArrayList<Integer> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(ArrayList<Integer> searchResult) {
        this.searchResult = searchResult;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getSizemax() {
        return sizemax;
    }

    public void setSizemax(String sizemax) {
        this.sizemax = sizemax;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getWeightmax() {
        return weightmax;
    }

    public void setWeightmax(String weightmax) {
        this.weightmax = weightmax;
    }

    public String getWeightmin() {
        return weightmin;
    }

    public void setWeightmin(String weightmin) {
        this.weightmin = weightmin;
    }

    public String getMetresmin() {
        return metresmin;
    }

    public void setMetresmin(String metresmin) {
        this.metresmin = metresmin;
    }

    public String getMetresmax() {
        return metresmax;
    }

    public void setMetresmax(String metresmax) {
        this.metresmax = metresmax;
    }

    public String getCentimetresmin() {
        return centimetresmin;
    }

    public void setCentimetresmin(String centimetresmin) {
        this.centimetresmin = centimetresmin;
    }

    public String getCentimetresmax() {
        return centimetresmax;
    }

    public void setCentimetresmax(String centimetresmax) {
        this.centimetresmax = centimetresmax;
    }
    
    public int getDrugs() {
        return drugs;
    }

    public void setDrugs(int drugs) {
        this.drugs = drugs;
    }

    public int getTobacco() {
        return tobacco;
    }

    public void setTobacco(int tobacco) {
        this.tobacco = tobacco;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public boolean isDrugsChecked() {
        return drugsChecked;
    }

    public void setDrugsChecked(boolean drugsChecked) {
        this.drugsChecked = drugsChecked;
        if(drugsChecked)
            this.drugs = 1;
        else
            this.drugs = 0;
    }

    public boolean isTobaccoChecked() {
        return tobaccoChecked;
    }

    public void setTobaccoChecked(boolean tobaccoChecked) {
        this.tobaccoChecked = tobaccoChecked;
        if(tobaccoChecked)
            this.tobacco = 1;
        else
            this.tobacco = 0;
    }

    public boolean isAlcoholChecked() {
        return alcoholChecked;
    }

    public void setAlcoholChecked(boolean alcoholChecked) {
        this.alcoholChecked = alcoholChecked;
        if(alcoholChecked)
            this.alcohol = 1;
        else
            this.alcohol = 0;
    }

    public SearchMB() {
    }
    
    
    public void action(){
        
        lesUsers = new ArrayList<User>();
        searchResult = new ArrayList<Integer>();
        
        System.out.println(lesUsers.size());
        System.out.println(searchResult.size());
        
        this.sizemax = this.metresmax + "." + this.centimetresmax;
        this.sizemin = this.metresmin + "." + this.centimetresmin;
        
        SearchMB laRecherche = new SearchMB(this.eyecolor, this.haircolor, this.sizemax, this.sizemin, this.weightmax, this.weightmin, this.nationality, this.metresmin, this.metresmax, this.centimetresmin, this.centimetresmax, this.country, this.drugs, this.tobacco, this.alcohol, this.drugsChecked, this.tobaccoChecked, this.alcoholChecked);
        

        searchResult = SearchManager.filterUser(laRecherche);
        System.out.println(searchResult.toString());
        
        for(int i=0; i < searchResult.size(); i++)
            lesUsers.add(i, UsersManager.getUserById(searchResult.get(i)));
        
        if(searchResult.size() > 1)
            titre = "Resultats : " + searchResult.size() + " personnes trouvées";
        else 
            titre = "Resultats : " + searchResult.size() + " personne trouvée";
        setResultDone(true);

    }

    @Override
    public String toString() {
        return "SearchMB{" + "eyecolor=" + eyecolor + ", haircolor=" + haircolor + ", sizemin=" + sizemin + ", sizemax=" + sizemax + ", weightmax=" + weightmax + ", weightmin=" + weightmin + ", nationality=" + nationality + ", metresmin=" + metresmin + ", metresmax=" + metresmax + ", centimetresmin=" + centimetresmin + ", centimetresmax=" + centimetresmax + ", country=" + country + ", drugs=" + drugs + ", tobacco=" + tobacco + ", alcohol=" + alcohol + '}';
    }
    

    
    
    
    
}
