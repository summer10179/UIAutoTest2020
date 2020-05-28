package TestUi.PracticeTest.utils;



//@ContextConfiguration(locations = {"classpath:/spring-core.xml"})

import TestUi.PracticeTest.Client.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class WmsBaseTest extends BaseTest {



    @BeforeClass
    public static void beforeClass() {
        BaseTest.beforeClass();
    }

    @AfterClass
    public static void afterClass() {
        BaseTest.afterClass();
    }

    @BeforeMethod
    public void beforeTest() {
        super.beforeTest();
    }

    @AfterMethod
    public void afterTest(ITestResult result) {
        super.afterMethod(result);
    }


}
