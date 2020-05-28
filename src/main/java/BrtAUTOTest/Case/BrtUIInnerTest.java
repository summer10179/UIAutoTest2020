//package BrtAUTOTest.Case;
//
//import BrtAUTOTest.Model.Logon;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//
//public class BrtUIInnerTest {
//    @Test
//    public void  SendMessage() {
//        Logon logon=new Logon();
//        System.setProperty("webdriver.chrome.driver", "src/main/resource/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
////调用登录模块
//        try {
//            logon.logon(driver);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.switchTo().frame("gongzuotaiFrame");
//        driver.switchTo().frame("iframe_content");
//        driver.switchTo().frame("issueUnhandledFrame");
//
//       driver.findElement(By.xpath("//*[@id=\"unhandledTab\"]/tbody/tr[4]/td/a")).click();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //双击某一行
//       //鼠标双击
//        driver.switchTo().frame("gongzuotaiFrame");
//        driver.switchTo().frame("iframe_content");
//        Actions action = new Actions(driver);
//        action.doubleClick(driver.findElement(By.xpath("//*[@id=\"rn_0\"]"))).perform();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //点击内部测试
//        String sreach_handle = driver.getWindowHandle();
//        driver.switchTo().frame("gongzuotaiFrame");
//        driver.findElement(By.xpath("//*[@id=\"gview__id_processGrid\"]/div/class[2]/id[6]"));
//
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.switchTo().defaultContent();
//   //     WebElement element2=driver.findElement(By.xpath("//*[@id=\"amber1F375A6D789D818C1A7A177738B8A2DB-VIEW\"]"));
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'amber')]")));
//        driver.findElement(By.name("oper1414")).click();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //选择通过
//        driver.switchTo().defaultContent();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.xpath("/html/body/div[2]/div[11]/div/div[2]")).click();
//
//        //输入测试描述
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'amber')]")));
//        driver.findElement(By.id("oper6006_oper6006")).sendKeys("1");
//        driver.findElement(By.className("LS-button-normal")).click();
//
//
//
//
//
//
//    }
//}