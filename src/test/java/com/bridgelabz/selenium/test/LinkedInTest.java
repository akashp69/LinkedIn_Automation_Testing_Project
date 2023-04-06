package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.dataprovider.DataProviderLogic;
import com.bridgelabz.selenium.pages.DashBoard;
import com.bridgelabz.selenium.pages.LoginPage;
import com.bridgelabz.selenium.readexcel.DataProviderExcelDataLogic;
import org.testng.Assert;
import org.testng.annotations.*;

public class LinkedInTest extends BaseClass {
    LoginPage loginPage;
    DashBoard dashboard;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser){
        initialization(browser);
        loginPage=new LoginPage(driver);
        dashboard=new DashBoard(driver);
    }

    @Test(priority = 0)
    public void validatesUrlNavigation(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.linkedin.com/home",currentUrl);

    }

    @Test(priority = 1,dataProvider = "testData", dataProviderClass = DataProviderExcelDataLogic.class)
    //@Parameters({"userName","password"})
    public void loginToLinkedIn(String userName , String password){
        String loginPageTittle = loginPage.loginToLinkedInWeb(userName,password);
        //Assert.assertEquals("LinkedIn",loginPageTittle);
        log.info("Login Successfully on LinkedIn");

    }

    @Test(priority = 2,dataProvider = "dataProvider", dataProviderClass = DataProviderLogic.class)
    //@Parameters({"userName","password"})
    public void homeDashboardValidation_Success(String userName , String password){
        String loginPageTittle = loginPage.loginToLinkedInWeb(userName,password);
        Assert.assertEquals("(8) Feed | LinkedIn",loginPageTittle);
        Boolean flag =dashboard.homeTestValidation();
        Assert.assertEquals(true,flag);
        log.info("Home Dashboard Validation Success");
    }

    @AfterMethod
    public void closeLinkedIn(){
        tearDown();
        log.info("LinkedIn Close Successfully!!");
    }
}
