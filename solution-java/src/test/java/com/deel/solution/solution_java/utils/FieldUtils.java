package com.deel.solution.solution_java.utils;

import static com.codeborne.selenide.Selenide.$;

public class FieldUtils {

    public static void setValue(String selector, String value){
//        if(selector.contains("input"))
//            $(selector).setValue(value);
//        else
            $(selector).sendKeys(value);
    }
}
