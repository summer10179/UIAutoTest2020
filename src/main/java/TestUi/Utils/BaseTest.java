package TestUi.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public String LoginURL = "http://*************";

    private static String URL = "http://****************/";

    UseBrowser useBrowser = new UseBrowser();

    public static WebDriver driver;

    @BeforeSuite

    public void start() throws Exception {

        try {



            driver = useBrowser.startChrome(URL);

// driver = useBrowser.startIE(URL);

// driver = useBrowser.startFirefox(URL);

        } catch (Exception e) {

            System.out.println(e);

        }

    }



    @AfterSuite

    public void end() throws Exception {

        useBrowser.tearDownBrowser();

    }



}

