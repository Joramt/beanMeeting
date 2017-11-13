/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import managers.SingletonManager;

/**
 *
 * @author Ecole
 */
public class SingletonChecker {
    
    private String strToCheck;
    private String table;
    private String column;

    public SingletonChecker(String strToCheck, String table, String column) {
        this.strToCheck = strToCheck;
        this.table = table;
        this.column = column;
    }
        
    public static boolean checkExistance(String strToCheck, String table, String column){
        SingletonChecker unSingleton = new SingletonChecker(strToCheck, table, column);
        
        return SingletonManager.checkExistance(unSingleton);
    }
    
    public String getStrToCheck() {
        return strToCheck;
    }

    public void setStrToCheck(String strToCheck) {
        this.strToCheck = strToCheck;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
    
    
}
