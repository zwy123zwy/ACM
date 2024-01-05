package org.example.yitutest.dup;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println(countClasses(strings));
    }

    public static int countClasses(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map.size();
    }
}