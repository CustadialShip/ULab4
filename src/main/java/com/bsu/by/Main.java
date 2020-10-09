package com.bsu.by;

import java.io.*;
import java.util.ArrayList;
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
        if (args.length == 2) {
            csvInFileName = args[0];
            csvOutFileName = args[1];
        } else {
            System.out.println("default filenames");
            csvInFileName = "inputFile.txt";
            csvOutFileName = "outputFile.txt";
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

            for (Company i : companyList) {
                i.printCompany();
            }
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Missing input file", ex);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error message", ex);
        }


        try(FileWriter writer = new FileWriter(csvOutFileName, false))
        {
            for(Company i: companyList) {
                for(String j : i.getInfo()){
                    writer.write(j + cvsSplitBy);
                }
                writer.write("\n");
            }
        }
        catch(IOException ex){
            LOGGER.log(Level.SEVERE, "Missing output file");
        }
        for(Company i : companyList){
            System.out.println(i.toString());
        }
    }
}
