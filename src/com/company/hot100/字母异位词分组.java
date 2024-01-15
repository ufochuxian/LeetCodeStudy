package com.company.hot100;

import java.util.*;

public class 字母异位词分组 {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     *
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     *
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     *
     *
     *
     * @param args
     */


    /**
     * 解题思路：一旦需要根据特征进行归类，就应该想到利用散列表
     *
     * 1. 通过分析和归纳可以发现，组合在一起的字母都是可以用字母的自然顺序排序后，作为key，然后使用散列表的特性
     *
     * 2. 通过散列表的特性进行存储，然后进行循环进行比较
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> resultList = groupAnagrams(strs);
        System.out.println(resultList);
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        if (strings.length <= 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for (String s : strings) {
            char[] chars = s.toCharArray();
            //1.将字符数组按照字符的自然顺序进行排序
            Arrays.sort(chars);
            if (!map.containsKey(String.valueOf(chars))) {
                //2. 说明当前散列表中没有有相同key的啦，将排序后的字符作为key存储到"散列表"中
                List<String> characterList = new ArrayList<>();
                characterList.add(s);
                map.put(String.valueOf(chars), characterList);
                resultList.add(characterList);
            } else {
                // 3.当前散列表中已经有相同key的，那么直接取出对应的list,再次加入相似的字符串就可以了
                List<String> characterList = map.get(String.valueOf(chars));
                characterList.add(s);
            }
        }
        return resultList;
    }


}
