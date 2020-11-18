package com.bsu.by;

class Request {
    String searchBy;
    boolean isTrue;
    String[] searchArgs = new String[2];

    Request(String request) {
        request = request.toLowerCase();
        this.isTrue = false;
        String[] reqSplit = request.split(" ");
        if (reqSplit.length == 7 && (reqSplit[0] + " " + reqSplit[1] + " " + reqSplit[3] + " "
                + reqSplit[4] + " " + reqSplit[5]).equals("select from where shorttitle =")) {
            this.isTrue = true;
            this.searchBy = "shortTitle";
            this.searchArgs[0] = reqSplit[6];
        } else if (reqSplit.length == 7 && (reqSplit[0] + " " + reqSplit[1] + " " + reqSplit[3] + " "
                + reqSplit[4] + " " + reqSplit[5]).equals("select from where activity =")) {
            this.isTrue = true;
            this.searchBy = "activity";
            this.searchArgs[0] = reqSplit[6];
        } else if (reqSplit.length == 9 && (reqSplit[0] + " " + reqSplit[1] +
                " " + reqSplit[3] + " " + reqSplit[4] + " " + reqSplit[5]
                + " " + reqSplit[7]).equals("select from where employeecount between and")) {
            this.isTrue = true;
            this.searchBy = "employeeCount";
            searchArgs[0] = reqSplit[6];
            searchArgs[1] = reqSplit[8];
        }
    }
}
