package AdinaPecie.pachet;

import org.testng.annotations.*;

public class SeleniumAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println(("beforeSuite"));
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @BeforeGroups(groups = {"Grupul 1"})
    public void beforeGroups(){
        System.out.println("beforeGroups");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @BeforeClass(groups = {"Grupul 1"})
    public void beforeGroupClass() {
        System.out.println("beforeGroupClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @Test(groups = {"Grupul 1"})
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @AfterGroups(groups = {"Grupul 1"})
    public void afterGroups(){
        System.out.println("afterGroups");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println(("afterSuite"));
    }
}
