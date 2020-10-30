package com.bsu.by;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Query {
    //enum userQuery{byShortTitle, byBranch, byActivity, byDateFoundation, byCountEmployees}

    protected List<Company> findByShortTitle(List<Company> companyList, String shortTitle) {
        List<Company> answer = new ArrayList<>();
        for (Company i : companyList) {
            if (i.getShortTitle().equalsIgnoreCase(shortTitle)) {
                answer.add(i);
            }
        }
        return answer;
    }

    protected List<Company> findByBranch(List<Company> companyList, String branch) {
        List<Company> answer = new ArrayList<>();
        for (Company i : companyList) {
            if (i.getBranch().equalsIgnoreCase(branch)) {
                answer.add(i);
            }
        }
        return answer;
    }

    protected List<Company> findByActivity(List<Company> companyList, String activity) {
        List<Company> answer = new ArrayList<>();
        for (Company i : companyList) {
            if (i.getActivity().equalsIgnoreCase(activity)) {
                answer.add(i);
            }
        }
        return answer;
    }

    protected List<Company> findByCountEmployees(List<Company> companyList,
                                                 int inf, int sup) {
        List<Company> answer = new ArrayList<>();
        for (Company i : companyList) {
            if (i.getCountEmployees() >= inf && i.getCountEmployees() <= sup) {
                answer.add(i);
            }
        }
        return answer;
    }

    protected List<Company> findByDateFoundation(List<Company> companyList,
                                                 LocalDate infDate, LocalDate supDate){
        List<Company> answer = new ArrayList<>();
        for (Company i: companyList){
            if(infDate.isBefore(i.getDateFoundation()) &&
            supDate.isAfter(i.getDateFoundation())){
                answer.add(i);
            }
        }
        return answer;
    }


}
