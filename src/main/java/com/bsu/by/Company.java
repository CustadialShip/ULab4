package com.bsu.by;

public class Company {
    private final String name;
    private final String shortTitle;
    private final String dateUpdate; // ?
    private final String address;
    private final String dateFoundation;  // ?
    private final String countEmployees;
    private final String auditor;
    private final String phone;
    private final String email;
    private final String branch;
    private final String activity;
    private final String link;
    private final String[] info;


    Company(String[] info) throws IllegalArgumentException{
        if (info.length != 12) {
            throw new IllegalArgumentException("Error: wrong data");
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

    void printCompany() {
        for (String i : info) {
            System.out.println(i);
        }
    }

    public String getName() {
        return name;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public String getAddress() {
        return address;
    }

    public String getDateFoundation() {
        return dateFoundation;
    }

    public String getCountEmployees() {
        return countEmployees;
    }

    public String getAuditor() {
        return auditor;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBranch() {
        return branch;
    }

    public String getActivity() {
        return activity;
    }

    public String getLink() {
        return link;
    }

    public String getShortTitle() {
        return shortTitle;
    }
}
