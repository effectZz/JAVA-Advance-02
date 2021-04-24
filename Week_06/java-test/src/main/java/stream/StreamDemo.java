package stream;

import model.UserClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author：ZhaoWenXin
 * @date：2021-04-24 14:52
 */
public class StreamDemo {
    private static final List<UserClass> userList;

    static {
        userList = new ArrayList<>() {
            {
                add(new UserClass().setUserId("1").setName("ZhangSan").setAge(22).setIntegral(BigDecimal.ZERO).setBirthday(LocalDate.of(1999,1,1)));
                add(new UserClass().setUserId("2").setName("Lisi").setAge(35));
                add(new UserClass().setUserId("3").setName("LiLi").setAge(44).setIntegral(BigDecimal.ONE));
                add(new UserClass().setUserId("4").setName("MiNa").setAge(33).setIntegral(BigDecimal.TEN));
                add(new UserClass().setUserId("5").setName("Jack").setAge(21));
                add(new UserClass().setUserId("6").setName("Rose").setAge(18).setIntegral(BigDecimal.valueOf(333)));
                add(new UserClass().setUserId("7").setName("Rose").setAge(25));
                add(new UserClass().setUserId("8").setName("Rose").setAge(31));
            }
        };
    }

    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();

        streamDemo.streamBasic();

        streamDemo.groupingByTest();

        streamDemo.filterTest();
    }


    public void streamBasic(){
        List<Integer> list = Arrays.asList(1, 8, 2, 5, 4, 6, 4, 6, 7, 9);

        // 去重复，按照大小倒叙排序  再转成 list
        List<Integer> sorted = list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sorted = " + sorted);

        //求出总和
        Integer reduce = sorted.stream().reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);
    }

    /**
     * 使用stream分组
     */
    public void groupingByTest(){
        Map<String, Map<BigDecimal, List<UserClass>>> map = userList.stream().filter(x -> {
            // 此处进行了过滤，并且把积分为null的 设置一个初始值
            if (null == x.getIntegral()) {
                x.setIntegral(BigDecimal.ZERO);
            }
            return true;
        }).collect(Collectors.groupingBy(UserClass::getName, Collectors.groupingBy(UserClass::getIntegral)));

        map.forEach((key,value)->{
            System.out.println("名称为 "+key+" 的人数有:"+value.size());
            value.forEach((nk,nv)->{
                System.out.println("并且其中相同的积分为："+nk);
                for (UserClass user : nv) {
                    System.out.println("他们的年龄为："+user.getAge());
                }
                System.out.println("***************");
            });
            System.out.println("-------------------");
        });
    }


    public void filterTest(){
        //获取集合里姓名为 Rose 年龄为31 的第一个分数值 并且如果取不到则默认个1000
        BigDecimal integral = userList.stream()
                .filter(u -> "Rose".equals(u.getName()))
                .filter(u -> 31 == u.getAge())
                .map(UserClass::getIntegral)
                .findFirst()
                .orElseGet(() -> BigDecimal.valueOf(1000));
        System.out.println("integral = " + integral);
    }
    
}
