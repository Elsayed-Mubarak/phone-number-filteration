package com.phone.checkphonenumber.logging;

public class ConsoleLogger {
    public void writeInfo(String msg) {
        System.out.println("Info" + msg + " ");
    }

    public void writeData(String msg, Object obj) {
        System.out.println("messege" + msg + "Data" + obj + " ");
    }

    public void writeError(String msg, Exception e) {
        System.err.println("Error: " + msg + ";" + e + " ");
    }
}