import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class demo {
    private static List<Apple> listApple=new ArrayList<>();
    public static void main(String[] args) {
        listApple.add(new Apple(1,"red",500,"湖南"));
        listApple.add(new Apple(5,"red",9500,"湖南"));
        listApple.add(new Apple(2,"green",400,"陕西"));
        listApple.add(new Apple(3,"yellow",300,"西安"));
        listApple.add(new Apple(4,"write",230,"宝鸡"));
      //  test();
       // test2();
//        test3();
        test4();
    }

    private static void test() {
        List<Apple> list=new ArrayList<>();
        for (Apple apple:listApple){
            if (apple.getColor().equals("red")) {
                list.add(apple);
            }
        }
        System.out.println(list);
    }
    private static void test1() {
        List<Apple> red = listApple.stream().filter(item -> item.getColor().equals("red")).collect(Collectors.toList());
        System.out.println(red);
    }
    private static void test2() {
        Map<String,List<Apple>> map=new HashMap<>();
        for (Apple apple:listApple){
            List<Apple> list = map.computeIfAbsent(apple.getColor(), key -> new ArrayList<>());
            System.out.println(map);
            System.out.println("---------"+                   list);
            list.add(apple);
        }
        for (Map.Entry<String, List<Apple>> stringListEntry : map.entrySet()) {
            int weight=0;
            for (Apple apple : stringListEntry.getValue()) {
                weight+=apple.getWeight();
            }
            System.out.println(weight/stringListEntry.getValue().size());
        }

    }
    private static void test3(){
        listApple.stream().collect(Collectors.groupingBy(item->item.getColor(),Collectors.averagingInt(item->item.getWeight())))
                .forEach((k,v)-> System.out.println(k+"  -----  "+    "-----"+v));
    }
    private static void test4(){
        listApple.stream()
                .filter(item->item.getColor().equals("red")||item.getColor().equals("green"))
                .map(item->item.getColor())
                .distinct()
                .forEach(item-> System.out.println(item));
    }
}
