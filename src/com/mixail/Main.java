package com.mixail;

import com.mixail.util.TimeManager;

public class Main {

    public static void main(String[] args) {
        String filePath = args[0];
        System.out.println("Maximum employees in office :" + TimeManager.getMaxOfEmployees(filePath));
    }
}
