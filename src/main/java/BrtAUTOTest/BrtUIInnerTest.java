package BrtAUTOTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrtUIInnerTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resource/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(200);

      //  driver.execute_script("document.body.style.zoom='0.5'");
        //设置浏览器缩放比例为80%

        //获取连接
        driver.get("http://172.18.1.72:8080/amber2_server/pf_desk_gas/gasworkbench/workbench");
        //获得当前窗口句柄
        //String sreach_handle = driver.getWindowHandle();


        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.body.style.zoom='80%'");
//        driver.execute_script("document.body.style.zoom='1.7'")

        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("37162");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("jing421.");
        WebElement element  =driver.findElement(By.className("btn"));
        element.click();
        Thread.sleep(1900);
      //嵌套iframe
        driver.switchTo().frame("gongzuotaiFrame");
        driver.switchTo().frame("iframe_content");
        driver.switchTo().frame("issueUnhandledFrame");

       driver.findElement(By.xpath("//*[@id=\"unhandledTab\"]/tbody/tr[4]/td/a")).click();

       Thread.sleep(3000);
       //双击某一行
       //鼠标双击
        driver.switchTo().frame("gongzuotaiFrame");
        driver.switchTo().frame("iframe_content");
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath("//*[@id=\"rn_0\"]"))).perform();
        Thread.sleep(2000);
        //点击内部测试
        String sreach_handle = driver.getWindowHandle();
        driver.switchTo().frame("gongzuotaiFrame");
        driver.findElement(By.xpath("//*[@id=\"itemCodeName_11016639\"]")).click();

        Thread.sleep(3000);
        driver.switchTo().defaultContent();
   //     WebElement element2=driver.findElement(By.xpath("//*[@id=\"amber1F375A6D789D818C1A7A177738B8A2DB-VIEW\"]"));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'amber')]")));
        driver.findElement(By.name("oper1414")).click();
        Thread.sleep(3000);

        //选择通过
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[11]/div/div[2]")).click();

        //输入测试描述
        Thread.sleep(200);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'amber')]")));
        driver.findElement(By.id("oper6006_oper6006")).sendKeys("1");
        driver.findElement(By.className("LS-button-normal")).click();






    }
}