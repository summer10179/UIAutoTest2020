package com.qa.casees;

import com.qa.base.PostClient;
import com.qa.base.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.qa.base.PostClient.postClient;

public class Prj_Process_Manage extends TestBase{

   @Test
    public void prj_Process_test() throws IOException {

        //String url="http://172.19.188.179:8070/techprj-server/techprj/framework/procMag/sendApp";
        String json="{\"CANEDIT\":\"1\",\"PRJID\":194,\"PROCTIME\":\"2020-03\",\"FINANBUDGET\":21,\"CURFINISHAMT\":\"232\",\"FINAPER\":\"\",\"BGNTIME\":\"2020-02\",\"resTb\":[{\"TARGETID\":212,\"PRJTARGET\":\"2122121212\",\"DISPSN\":0,\"IMPLSIT\":\" 2343\",\"RESEARCHCONTENT\":\"212121\"}],\"tb_PATS\":[{\"ACHID\":327,\"STATUS\":\"01\",\"OUTPUTTIME\":\"2020-06\",\"ACHKEY\":252,\"ACHNAME\":\"21\",\"ACHTYPE\":\"01\",\"ISORI\":\"1\",\"DISPSN\":0,\"FILECOUNT\":0,\"STLEVNAME\":\"外观设计专利\",\"ISADD\":\"0\",\"STLEVCODE\":\"03\"}],\"tb_PAPERS\":[],\"tb_STANDS\":[],\"tb_BOOKS\":[],\"tb_RESERS\":[],\"tb_ACHIES\":[],\"typs_PATS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"发明专利\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"实用新型专利\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"外观设计专利\"},{\"DISP_SN\":4,\"VALUE\":\"04\",\"NAME\":\"计算机软件著作权\"}],\"typs_PAPERS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"SCI\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"EI\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"中心核心\"},{\"DISP_SN\":4,\"VALUE\":\"04\",\"NAME\":\"普通期刊\"},{\"DISP_SN\":5,\"VALUE\":\"05\",\"NAME\":\"中心核心及以上等级\"}],\"typs_STANDS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"国际标准\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"国家标准\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"电力行业标准\"},{\"DISP_SN\":4,\"VALUE\":\"04\",\"NAME\":\"团体标准\"},{\"DISP_SN\":5,\"VALUE\":\"05\",\"NAME\":\"国网企业标准\"},{\"DISP_SN\":6,\"VALUE\":\"06\",\"NAME\":\"其它标准\"}],\"stas_PATS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"-\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"申请\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"公开\"},{\"DISP_SN\":4,\"VALUE\":\"04\",\"NAME\":\"实审\"},{\"DISP_SN\":5,\"VALUE\":\"05\",\"NAME\":\"授权\"}],\"stas_PAPERS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"-\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"投稿\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"收录\"},{\"DISP_SN\":4,\"VALUE\":\"04\",\"NAME\":\"见刊\"}],\"stas_STANDS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"-\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"报批\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"发布\"}],\"stas_BOOKS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"-\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"清样\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"出版\"}],\"stas_RESERS\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"-\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"编制\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"审核\"},{\"DISP_SN\":4,\"VALUE\":\"04\",\"NAME\":\"批准\"}],\"stas_ACHIES\":[{\"DISP_SN\":1,\"VALUE\":\"01\",\"NAME\":\"-\"},{\"DISP_SN\":2,\"VALUE\":\"02\",\"NAME\":\"进行中\"},{\"DISP_SN\":3,\"VALUE\":\"03\",\"NAME\":\"已完成\"}],\"achCount\":1,\"PRJNO\":\"KJGL20200322221845304\",\"VERFYPER\":\"KJCS1\",\"VERFYPERNAME\":\"科技管理员\",\"oldAchies\":[{\"ACHID\":327,\"STATUS\":\"01\",\"OUTPUTTIME\":\"2020-06\",\"ACHKEY\":252,\"ACHNAME\":\"21\",\"ACHTYPE\":\"01\",\"ISORI\":\"1\",\"DISPSN\":0,\"FILECOUNT\":0,\"STLEVNAME\":\"外观设计专利\",\"ISADD\":\"0\",\"STLEVCODE\":\"03\"}]}";
        postClient.postWithParams(url,json);
        int code=postClient.getCode();
        String st=postClient.getResponse();
        System.out.println(st);
    }

}