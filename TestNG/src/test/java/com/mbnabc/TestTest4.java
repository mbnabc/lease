package com.mbnabc;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;


public class TestTest4 {


    @Test(groups = "group1")
    public void testD03() {
        System.out.println("testD03");
        Assert.assertTrue(true);
    }

    @Test(groups = "group1")
    public void testD04() {
        System.out.println("testD04");
        Assert.assertTrue(true);
    }

    @Test(groups = "group2")
    public void testD05() {
        System.out.println("testD05");
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

    @BeforeGroups(groups = "group1")
    public void beforeGroups() {
        System.out.println("beforeGroups");
    }

    @AfterGroups(groups = "group1")
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
