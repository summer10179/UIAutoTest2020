package TestUi.Case;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_go {
    public static void main(String[] args) {
        System.out.println("http://172.19.201.40:9080/shxjc-server/shxjc/index.html#/login");
        System.setProperty ( "webdriver.chrome.driver", "src/main/resource/chromedriver.exe");
        WebDriver  driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://172.19.201.40:9080/shxjc-server/shxjc/index.html#/login");
        //定位账号与密码登录系统
        WebElement elenemt=driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/div[2]/div[1]/div/input"));
        elenemt.sendKeys("61102");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element1=driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/div[2]/div[2]/div/input"));
        element1.sendKeys("1");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/div[2]/div[3]/a")).click();
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //处理工单
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//*[@id=\"pane-01\"]/div[3]/div/div[2]/div[2]/div/div[4]/div/div[2]/div")).click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"pane-01\"]/div[3]/div/div[6]/div[2]/div/div[4]/div/div[2]/div")).click();




    }
}
