### 尝试使用 Lambda/Stream/Guava
##### 做了这个题和必做题


lambda方式里 添加了函数式接口

- 消费型接口 Consumer


抽象方法： void accept(T t)：接收一个参数进行消费，但无需返回结果。

- 供给型接口 Supplier

抽象方法： T get()：返回一个自定义数据。

- 功能型接口 Function<T,R>

抽象方法： R apply(T t)：传入一个参数，返回想要的结果。

- 谓词型接口 Predicate

抽象方法：boolean test(T t)：传入一个参数，返回一个布尔值。



guava的是照demo打了一遍。
