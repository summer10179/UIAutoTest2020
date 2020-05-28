package TestUi.PracticeTest.Client;


import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.logging.Logger;


import TestUi.PracticeTest.utils.CommUtil;
import TestUi.PracticeTest.utils.WmsBaseTest;
import TestUi.Utils.ExcelProcess;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.log4j.spi.LoggerFactory;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest  {

    private static final Log logger = LogFactory.getLog(WmsBaseTest.class);

    public static RestfulClient httpclient=null;
    public static HashMap<String, String> headers=null;
    public static int responseCode=0;
    public static JSONObject responseBody=null;
    public static List<NameValuePair> params = new ArrayList<NameValuePair>();
    public static Object[][] excelData=null;
    public static ExcelProcess excelProcess=new ExcelProcess();
    public static String host=null;
    public static String url=null;
    public Properties prop=null;
    public String excelPath=null;
    public static WssAppApi wssAppApi =new WssAppApi();



    public BaseTest() {
        try {
//          数据流的形式读取配置文件
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/resources/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        excelPath = prop.getProperty("testData").replace("\\", File.separator);
        if (wssAppApi.getHost()!=null){
            host = prop.getProperty(wssAppApi.getHost());
        }

    }


    @AfterMethod
    public void afterMethod(ITestResult result){
        logger.info("http:"+"=========case test finished,"+ result.getTestContext());

    }


   // private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    public static UtDal dal = new UtDal();

    @BeforeClass
    public static void beforeClass() {
        httpclient = new RestfulClient();

    }


    @BeforeMethod
    public void beforeTest() {

        headers =new HashMap<String, String>();
        /**
         * 小白注释：
         *         如果设置不合适的请求头，请求结果可能会失败。最好的办法是抓包，
         *         另外此处的headers 一定放的是request headers 千万不能添加不合适的response headers ,画蛇添足了
         */
        headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
        headers.put("Cookie","JSESSIONID=889b441b-2f79-454a-9246-6687014a616f");
        headers.put("Accept", "*/*");
        headers.put("Connection", "Keep-Alive");
        headers.put("Content-type", "application/json;charset=utf-8");
        /**
         *         区分pad app he pc 接口tk 类型，get
         *         默认测试账号 autotest
         *         ed3fb2f9-bb98-4331-91dc-ea6c106c0400
         *         ed3fb2f9-bb98-4331-91dc-ea6c106c0400pda
         *         String model=wmsAppApi.getModel();
         */
        String tk=null;
        if (wssAppApi.getModel()=="pda"){
            tk="ed3fb2f9-bb98-4331-91dc-ea6c106c0400pda";
        }else if (wssAppApi.getModel()=="pc"){
            tk="ed3fb2f9-bb98-4331-91dc-ea6c106c0400";
        }else {
            System.out.println("请确认测试的系统类型！");
        }
        headers.put("tk", tk);


        url=host+ wssAppApi.getPath();
//        System.out.println(url);
    }


    @AfterClass
    public static void afterClass() {
        httpclient.shutDownConnection();
    }


//    @AfterMethod
//    public void afterTest(ITestResult result) {
//        LOGGER.info("wms:"+"=========case test finished,"+dal.getCase_name());
//        if(dal.getFailMessage()==null){
//            LOGGER.info("wms:"+"=========NeedAssertUtil==========,"+dal.getCase_name());
//            dal.setFailMessage(new StringBuilder().append("assertNotRight"));
//        }
//        dal.setFail_info(dal.getFailMessage().toString());
////        dal.setResult(AssertUtil.judgeResult(dal.getFailMessage().toString()));
//        dal.setEnd_time(CommUtil.getCurrentTime());
//        if("".equals(dal.getPriority()) || dal.getPriority()==null){
//            dal.setPriority("p-");
//        }
//
//        if(result.getStatus()==3){
//            dal.setResult("skip");
//            System.out.println("skip 方法："+dal.getCase_name());
//        }
//        if(result.getStatus()==2){
//            dal.setResult("fail");
//            System.out.println("case执行失败："+dal.getCase_name());
//        }
//    }
}
