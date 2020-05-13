### 核心数据结构

1. 为什么链表长度>=8时，链表转红黑树？

   > 服从统计学的泊松分布

2. hash冲突

   > index = hash%length   
   >
   > hash是随机的，有可能会相同，从而定位到同一索引

3. hash碰撞的解决

   > 引入链表（单链表即可）
   >
   > 

4. 红黑树的引入

   > **链表的缺陷**：相比数组，如果链表过长，查询效率会很低（O(N)），从而引入红黑树
   >
   > 红黑树接近于平衡二叉树
   >
   > 红黑树的缺点：维护时需要进行左旋和右旋、重新着色操作
   >
   > 
   >
   > 

5. 

### 为何初始容量是2的指数次幂？

> **效率更快（位运算求index）**
>
> ​	index = hash & (length-1)， 和index = hash%length 取得的值是一样的，但是length为2的指数次幂，length-1 为全1 的形式，计算起来落槽更快

### 负载因子为什么是0.75？

> 从空间和时间上进行折中

### java7的HashMap 扩容死锁和环链形成



java8的HashMap 扩容优化? 如何做到扩容无需rehash?

> 优化：
>
> ​	定义四个指针，分为两组，为高位和低位





## 面试点

1. hashtable和hashmap区别 ？ 除了线程安全方面 还有啥区别？ 如果在hashmap上也用syn，它俩一样吗 ？

   >  hashtable  保留了头插法 
   >
   >  一个初始值是 11 一个是16 
   >
   >   https://blog.csdn.net/xuhuaabc/article/details/91475761
   >
   >  https://zhidao.baidu.com/question/566092015966091884.html
   >
   >  1.继承的父类不同
   >
   >   HashMap继承自AbstractMap类。但二者都实现了Map接口。
   >   Hashtable继承自Dictionary类，Dictionary类是一个已经被废弃的类（见其源码中的注释）。父类都被废弃，自然而然也没人用它的子类Hashtable了。 
   >
   >  
   >
   >  4.两个遍历方式的内部实现上不同。
   >
   >  Hashtable、HashMap都使用了 Iterator。而由于历史原因，Hashtable还使用了Enumeration的方式 。
   >
   >  5.哈希值的使用不同，HashTable直接使用对象的hashCode。而HashMap重新计算hash值。代码是这样的： 
   >  int hash = key.hashCode(); 
   >  int index = (hash & 0x7FFFFFFF) % tab.length; 
   >  而HashMap重新计算hash值，而且用与代替求模： 
   >  int hash = hash(k); 
   >  int i = indexFor(hash, table.length); 
   >
   >  6.Hashtable和HashMap它们两个内部实现方式的数组的初始大小和扩容的方式。HashTable中hash数组默认大小是11，增加的方式是 old*2+1。HashMap中hash数组的默认大小是16，而且一定是2的指数。 

2.  hashmap在多线程下容易死循环 ,那在单线程下hashtable和hashmap有什么区别？哪个快？

   > 锁消耗在单线程下可忽略

3. JDK1.8前HashMap也是采用头插法迁移数据，多线程情况下会造成死循环，JDK1.8对HashMap做出了优化，为什么JDK1.8Hashtable还是采用头插法的方式迁移数据？

   >  Hashtable是线程安全的，所以Hashtable不需要考虑并发冲突问题，可以采用效率更高的头插法。
   > ————————————————
   >
   > HashMap  JDK8以前是头插法，JDK8后是尾插法 ,因为 头插法会造成死链 