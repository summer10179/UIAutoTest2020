package TestUi.Demo;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestType {
    public static void main(String[] args) {
        //集合转化为数组
        List<String> list=new ArrayList<String>();
        String  [] arr=list.toArray(new String[list.size()]);
       //数组转化为集合

        List arrys=new ArrayList();
        List lists=Arrays.asList(arrys);

    }
}
