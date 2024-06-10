package com.mbnabc;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Element_Locate {
    public static ChromeDriver driver;//声明全局变量
    public static void locateElement() throws InterruptedException {
        openChrome();
        driver.findElement(By.id("kw")).sendKeys("QQ");
        Thread.sleep(3000);
        driver.findElement(By.id("kw")).clear();
    }
    public static void openChrome(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }
}
