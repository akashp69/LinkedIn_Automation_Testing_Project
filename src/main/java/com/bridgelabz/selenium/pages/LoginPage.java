package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(name = "session_key")
    WebElement username;

    @FindBy (name ="session_password")
    WebElement password;

    @FindBy (xpath ="/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/form[1]/div[2]/button[1]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String loginToLinkedInWeb(String name,String pass){
        username.sendKeys(name);
        password.sendKeys(pass);
        loginBtn.click();
        String loginTittle = driver.getTitle();
        return loginTittle;
    }
}
