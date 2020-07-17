# 一、编程规约

### (一)命名风格 

1. 命名均**不能以下划线或美元符号开始**，也不能以下划线或美元符号结束

2. 类名使用 UpperCamelCase 风格，但以下情形例外：DO / BO / DTO / VO / AO / PO / UID 等。方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格，**必须遵从 驼峰形式**。

3. **常量命名全部大写**，单词间用下划线隔开

4. 抽象类命名使用 Abstract 或 Base 开头；异常类命名使用 Exception 结尾；测试类 命名以它要测试的类的名称开始，以 Test 结尾。

5. POJO 类中布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。

6. 包名统一使用小写，统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式。

7. 接口类中的方法和属性不要加任何修饰符号（public 也不要加），尽量不要在接口里定义变量

8. 如果是形容能力的接口名称，取对应的形容词为接口名（通常是–able 的形式）。

9. **各层命名规约：**

   A) Service/DAO 层方法命名规约

   ​	1） 获取单个对象的方法用 get 做前缀。 

   ​	2） 获取多个对象的方法用 list 做前缀，复数形式结尾如：listObjects。 

   ​	3） 获取统计值的方法用 count 做前缀。 

   ​	4） 插入的方法用 save/insert 做前缀。 

   ​	5） 删除的方法用 remove/delete 做前缀。 

   ​	6） 修改的方法用 update 做前缀。 

   B) 领域模型命名规约 

   ​	1） 数据对象：xxxDO，xxx 即为数据表名。

    	2） 数据传输对象：xxxDTO，xxx 为业务领域相关的名称。 

   ​	3） 展示对象：xxxVO，xxx 一般为网页名称。 

   ​	4） POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO。

### (二)常量定义 

1. 在 long 或者 Long 赋值时，数值后使用大写的 L，不能是小写的 l，小写容易跟数字 1 混淆，造成误解。

### (三)代码格式 

1. if/for/while/switch/do 等保留字与括号之间都必须加空格。

2. 采用 4 个空格缩进，禁止使用 tab 字符。 说明：如果使用 tab 缩进，必须设置 1 个 tab 为 4 个空格。IDEA 设置 tab 为 4 个空格时， 请勿勾选 Use tab character；而在 eclipse 中，必须勾选 insert spaces for tabs。

3. 示例

   ```java
   public static void main(String[] args) {
       // 缩进 4 个空格
       String say = "hello";
       // 运算符的左右必须有一个空格
       int flag = 0;
       // 关键词 if 与括号之间必须有一个空格，括号内的 f 与左括号，0 与右括号不需要空格
       if (flag == 0) {
           System.out.println(say);
       }
       
       // 左大括号前加空格且不换行；左大括号后换行
       if (flag == 1) {
       	System.out.println("world");
       // 右大括号前换行，右大括号后有 else，不用换行
       } else {
       	System.out.println("ok");
       // 在右大括号后直接结束，则必须换行
       }
   } 
   ```

4. 注释的双斜线与注释内容之间有且仅有一个空格。

   ```java
   // xxxxxxxxxx
   ```

5. 方法参数在定义和传入时，多个参数逗号后边必须加空格。

   ```java
   method(args1, args2, args3); 
   ```

   实参的 args1，后边必须要有一个空格。

6. IDE 的 text file encoding 设置为 UTF-8; IDE 中文件的换行符使用 Unix 格式， 不要使用 Windows 格式。

### (四)OOP 规约 

1. 避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成 本，直接用类名来访问即可。

2. Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。

3. 所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较。

4. 关于基本数据类型与包装数据类型的使用标准如下： 

   1） 【强制】所有的 POJO 类属性必须使用包装数据类型。 

   2） 【强制】RPC 方法的返回值和参数必须使用包装数据类型。 

   3） 【推荐】所有的局部变量使用基本数据类型。

5. 定义 DO/DTO/VO 等 POJO 类时，不要设定任何属性默认值。

6. 构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init 方法中

7. POJO 类必须写 toString 方法

8. 使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无 内容的检查，否则会有抛 IndexOutOfBoundsException 的风险。

   ```java
   String str = "a,b,c,,";
   String[] ary = str.split(",");
   // 预期大于 3，结果是 3
   System.out.println(ary.length); 
   ```

