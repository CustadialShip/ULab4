package com.bsu.by;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Company {
    private final String name;
    private final String shortTitle;
    private final LocalDate dateUpdate; // ?
    private final String address;
    private final LocalDate dateFoundation;  // ?
    private final int countEmployees;
    private final String auditor;
    private final String phone;
    private final String email;
    private final String branch;
    private final String activity;
    private final String link;
    private final String[] info;


    Company(String[] info) throws IllegalArgumentException {
        if (info.length != 12) {
            throw new IllegalArgumentException("Error: wrong data");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.info = info;
        this.name = info[0];
        this.shortTitle = info[1];
        this.dateUpdate = LocalDate.parse(info[2], formatter);
        this.address = info[3];
        this.dateFoundation = LocalDate.parse(info[4], formatter);
        this.countEmployees = Integer.parseInt(info[5]);
        this.auditor = info[6];
        this.phone = info[7];
        this.email = info[8];
        this.branch = info[9];
        this.activity = info[10];
        this.link = info[11];
    }

    String[] getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return countEmployees == company.countEmployees &&
                name.equals(company.name) &&
                shortTitle.equals(company.shortTitle) &&
                dateUpdate.equals(company.dateUpdate) &&
                address.equals(company.address) &&
                dateFoundation.equals(company.dateFoundation) &&
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
        int result = Objects.hash(name, shortTitle, dateUpdate, address, dateFoundation, countEmployees, auditor, phone, email, branch, activity, link);
        result = 31 * result + Arrays.hashCode(info);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", dateFoundation='" + dateFoundation + '\'' +
                '}' + "    " + countEmployees;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateFoundation() {
        return dateFoundation;
    }

    public int getCountEmployees() {
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
