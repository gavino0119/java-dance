### HashSet

- 它存储唯一元素并允许空值
- 它由HashMap支持
- 它不保持插入顺序
- 它不是线程安全的



 请注意，在创建HashSet的实例时，会初始化此内部HashMap 



# HashMap

 HashMap在初始化的时候，会制定初始容量（16）和加载因子（扩容临界值0.75，意思就是当容量达到10*0.75=12的时候就会扩容）： 

 在HashMap的内部通过Entry数组来保存键值对，那个这个Entry是怎么实现的呢？ 

 HashMap内部数组存储的是键值对，也就是Entry对象，Entry对象保存了键、值，并持有一个next指针指向下一个Entry对象（HashMap通过链表法解决冲突）：
    我们都知道HashMap是通过数组来存储的，那如何通过链表法来解决冲突的呢？举个栗子，定义一个HashMap，当调用put的时候，会根据key的hashCode值计算出一个位置，也就是要存储在数组中的位置，如果这个位置没有对象，就将该对象直接放进数组中：
————————————————
 如果该位置已经有对象了，则顺着此存在的对象的链开始寻找（Entry类有一个Entry类型的next成员变量，指向了该对象的下一个对象） 

 如果此链上有对象的话，就去使用equals方法进行比较，如果对此链上某个对象的equals方法比较为false，就把改对象放到数组中，将数组中该位置以前存在的那个对象链接到次对象的后面。 

 HashMap存值的时候，遵循的是LRU（Least Recently Used）算法，就是最近最少使用，意思就是系统认为最近使用的值可能会被系统经常用到，而添加的早的值用到的几率会小。  

 不允许两个键相同，如果相同，则后插入的键所对应的值会覆盖掉之前的值。 
   HashMap是通过调用hash()方法获得键的hash值，并通过indexFor方法找到实际插入位置 

 put方法通过addEntry方法将键值插入到合适的位置，当容量查过阈值（threshold）时，会发生扩容，扩容一倍。 



### 1. HashSet如何保持唯一性？

当我们将一个对象放入一个HashSet时，它使用该对象的hashcode值来确定一个元素是否已经在该集合中。

每个散列码值对应于某个块位置，该块位置可以包含计算出的散列值相同的各种元素。但是具有相同hashCode的两个对象可能不相等。

因此，将使用equals（）方法比较同一存储桶中的对象。







HashSet实现Set接口，由哈希表（实际上是一个HashMap实例）支持。它不保证set 的迭代顺序；特别是它不保证该顺序恒久不变。此类允许使用null元素。HashSet中不允许有重复元素，这是因为HashSet是基于HashMap实现的，HashSet中的元素都存放在HashMap的key上面，而value中的值都是统一的一个**private static final Object PRESENT = new Object();**。HashSet跟HashMap一样，都是一个存放链表的数组。

　　HashSet中add方法调用的是底层HashMap中的put()方法，而如果是在HashMap中调用put，首先会判断key是否存在，如果key存在则修改value值，如果key不存在这插入这个key-value。而在set中，因为value值没有用，也就不存在修改value值的说法，因此往HashSet中添加元素，首先判断元素（也就是key）是否存在，如果不存在这插入，如果存在着不插入，这样HashSet中就不存在重复值。



 对于HashSet而言，它是基于HashMap实现的，HashSet底层使用HashMap来保存所有元素，更确切的说，HashSet中的元素，只是存放在了底层HashMap的key上， 而value使用一个static  final的Object对象标识。因此HashSet 的实现比较简单，相关HashSet的操作，基本上都是直接调用底层HashMap的相关方法来完成 