9.  类内方法定义的顺序依次是：公有方法或保护方法 > 私有方法 > getter/setter 方法。

   > 公有方法是类的调用者和维护者最关心的方法，首屏展示最好；保护方法虽然只是子类 关心，也可能是“模板设计模式”下的核心方法；而私有方法外部一般不需要特别关心，是一个 黑盒实现；因为承载的信息价值较低，所有 Service 和 DAO 的 getter/setter 方法放在类体 最后。

10. 循环体内，字符串的连接方式，使用 StringBuilder 的 append 方法进行扩展。

### (五)集合处理 

1.  **【强制】关于 hashCode 和 equals 的处理，遵循如下规则：**

   1） 只要重写 equals，就必须重写 hashCode。 

   2） 因为 Set 存储的是不重复的对象，依据 hashCode 和 equals 进行判断，所以 Set 存储的 对象必须重写这两个方法。 

   3） 如果自定义对象作为 Map 的键，那么必须重写 hashCode 和 equals。

   > String 重写了 hashCode 和 equals 方法，所以我们可以非常愉快地使用 String 对象 作为 key 来使用。

2. **【强制】ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException 异常**，即 java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。

   > subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 而是 ArrayList 的一个视图，对于 SubList 子列表的所有操作最终会反映到原列表上。

3.  **【强制】在 subList 场景中，高度注意对原集合元素的增加或删除，均会导致子列表的遍历、 增加、删除产生 ConcurrentModificationException 异常。**

4. **【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全 一样的数组，大小就是 list.size()。**

   > 使用 toArray 带参方法，入参分配的数组空间不够大时，toArray 方法内部将重新分配 内存空间，并返回新数组地址；如果数组元素个数大于实际所需，下标为[ list.size() ] 的数组元素将被置为 null，其它数组元素保持原值，因此最好将方法入参数组大小定义与集 合元素个数一致。

   ```java
   List<String> list = new ArrayList<String>(2);
   list.add("guan");
   list.add("bao");
   String[] array = new String[list.size()];
   array = list.toArray(array); 
   ```

   直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它 类型数组将出现 ClassCastException 错误。

5. **【强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方 法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。**

   > asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配器模式，只是转换接口，后台的数据仍是数组。

   ```java
   String[] str = new String[] { "you", "wu" };
    List list = Arrays.asList(str);
   ```

   第一种情况：list.add("yangguanbao"); 运行时异常。 第二种情况：str[0] = "gujin"; 那么 list.get(0)也会随之修改。

6. **【强制】泛型通配符来接收返回的数据，此写法的泛型集合不能使用 add 方 法，而不能使用 get 方法，作为接口调用赋值时易出错。**

   > 扩展说一下 PECS(Producer Extends Consumer Super)原则：第一、频繁往外读取内 容的，适合用。第二、经常往里插入的，适合用。

7. **【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator 方式，如果并发操作，需要对 Iterator 对象加锁。**

   ```java
   // 正例
   List<String> list = new ArrayList<>();
   list.add("1");
   list.add("2");
   Iterator<String> iterator = list.iterator();
   while (iterator.hasNext()) {
   	String item = iterator.next();
   	if (删除元素的条件) {
   		iterator.remove();
   	}
   }
   // 反例：
   for (String item : list) {
   	if ("1".equals(item)) {
   		list.remove(item);
   	}
   } 
   // 把"1"换成"2"
   for (String item : list) {
   	if ("2".equals(item)) {
   		list.remove(item);
   	}
   } 
   ```

8.  **【强制】在 JDK7 版本及以上，Comparator 实现类要满足如下三个条件，不然 Arrays.sort， Collections.sort 会报 IllegalArgumentException 异常。**

   > 说明：三个条件如下 
   >
   > 1） x，y 的比较结果和 y，x 的比较结果相反。 2） x>y，y>z，则 x>z。 
   >
   > 3） x=y，则 x，z 比较结果和 y，z 比较结果相同。

9.  **【推荐】集合泛型定义时，在 JDK7 及以上，使用 diamond 语法或全省略。**

   > 菱形泛型，即 diamond，直接使用<>来指代前边已经指定的类型。

   ```java
   // <> diamond 方式
   HashMap<String, String> userCache = new HashMap<>(16);
   // 全省略方式
   ArrayList<User> users = new ArrayList(10); 
   ```

