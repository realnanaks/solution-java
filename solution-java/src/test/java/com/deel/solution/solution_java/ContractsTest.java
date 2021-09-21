package com.deel.solution.solution_java;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.deel.solution.solution_java.samples.LoginCreds;
import com.deel.solution.solution_java.utils.FieldUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.deel.solution.solution_java.samples.Contracts.fixedRate_ContractGeneralInfo;

public class ContractsTest {

    private static final String BASE_URL = "https://app.deel.training";
    private static final String LOGIN_URL = "/login";
    private static final String CREATE_FIXED_RATE_CONTRACT = "/create/fixed";

    private void openLoginPage(){
        //open base url and login
        Selenide.open(BASE_URL + LOGIN_URL);

        // log the user in
        Map<String, String> login = LoginCreds.test_Login1();
        String email = login.get("email");
        String password = login.get("password");
        $("input[name=email]").setValue(email);
        $("input[name=password]").setValue(password);
        $("button[type=submit]").submit();
    }

    @Test
    public void createFixedRateContract() {
        openLoginPage();

        // wait for page to complete loading
        Selenide.sleep(10000);

        Selenide.open(BASE_URL + CREATE_FIXED_RATE_CONTRACT);

        // wait for create contract page to complete loading
        Selenide.sleep(10000);

        // reference submit button
        SelenideElement submitButton = $("button[type=submit]");

        // fill up first form
        fixedRate_ContractGeneralInfo().forEach(FieldUtils::setValue);

        // submit form
        submitButton.click();
    }
}