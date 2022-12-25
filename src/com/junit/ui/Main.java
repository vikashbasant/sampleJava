package com.junit.ui;
import com.junit.pojo.Employee;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Employee emp = new Employee();
//        emp.getInfo();

//        emp.updateMobileInfo("mobile", "8789782803");

//        emp.deleteMobileInfo("mobile");

        emp.findSecondWorkingDays();

    }
}