10. **【推荐】使用 entrySet 遍历 Map 类集合 KV，而不是 keySet 方式进行遍历。**

    > keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出 key 所对应的 value。而 entrySet 只是遍历了一次就把 key 和 value 都放到了 entry 中，效 率更高。如果是 JDK8，使用 Map.foreach 方法。
    >
    > - values()返回的是 V 值集合，是一个 list 集合对象；
    >
    > - keySet()返回的是 K 值集合，是 一个 Set 集合对象；
    >
    > - entrySet()返回的是 K-V 值组合集合。

11.  **【推荐】高度注意 Map 类集合 K/V 能不能存储 null 值的情况**

    > 由于 HashMap 的干扰，很多人认为 ConcurrentHashMap 是可以置入 null 值，而事实上， 存储 null 值时会抛出 NPE 异常。

12. 【参考】利用 Set 元素唯一的特性，可以快速对一个集合进行去重操作，避免使用 List 的 contains 方法进行遍历、对比、去重操作。

### (六)并发处理 

1. **【强制】获取单例对象需要保证线程安全，其中的方法也要保证线程安全**

   > 资源驱动类、工具类、单例工厂类都需要注意。

2. **【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。**

   > 使用线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决 资源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或 者“过度切换”的问题。

3. **【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。**

   > **Executors 返回的线程池对象的弊端**如下：
   >
   > 1）FixedThreadPool 和 SingleThreadPool: 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。 
   >
   > 2）CachedThreadPool 和 ScheduledThreadPool: 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。

4.  **【强制】SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为 static，必须加锁，或者使用 DateUtils 工具类。**

   ```java
   // 正例：注意线程安全，使用 DateUtils。亦推荐如下处理：
   private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
   	@Override
   	protected DateFormat initialValue() {
   		return new SimpleDateFormat("yyyy-MM-dd");
   	}
   }; 
   ```

   > 如果是 JDK8 的应用，可以使用 Instant 代替 Date，LocalDateTime 代替 Calendar， DateTimeFormatter 代替 SimpleDateFormat，官方给出的解释：simple beautiful strong immutable thread-safe。

5. 【强制】高并发时，同步调用应该去考量锁的性能损耗。能用无锁数据结构，就不要用锁；能 锁区块，就不要锁整个方法体；能用对象锁，就不要用类锁。 

   说明：尽可能使加锁的代码块工作量尽可能的小，**避免在锁代码块中调用 RPC 方法。**

   > ?

6. **【强制】对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造 成死锁。**

   > 线程一需要对表 A、B、C 依次全部加锁后才可以进行更新操作，那么线程二的加锁顺序 也必须是 A、B、C，否则可能出现死锁。

7. **【强制】并发修改同一记录时，避免更新丢失，需要加锁。要么在应用层加锁，要么在缓存加 锁，要么在数据库层使用乐观锁，使用 version 作为更新依据。** 

   > 说明：如果每次访问冲突概率小于 20%，推荐使用乐观锁，否则使用悲观锁。乐观锁的重试次 数不得小于 3 次。

8. **【强制】多线程并行处理定时任务时，Timer 运行多个 TimeTask 时，只要其中之一没有捕获 抛出的异常，其它任务便会自动终止运行，使用 ScheduledExecutorService 则没有这个问题。**

9. **【推荐】使用 CountDownLatch 进行异步转同步操作，每个线程退出前必须调用 countDown 方法，线程执行代码注意 catch 异常，确保 countDown 方法被执行到，避免主线程无法执行 至 await 方法，直到超时才返回结果。**

   > 注意，子线程抛出异常堆栈，不能在主线程 try-catch 到。

10.  **【推荐】避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一 seed 导致的性能下降。**

    > 说明：Random 实例包括 java.util.Random 的实例或者 Math.random()的方式。 正例：在 JDK7 之后，可以直接使用 API ThreadLocalRandom，而在 JDK7 之前，需要编码保 证每个线程持有一个实例。

11. 【参考】volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题， 但是如果多写，同样无法解决线程安全问题。如果是 count++操作，使用如下类实现： AtomicInteger count = new AtomicInteger(); count.addAndGet(1); 如果是 JDK8，推 荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观锁的重试次数）。

