package TestUi.Demo;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String>   hashMap=new HashMap<String,String>();
        hashMap.put("xiaoming","01");
        hashMap.put("xiaohong","02");
        hashMap.put("xiaogang","03");
        hashMap.put("xiaofang","04");
        System.out.println(hashMap.containsKey("xiaohng"));
        System.out.println(hashMap.containsValue("09"));
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.get("xiaoming"));
        //循环打印每一对key,value
        Iterator<?> it2=hashMap.entrySet().iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());

        }
        System.out.println("=========================");

    }
}
