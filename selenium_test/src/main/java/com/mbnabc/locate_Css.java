package com.mbnabc;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class locate_Css {
    public static ChromeDriver driver;//声明全局变量
    public static void locateElement()
    {
        openChrome();
        driver.findElement(By.id("kw")).sendKeys("QQ");
        driver.findElement(By.name("btnK")).click();

    }
    public static void openChrome(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.goole.com");
    }
}
