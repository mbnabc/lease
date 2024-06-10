package com.mbnabc;

import org.openqa.selenium.chrome.ChromeDriver;
import com.mbnabc.Element_Locate;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Element_Locate.locateElement();
    }
    //goole
//    System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
//    driver = new ChromeDriver();
//    driver.get("https://www.google.com");
    //火狐
//    System.setProperty(".webdriver.firefox.bin","D: \ \Program Files\|Mozilla Firefox\lfirefox.exe");
//    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
//    FirefoxDriver fireFoxDriver = new FirefoxDriver( ) ;//2、访问百度
    //IE
//    DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();//忽略掉保护模式的设置
//    desiredCapabilities.setCapability(InternetExplorerDriver.INYROD0CZ ILAKINDSS BY_IGNOREING SBCORErY_DONAINs， true) ;//忽略掉缩放的设置
//    desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZO0M SETTING，taSystem.setProperty( "webdriver.ie.driver","src/test/resources/IEDriverServer.exe")/ /1、打开工E浏览器
//    InternetExplorerDriver ieDriver = new InternetExplorerDriver();
}