12. 【参考】 HashMap 在容量不够进行 resize 时由于高并发可能出现死链，导致 CPU 飙升，在 开发过程中可以使用其它数据结构或加锁来规避此风险。

13. . 【参考】ThreadLocal 无法解决共享对象的更新问题，ThreadLocal 对象建议使用 static 修饰。这个变量是针对一个线程内所有操作共享的，所以设置为静态变量，所有此类实例共享 此静态变量 ，也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只 要是这个线程内定义的)都可以操控这个变量。

### (七)控制语句

1.  【强制】在一个 switch 块内，每个 case 要么通过 break/return 等来终止，要么注释说明程 序将继续执行到哪一个 case 为止；在一个 switch 块内，都必须包含一个 default 语句并且 放在最后，即使空代码。

2. **【强制】在高并发场景中，避免使用”等于”判断作为中断或退出的条件。** 

   > 说明：如果并发控制没有处理好，容易产生等值判断被“击穿”的情况，使用大于或小于的区间 判断条件来代替。

3. **【推荐】避免采用取反逻辑运算符。**

   > 取反逻辑不利于快速理解，并且取反逻辑写法必然存在对应的正向逻辑写法

4. **【推荐】接口入参保护，这种场景常见的是用作批量操作的接口**。

   > 接口入参保护，“保护”的是**服务端应用**，即接口提供方，最常见的做法就是校验入参的有效值范围和设置批量操作白名单

### (八)注释规约 

1. **【强制】所有的抽象方法（包括接口中的方法）必须要用 Javadoc 注释、除了返回值、参数、 异常说明外，还必须指出该方法做什么事情，实现什么功能。**

   > 对子类的实现要求，或者调用注意事项，请一并说明。

2. **【强制】所有的枚举类型字段必须要有注释，说明每个数据项的用途。**

### (九)其它

1. **【强制】在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。**

   > - 不要在方法体内定义：Pattern pattern = Pattern.compile(“规则”);
   > - Pattern 表达式要提前定义，不要再需要的地方临时定义；
   >
   > - Pattern 表达式要定义为 static final 静态变量，以避免执行多次预编译。

2. 【强制】后台输送给页面的变量必须加$!{var}——中间的感叹号。

   > 如果 var 等于 null 或者不存在，那么${var}会直接显示在页面上。

3. 【强制】注意 Math.random() 这个方法返回是 double 类型，注意取值的范围 0≤x<1（能够 取到零值，注意除零异常），如果想获取整数类型的随机数，不要将 x 放大 10 的若干倍然后 取整，直接使用 Random 对象的 nextInt 或者 nextLong 方法。

4. 【强制】获取当前毫秒数 System.currentTimeMillis(); 而不是 new Date().getTime(); 说明：如果想获取更加精确的纳秒级时间值，使用 System.nanoTime()的方式。在 JDK8 中， 针对统计时间等场景，推荐使用 Instant 类。

5. **【推荐】任何数据结构的构造或初始化，都应指定大小，避免数据结构无限增长吃光内存。**

   

# 二、异常日志

### (一)异常处理 

1. 【强制】finally 块必须对资源对象、流对象进行关闭，有异常也要做 try-catch。

   > 如果 JDK7 及以上，可以使用 try-with-resources 方式。

2.  **【强制】不要在 finally 块中使用 return。**

   > finally 块中的 return 返回后方法结束执行，不会再执行 try 块中的 return 语句。

3. **【推荐】防止 NPE，是程序员的基本修养，注意 NPE 产生的场景**

   > 1）返回类型为基本数据类型，return 包装数据类型的对象时，自动拆箱有可能产生 NPE。 反例：public int f() { return Integer 对象}， 如果为 null，自动解箱抛 NPE。 
   >
   > 2） 数据库的查询结果可能为 null。 
   >
   > 3） 集合里的元素即使 isNotEmpty，取出的数据元素也可能为 null。 
   >
   > 4） 远程调用返回对象时，一律要求进行空指针判断，防止 NPE。 
   >
   > 5） 对于 Session 中获取的数据，建议 NPE 检查，避免空指针。 
   >
   > 6） 级联调用 obj.getA().getB().getC()；一连串调用，易产生 NPE。 
   >
   > 正例：使用 JDK8 的 Optional 类来防止 NPE 问题。

