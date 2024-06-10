package com.mbnabc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentalPlatformTest {
    public static void main(String[] args) {
        // 设置 ChromeDriver 的路径
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // 创建 WebDriver 实例
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // 登录测试
        testLogin(driver, wait);

        // 添加公寓信息测试
        testAddApartment(driver, wait);

        // 添加房间信息测试
        testAddRoom(driver, wait);

        // 处理看房预约请求测试
        testManageViewingRequests(driver, wait);

        // 创建租约测试
        testCreateLease(driver, wait);

        // 关闭浏览器
        driver.quit();
    }

    public static void testLogin(WebDriver driver, WebDriverWait wait) {
        driver.get("http://localhost:8080/login");

        // 输入用户名和密码
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("admin");
        password.sendKeys("password");

        // 点击登录按钮
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // 验证是否登录成功
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcomeMessage")));
            System.out.println("Login Test Passed");
        } catch (Exception e) {
            System.out.println("Login Test Failed");
        }
    }

    public static void testAddApartment(WebDriver driver, WebDriverWait wait) {
        driver.get("http://localhost:8080/apartmentManagement");

        // 点击添加公寓按钮
        WebElement addApartmentButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addApartmentButton")));
        addApartmentButton.click();

        // 填写公寓信息
        WebElement name = driver.findElement(By.id("apartmentName"));
        WebElement address = driver.findElement(By.id("apartmentAddress"));
        WebElement contact = driver.findElement(By.id("apartmentContact"));
        name.sendKeys("Test Apartment");
        address.sendKeys("123 Test St.");
        contact.sendKeys("123-456-7890");

        // 提交表单
        WebElement saveButton = driver.findElement(By.id("saveApartmentButton"));
        saveButton.click();

        // 验证是否添加成功
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), 'Test Apartment')]")));
            System.out.println("Add Apartment Test Passed");
        } catch (Exception e) {
            System.out.println("Add Apartment Test Failed");
        }
    }

    public static void testAddRoom(WebDriver driver, WebDriverWait wait) {
        driver.get("http://localhost:8080/roomManagement");

        // 点击添加房间按钮
        WebElement addRoomButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addRoomButton")));
        addRoomButton.click();

        // 填写房间信息
        WebElement roomNumber = driver.findElement(By.id("roomNumber"));
        WebElement roomType = driver.findElement(By.id("roomType"));
        WebElement area = driver.findElement(By.id("roomArea"));
        WebElement rent = driver.findElement(By.id("roomRent"));
        roomNumber.sendKeys("101");
        roomType.sendKeys("Single");
        area.sendKeys("30");
        rent.sendKeys("1000");

        // 提交表单
        WebElement saveButton = driver.findElement(By.id("saveRoomButton"));
        saveButton.click();

        // 验证是否添加成功
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), '101')]")));
            System.out.println("Add Room Test Passed");
        } catch (Exception e) {
            System.out.println("Add Room Test Failed");
        }
    }

    public static void testManageViewingRequests(WebDriver driver, WebDriverWait wait) {
        driver.get("http://localhost:8080/viewingRequests");

        // 验证是否有看房预约请求
        try {
            WebElement request = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), 'Pending')]")));
            System.out.println("Viewing Requests Found");

            // 处理第一个看房预约请求
            WebElement handleButton = driver.findElement(By.xpath("//button[contains(text(), 'Handle')]"));
            handleButton.click();

            // 验证是否处理成功
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), 'Handled')]")));
            System.out.println("Manage Viewing Requests Test Passed");
        } catch (Exception e) {
            System.out.println("Manage Viewing Requests Test Failed");
        }
    }

    public static void testCreateLease(WebDriver driver, WebDriverWait wait) {
        driver.get("http://localhost:8080/leaseManagement");

        // 点击创建租约按钮
        WebElement createLeaseButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("createLeaseButton")));
        createLeaseButton.click();

        // 填写租约信息
        WebElement tenantName = driver.findElement(By.id("tenantName"));
        WebElement apartment = driver.findElement(By.id("leaseApartment"));
        WebElement room = driver.findElement(By.id("leaseRoom"));
        WebElement startDate = driver.findElement(By.id("startDate"));
        WebElement endDate = driver.findElement(By.id("endDate"));
        tenantName.sendKeys("John Doe");
        apartment.sendKeys("Test Apartment");
        room.sendKeys("101");
        startDate.sendKeys("2024-01-01");
        endDate.sendKeys("2024-12-31");

        // 提交表单
        WebElement saveButton = driver.findElement(By.id("saveLeaseButton"));
        saveButton.click();

        // 验证是否创建成功
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(text(), 'John Doe')]")));
            System.out.println("Create Lease Test Passed");
        } catch (Exception e) {
            System.out.println("Create Lease Test Failed");
        }
    }
}
