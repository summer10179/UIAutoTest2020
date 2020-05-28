package BrtAUTOTest.Model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogonTest {

    @DataProvider( name="user")
    public Object[][] Users(){
        return new Object[][]{
                {"testingwtb","a123456"},
        };
    }
    @Test(dataProvider="user")
    public void LogonTest(String username,String password){
        Logon logon=new Logon();
        System.out.println("Brt登录");
        System.setProperty("webdriver.chrome.driver", "src/main/resource/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://172.18.1.72:8080/amber2_server/pf_desk_gas/gasworkbench/workbench");


        try {
            logon.logon(driver,username,password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
