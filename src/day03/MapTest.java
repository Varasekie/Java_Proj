package day03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();

        //添加key value
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);


        System.out.println(map);

        //根据key取某个值
        System.out.println(map.get("second"));

        //删除某个值
        map.remove("second");

        //长度
        System.out.println(map.size());

        //是否包含key,或者value
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(1));

        //遍历map集合
        //法一
        Set<String> set = map.keySet();
        for (String key : set) {
            System.out.println("key: " + key + "    value :" + map.get(key));
        }

        System.out.println("===================");

        //法二
        //用entryset遍历
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> en : entries) {
            System.out.println("key: " + en.getKey() + "    value :" + en.getValue());
        }
    }
}
