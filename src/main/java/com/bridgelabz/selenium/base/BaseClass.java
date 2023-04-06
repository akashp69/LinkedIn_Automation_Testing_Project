package com.bridgelabz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    public static Logger log= Logger.getLogger(BaseClass.class.getName());

    public void initialization(String browserName){
        PropertyConfigurator.configure("C:\\Users\\HP\\IdeaProjects\\CQALinkedInPOM\\log4j.properties");
        BasicConfigurator.configure();

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.linkedin.com/home");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            log.info("Browser Open Successfully!! ");
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.linkedin.com/home");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    }

    public void tearDown(){
        driver.close();
    }
}
