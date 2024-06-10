package com.mbnabc;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 {

    @Test(enabled=true)
    @Parameters({"param1", "param2"})
    public void TestNgLearn1(String param1, int param2) {
        System.out.println("this is TestNG test case1, and param1 is:"+param1+"; param2 is:"+param2);
        Assert.assertFalse(false);
    }

    @Test(dependsOnMethods= {"TestNgLearn1"})
    public void TestNgLearn2() {
        System.out.println("this is TestNG test case2");
    }
}