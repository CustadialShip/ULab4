package com.bsu.by;

import java.io.IOException;
import java.util.Date;

public class Company {
    private String name;
    private String shortTitle;
    private String dateUpdate; // ?
    private String address;
    private String dateFoundation;  // ?
    private String countEmployees;
    private String auditor;
    private String phone;
    private String email;
    private String branch;
    private String activity;
    private String link;
    private String[] info;

    Company(String[] info) throws IOException{
        if (info.length != 12) {
            throw new IOException("Error: wrong data");
        }
        this.info = info;
        this.name = info[0];
        this.shortTitle = info[1];
        this.dateUpdate = info[2];
        this.address = info[3];
        this.dateFoundation = info[4];
        this.countEmployees = info[5];
        this.auditor = info[6];
        this.phone = info[7];
        this.email = info[8];
        this.branch = info[9];
        this.activity = info[10];
        this.link = info[11];
    }

    String[] getInfo(){
        return info;
    }

    String getShortTitle(){
        return shortTitle;
    }

    void printCompany() {
        for (String i : info) {
            System.out.println(i);
        }
    }
}
