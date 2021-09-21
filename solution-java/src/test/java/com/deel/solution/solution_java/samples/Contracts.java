package com.deel.solution.solution_java.samples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Contracts {

    public static Map<String, String> fixedRate_ContractGeneralInfo(){
        // Create a map for values to input field name
        // mapping key === input field name
        // mapping value === input value
        Map<String, String> contract = new HashMap<>();
        contract.put("input[name=name]", "Web Automation 001 - Fixed Rate");
        contract.put("input[name=jobTitle]", "Quality Assurance Engineer");
        contract.put("input[name=seniorityLevel]", "3");
        contract.put("textarea[name=scope]", "I'm a good QA engineer");

        // contract date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String contractDate = dateFormat.format(calendar.getTime());
        contract.put("div[name=effectiveDate]", contractDate);


        //complete the execution of the method contract
        return contract;
    }
}
