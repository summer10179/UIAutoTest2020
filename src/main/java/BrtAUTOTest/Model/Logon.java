package BrtAUTOTest.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logon {

     public void logon(WebDriver driver,String username,String password) throws InterruptedException {


        //获取登录地址

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        WebElement element  =driver.findElement(By.className("btn"));
        element.click();
        Thread.sleep(19000);
        driver.close();
    }
}
