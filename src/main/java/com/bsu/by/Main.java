package com.bsu.by;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static final String LOG_FILE = "logFile.txt";

    public static void main(String[] args) {

        LOGGER.setLevel(Level.FINE);
        FileHandler filehandler;
        String csvInFileName;
        String csvOutFileName;
        String requestsFileName;
        if (args.length == 3) {
            csvInFileName = args[0];
            csvOutFileName = args[1];
            requestsFileName = args[2];
        } else {
            System.out.println("default filenames");
            csvInFileName = "inputFile.txt";
            csvOutFileName = "outputFile.txt";
            requestsFileName = "requests.txt";
        }

        String line;
        String cvsSplitBy = ";";
        ArrayList<Company> companyList = new ArrayList<>();

        try {
            filehandler = new FileHandler(LOG_FILE, true);
            filehandler.setLevel(Level.FINE);
            SimpleFormatter formatter = new SimpleFormatter();
            filehandler.setFormatter(formatter);
            LOGGER.addHandler(filehandler);
            LOGGER.fine("Program started " + System.lineSeparator());
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvInFileName))) {
            while ((line = br.readLine()) != null) {
                String[] company = line.split(cvsSplitBy);
                for (int j = 0; j < company.length; j++) {
                    company[j] = company[j].toLowerCase();
                }
                companyList.add(new Company(company));
            }
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Missing input file", ex);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error message", ex);
        }
        List<Company> ans = new ArrayList<>();
        try (Scanner sc1 = new Scanner(System.in)) {
            System.out.println("Search by?");
            System.out.println("1 - SQl-request");
            System.out.println("2 - user's input data");
            switch (sc1.nextInt()) {
                case 1 -> {
                    ArrayList<Request> requestList = new ArrayList<>();
                    String line2;
                    try (BufferedReader br2 = new BufferedReader(new FileReader(requestsFileName))) {
                        while ((line2 = br2.readLine()) != null) {
                            requestList.add(new Request(line2));
                        }
                    } catch (FileNotFoundException ex) {
                        LOGGER.log(Level.SEVERE, "Missing input file", ex);
                    } catch (IOException ex) {
                        LOGGER.log(Level.SEVERE, "Error message", ex);
                    }

                    Query q = new Query();
                    for (Request i : requestList) {
                        if (i.isTrue && i.searchBy.equals("shortTitle")) {
                            ans = q.findByShortTitle(companyList, i.searchArgs[0]);
                        }
                        if (i.isTrue && i.searchBy.equals("employeeCount")) {
                            ans = q.findByCountEmployees(companyList,
                                    Integer.parseInt(i.searchArgs[0]),
                                    Integer.parseInt(i.searchArgs[1]));
                        }
                        if (i.isTrue && i.searchBy.equals("activity")) {
                            ans = q.findByActivity(companyList, i.searchArgs[0]);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Search by?");
                    System.out.println("1 - byShortTitle");
                    System.out.println("2 - byBranch");
                    System.out.println("3 - byActivity");
                    System.out.println("4 - byDateFoundation");
                    System.out.println("5 - byCountEmployees");
                    Query q = new Query();
                    try (Scanner sc = new Scanner(System.in)) {
                        switch (sc.nextInt()) {
                            case 1 -> {
                                System.out.println("Insert shortTitle");
                                String sShortTitle = sc.next();
                                ans = q.findByShortTitle(companyList, sShortTitle);
                            }
                            case 2 -> {
                                System.out.println("Insert branch");
                                String sBranch = sc.next();
                                ans = q.findByBranch(companyList, sBranch);
                            }
                            case 3 -> {
                                System.out.println("Insert activity");
                                String sActivity = sc.next();
                                ans = q.findByActivity(companyList, sActivity);
                            }
                            case 4 -> {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                                System.out.println("Insert date from (DD.MM.YYYY)");
                                LocalDate sDateInf = LocalDate.parse(sc.next(), formatter);
                                System.out.println("Insert date by (DD.MM.YYYY)");
                                LocalDate sDateSup = LocalDate.parse(sc.next(), formatter);
                                ans = q.findByDateFoundation(companyList, sDateInf, sDateSup);
                            }
                            case 5 -> {
                                System.out.println("Insert countEmployees from");
                                int sCountEmployeesInf = sc.nextInt();
                                System.out.println("Insert countEmployees by");
                                int sCountEmployeesSup = sc.nextInt();
                                ans = q.findByCountEmployees(companyList, sCountEmployeesInf, sCountEmployeesSup);
                            }
                            default -> throw new IOException("Invalid switcher");
                        }
                    } catch (IOException ex) {
                        LOGGER.log(Level.SEVERE, "Invalid switcher", ex);
                    }
                }
                default -> throw new IOException();
            }
            try (FileWriter writer = new FileWriter(csvOutFileName, false)) {
                for (Company i : ans) {
                    writer.write(i.toString() + "\n");
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Missing output file");
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Invalid switcher");
        }
    }
}
