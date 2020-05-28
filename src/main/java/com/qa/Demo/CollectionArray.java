package com.qa.Demo;

import java.util.ArrayList;
import java.util.List;

public class CollectionArray {
    public void collectionArray1(){
        //集合转化为数组
      List<String> list=new ArrayList<String>();
      String[] str=list.toArray(new String[list.size()]);
    }
}
