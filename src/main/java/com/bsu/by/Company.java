package com.bsu.by;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return name.equals(company.name) &&
                shortTitle.equals(company.shortTitle) &&
                dateUpdate.equals(company.dateUpdate) &&
                address.equals(company.address) &&
                dateFoundation.equals(company.dateFoundation) &&
                countEmployees.equals(company.countEmployees) &&
                auditor.equals(company.auditor) &&
                phone.equals(company.phone) &&
                email.equals(company.email) &&
                branch.equals(company.branch) &&
                activity.equals(company.activity) &&
                link.equals(company.link) &&
                Arrays.equals(info, company.info);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, shortTitle,
                dateUpdate, address, dateFoundation,
                countEmployees, auditor, phone, email,
                branch, activity, link);
        result = 31 * result + Arrays.hashCode(info);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", dateFoundation='" + dateFoundation + '\'' +
                '}';
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
