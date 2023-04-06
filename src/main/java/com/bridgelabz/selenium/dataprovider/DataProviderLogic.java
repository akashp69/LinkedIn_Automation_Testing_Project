package com.bridgelabz.selenium.dataprovider;

public class DataProviderLogic {
    @org.testng.annotations.DataProvider(name ="dataProvider")
    public Object[][] etDataFromDataProvider(){

        return new Object[][]{
                {"",""}
        };
    }
}
