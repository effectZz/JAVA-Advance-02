package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBiMap;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.Arrays;
import java.util.List;

/**
 * @author：ZhaoWenXin
 * @date：2021-04-24 15:35
 *
 * 老师的demo 试着写了一份
 */
public class GuavaDemo {

    public static EventBus eventBus = new EventBus();

    static {
        eventBus.register("this is a eventBus");
    }

    public static void main(String[] args) {
        GuavaDemo guavaDemo = new GuavaDemo();

        guavaDemo.testString();

        guavaDemo.testMap();

        guavaDemo.testBiMap();

        guavaDemo.testEventBus();
    }


    public void testString(){
        List<String> lists = Arrays.asList("a","x","1","8","ee","q");
        String joins = Joiner.on(",").join(lists);
        System.out.println("joins = " + joins);

        List<String> stringList = Splitter.on(",").splitToList(joins);
        System.out.println("stringList = " + stringList);
    }

    public void testBiMap(){
        HashBiMap<String , Integer> map = HashBiMap.create();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);

        //根据valus获取key  如果value有多个会报异常
        String key = map.inverse().get(1);

        System.out.println("key = " + key);
    }
    public void testMap(){
        ArrayListMultimap<Integer, Integer> map = ArrayListMultimap.create();

        Arrays.asList(9, 2, 4, 6, 5).forEach(n->{
            map.put(n,n*10);
        });
        System.out.println("map = " + map);
    }


    private void testEventBus() {
        eventBus.post("sssss");
    }

    @Subscribe
    public void test(String test){
        System.out.println("test = " + test);
    }
}
