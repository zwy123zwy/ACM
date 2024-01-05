package mpp;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class maptest {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(17);
        print(objectObjectHashMap);
        objectObjectHashMap.put("qq1",1111);
        objectObjectHashMap.put("qq2",1111);
        objectObjectHashMap.put("qq3",1111);
        objectObjectHashMap.put("qq4",1111);
        objectObjectHashMap.put("qq5",1111);
        objectObjectHashMap.put("qq6",1111);
        objectObjectHashMap.put("qq7",1111);
        objectObjectHashMap.put("qq8",1111);
        objectObjectHashMap.put("qq9",1111);
        objectObjectHashMap.put("qq10",1111);
        objectObjectHashMap.put("qq11",1111);
        objectObjectHashMap.put("qq12",1111);
        objectObjectHashMap.put("qq13",1111);
        objectObjectHashMap.put("qq14",1111);
        objectObjectHashMap.put("qq15",1111);
        objectObjectHashMap.put("qq16",1111);
        objectObjectHashMap.put("qq17",1111);
        print(objectObjectHashMap);
        objectObjectHashMap.put("qq18",1111);
        print(objectObjectHashMap);
        System.out.println(objectObjectHashMap.size());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }
    //new void ConcurrentHashMap();
    public static void print(Map<Object, Object> map) {
        try {
            Class<?> mapType = map.getClass();
            Method capacity = mapType.getDeclaredMethod("capacity");
            capacity.setAccessible(true);
            System.out.println("capacity : " + capacity.invoke(map) + "    size : " + map.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
