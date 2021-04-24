package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author：ZhaoWenXin
 * @date：2021-04-24 10:18
 * 本类均使用函数式接口
 */
public class LambdaDemo {

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();

        lambdaDemo.consumerTest();

        lambdaDemo.supplierTest();

        lambdaDemo.predicateTest();

        lambdaDemo.functionTest();
    }

    /**
     * 消费型接口实例
     */
    public void consumerTest(){
        //创建一个消费型
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
        //创建一个集合对象
        List<String> stringList = Arrays.asList("aaa", "bbb", "ddd", "ccc", "fff");
        //遍历集合去调用consumer.accept
        for (String str : stringList) {
            consumer.accept(str);
        }
        System.out.println("--------------分割线--------------");
        //lambda表达式简写
        stringList.forEach((s)-> System.out.println("s = " + s));
        System.out.println("--------------分割线--------------");
        //最终简写
        stringList.forEach(System.out::println);
    }

    /**
     * 供给型
     */
    public void supplierTest(){
        //使用Supplier接口实现方法,只有一个get方法，无参数，返回一个值
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //随机一个值
                return new Random().nextInt(100);
            }
        };
        System.out.println(supplier.get());

        System.out.println("--------------分割线--------------");

        //使用lambda
        Supplier<Integer> sups = ()->new Random().nextInt(100);
        System.out.println(sups.get());

        System.out.println("--------------分割线--------------");

        //使用方法引用
        Supplier<Double> supplier2 = Math::random;
        System.out.println(supplier2.get());
    }

    public void predicateTest(){
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                //是否包含数字
                List<Integer> numbs = Arrays.asList(9, 2, 4, 6, 5);
                return numbs.contains(integer);
            }
        };
        System.out.println(predicate.test(1));
        System.out.println(predicate.test(2));

        System.out.println("--------------分割线--------------");

        //使用lambda
        Predicate<Integer> pd = i-> Arrays.asList(9, 2, 4, 6, 5).contains(i);
        System.out.println(pd.test(3));
        System.out.println(pd.test(5));
    }

    public void functionTest(){
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {

                return integer+"Hello World";
            }
        };
        System.out.println(function.apply(100));

        System.out.println("--------------分割线--------------");

        //使用lambda
        Function<Integer, String> fun = i-> i+"Hello World";
        System.out.println(fun.apply(222));
    }

}
