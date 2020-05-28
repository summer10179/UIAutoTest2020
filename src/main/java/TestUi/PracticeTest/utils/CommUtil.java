package TestUi.PracticeTest.utils;

import java.text.SimpleDateFormat;

public class CommUtil {

    public static String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.toString();
    }

    public static String getTimeStamp(){
       Long ct= System.currentTimeMillis();
       return ct.toString();
    }

}
