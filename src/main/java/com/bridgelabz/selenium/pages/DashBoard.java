package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard extends BaseClass {
    @FindBy(xpath="//header/div[1]/nav[1]/ul[1]/li[1]/a[1]/div[1]/div[1]/li-icon[1]/*[1]")
    WebElement homeBtn;

    public DashBoard(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public boolean homeTestValidation(){
        Boolean flag =homeBtn.isDisplayed();
        return flag;

    }
}
