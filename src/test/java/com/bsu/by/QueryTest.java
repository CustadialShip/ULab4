package com.bsu.by;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QueryTest {
    @Test
    public void findByShortTitleTest() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.2001", "Minsk",
                "01.11.1995", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "03.06.1454", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        List<Company> listAns1 = new ArrayList<>();
        listAns1.add(c1);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c2);
        Assert.assertEquals(listAns1, q.findByShortTitle(list, "dev"));
        Assert.assertEquals(listAns2, q.findByShortTitle(list, "tut"));
    }

    @Test
    public void findByShortTitleTestUpperCase() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.2001", "Minsk",
                "01.11.1995", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "03.06.1454", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c2);
        Assert.assertEquals(listAns2, q.findByShortTitle(list, "TUT"));
    }

    @Test
    public void findByBranchTest() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.2001", "Minsk",
                "01.11.1995", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "03.06.1454", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        List<Company> listAns1 = new ArrayList<>();
        listAns1.add(c1);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c2);
        Assert.assertEquals(listAns1, q.findByBranch(list, "dev"));
        Assert.assertEquals(listAns2, q.findByBranch(list, "tut"));
    }

    @Test
    public void findByBranchTestUpperCase() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.2001", "Minsk",
                "01.11.1995", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "03.06.1454", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c2);
        Assert.assertEquals(listAns2, q.findByBranch(list, "TUT"));
    }

    @Test
    public void findByActivityTest() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.2001", "Minsk",
                "01.11.1995", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "03.06.1454", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        List<Company> listAns1 = new ArrayList<>();
        listAns1.add(c1);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c2);
        Assert.assertEquals(listAns1, q.findByActivity(list, "smt"));
        Assert.assertEquals(listAns2, q.findByActivity(list, "smt2"));
    }

    @Test
    public void findByActivityTestUpperCase() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.2001", "Minsk",
                "01.11.1995", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "03.06.1454", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c2);
        Assert.assertEquals(listAns2, q.findByActivity(list, "SMT2"));
    }


    @Test
    public void findByCountEmployeesTest() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.2001", "Minsk",
                "01.11.1995", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "03.06.1454", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        String[] info3 = new String[]{"mail.ru", "mail", "13.12.1077", "Moscow",
                "06.09.1564", "1000", "", "1954632", "mailru@mail.ru", "main", "smt3", "mail.ru" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        Company c3 = new Company(info3);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        List<Company> listAns1 = new ArrayList<>();
        listAns1.add(c1);
        listAns1.add(c2);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c3);
        Assert.assertEquals(listAns1, q.findByCountEmployees(list, 100, 360));
        Assert.assertEquals(listAns2, q.findByCountEmployees(list, 600, 1000));
    }

    @Test
    public void findByDateFoundationTest() {
        Query q = new Query();
        String[] info1 = new String[]{"dev.by", "dev", "10.12.1001", "Minsk",
                "10.12.1001", "103", "", "1234566", "debv@gmail.com", "dev", "smt", "dev.by" };
        String[] info2 = new String[]{"tut.by", "tut", "04.04.1965", "Gomel",
                "04.04.1965", "304", "", "4321342", "tutby@tut.by", "tut", "smt2", "tut.by" };
        String[] info3 = new String[]{"mail.ru", "mail", "13.12.3077", "Moscow",
                "13.12.3077", "1000", "", "1954632", "mailru@mail.ru", "main", "smt3", "mail.ru" };
        Company c1 = new Company(info1);
        Company c2 = new Company(info2);
        Company c3 = new Company(info3);
        List<Company> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        List<Company> listAns1 = new ArrayList<>();
        listAns1.add(c1);
        listAns1.add(c2);
        List<Company> listAns2 = new ArrayList<>();
        listAns2.add(c3);
        LocalDate d1 = LocalDate.of(0, 1, 1);
        LocalDate d2 = LocalDate.of(2000, 1, 1);
        LocalDate d3 = LocalDate.of(4000, 1, 1);
        Assert.assertEquals(listAns1, q.findByDateFoundation(list, d1, d2));
        Assert.assertEquals(listAns2, q.findByDateFoundation(list, d2, d3));
    }
}