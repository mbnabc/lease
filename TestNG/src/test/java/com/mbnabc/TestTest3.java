package com.mbnabc;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;


public class TestTest3 {


    @Test(groups = "group1")
    public void testC03() {
        System.out.println("testC03");
        Assert.assertTrue(true);
    }

    @Test(groups = "group1")
    public void testC04() {
        System.out.println("testC04");
        Assert.assertTrue(true);
    }

    @Test(groups = "group2")
    public void testC05() {
        System.out.println("testC05");
        Assert.assertTrue(true);
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }

    @BeforeGroups(groups = {"group1", "group2"})
    public void beforeGroups() {
        System.out.println("beforeGroups");
    }

    @AfterGroups(groups = {"group1", "group2"})
    public void afterGroups() {
        System.out.println("afterGroups");
    }


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }
}