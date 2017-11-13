/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ecole
 */
@ManagedBean
@RequestScoped
public class ListBean {
    
    private int day;
    private int month;
    private int year;

    private List dayList = new ArrayList<Integer>();
    private List YearList = new ArrayList<Integer>();
    private List weightList = new ArrayList<Integer>();
    private Map<String, Integer> MonthList;

    public List getWeightList() {
        return weightList;
    }

    public void setWeightList(List weightList) {
        this.weightList = weightList;
    }
    
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Map<String, Integer> getMonthList() {
        return MonthList;
    }

    public void setMonthList(Map<String, Integer> MonthList) {
        this.MonthList = MonthList;
    }

    public List getDayList() {
        return dayList;
    }

    public void setDayList(List dayList) {
        this.dayList = dayList;
    }

    public List getYearList() {
        return YearList;
    }

    public void setYearList(List YearList) {
        this.YearList = YearList;
    }

    public void populateList(List aList, int beggining, int size, boolean asc) {
        if (asc) {
            for (int i = beggining; i <= size; i++) {
                aList.add(i);
            }
        } else {
            for (int i = size; i >= beggining; i--) {
                aList.add(i);
            }
        }
    }

    public void populateMonthList(Map monthList) {
        monthList.put("Janvier", 0);
        monthList.put("Fevrier", 1);
        monthList.put("Mars", 2);
        monthList.put("Avril", 3);
        monthList.put("Mai", 4);
        monthList.put("Juin", 5);
        monthList.put("Juillet", 6);
        monthList.put("Aout", 7);
        monthList.put("Septembre", 8);
        monthList.put("Octobre", 9);
        monthList.put("Novembre", 10);
        monthList.put("Decembre", 11);
    }

    @PostConstruct
    public void init() {
        MonthList = new LinkedHashMap<String, Integer>();
        populateList(dayList, 1, 31, true);
        populateList(YearList,  1900, 2015, false);
        populateList(weightList,  0, 250, true);
        populateMonthList(MonthList);
        System.out.println("POSTCONSTRUCT");
    }

    
    public ListBean() {
    }
    
}
