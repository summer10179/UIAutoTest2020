package BrtAUTOTest.testcase;

import BrtAUTOTest.utils.PublicModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SXJCTest {

   // public static void main(String[] args) throws InterruptedException {
   // 测试处理工单的
    @Test
    public void  senItemTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resource/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://172.19.201.40:9080/shxjc-server/shxjc/index.html#/login");

        PublicModel.login(driver);
        System.out.println("login  success");
        Thread.sleep(2000);
        PublicModel.logout(driver);
        System.out.println("logout success");


    }

    }