4. **【参考】对于公司外的 http/api 开放接口必须使用“错误码”；而应用内部推荐异常抛出； 跨应用间 RPC 调用优先考虑使用 Result 方式，封装 isSuccess()方法、“错误码”、“错误简 短信息”。**

   > 关于 RPC 方法返回方式使用 Result 方式的理由： 1）使用抛异常返回方式，调用方如果没有捕获到就会产生运行时错误。 2）如果不加栈信息，只是 new 自定义异常，加入自己的理解的 error message，对于调用 端解决问题的帮助不会太多。如果加了栈信息，在频繁调用出错的情况下，数据序列化和传输 的性能损耗也是问题。

### (二)日志规约

1.  【强制】应用中不可直接使用日志系统（Log4j、Logback）中的 API，而应依赖使用日志框架 SLF4J 中的 API，使用门面模式的日志框架，有利于维护和各个类的日志处理方式统一。

   ```java
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;
   private static final Logger logger = LoggerFactory.getLogger(Abc.class); 
   ```

2. 【强制】避免重复打印日志，浪费磁盘空间，务必在 log4j.xml 中设置 additivity=false。

   ```xml
   <logger name="com.taobao.dubbo.config" additivity="false"> 
   ```

3. 【推荐】谨慎地记录日志。生产环境禁止输出 debug 日志；有选择地输出 info 日志；如果使 用 warn 来记录刚上线时的业务行为信息，一定要注意日志输出量的问题，避免把服务器磁盘 撑爆，并记得及时删除这些观察日志。

4. 【推荐】可以使用 warn 日志级别来记录用户输入参数错误的情况，避免用户投诉时，无所适 从。如非必要，请不要在此场景打出 error 级别，避免频繁报警。

   > 注意日志输出的级别，error 级别只记录系统逻辑出错、异常或者重要的错误信息。

# 三、单元测试

1. 【强制】好的单元测试必须遵守 AIR 原则。

   > 说明：单元测试在线上运行时，感觉像空气（AIR）一样并不存在，但在测试质量的保障上， 却是非常关键的。好的单元测试宏观上来说，具有自动化、独立性、可重复执行的特点。 
   >
   >  A：Automatic（自动化） 
   >
   >  I：Independent（独立性） 
   >
   >  R：Repeatable（可重复）

2.  【强制】单元测试应该是全自动执行的，并且非交互式的。测试用例通常是被定期执行的，执 行过程必须完全自动化才有意义。输出结果需要人工检查的测试不是一个好的单元测试。单元 测试中不准使用 System.out 来进行人肉验证，必须使用 assert 来验证。

3.  【推荐】编写单元测试代码遵守 BCDE 原则，以保证被测试模块的交付质量。

   >  B：Border，边界值测试，包括循环边界、特殊取值、特殊时间点、数据顺序等。 
   >
   >  C：Correct，正确的输入，并得到预期的结果。 
   >
   >  D：Design，与设计文档相结合，来编写单元测试。 
   >
   >  E：Error，强制错误信息输入（如：非法数据、异常流程、非业务允许输入等），并得 到预期的结果。

# 四、安全规约

1. 【强制】用户输入的 SQL 参数严格使用参数绑定或者 METADATA 字段值限定，防止 SQL 注入， 禁止字符串拼接 SQL 访问数据库。

2. 【强制】用户请求传入的任何参数必须做有效性验证。

   > 说明：忽略参数校验可能导致： 
   >
   >  page size 过大导致内存溢出 
   >
   >  恶意 order by 导致数据库慢查询 
   >
   >  任意重定向 
   >
   >  SQL 注入 
   >
   >  反序列化注入 
   >
   >  正则输入源串拒绝服务 ReDoS 
   >
   > Java 代码用正则来验证客户端的输入，有些正则写法验证普通用户输入没有问题， 但是如果攻击人员使用的是特殊构造的字符串来验证，有可能导致死循环的结果。

3.  【强制】表单、AJAX 提交必须执行 CSRF 安全验证。

   > CSRF(Cross-site request forgery)跨站请求伪造是一类常见编程漏洞。对于存在 CSRF 漏洞的应用/网站，攻击者可以事先构造好 URL，只要受害者用户一访问，后台便在用户 不知情的情况下对数据库中用户参数进行相应修改

# 五、Mysql数据库

### (一)建表规约 