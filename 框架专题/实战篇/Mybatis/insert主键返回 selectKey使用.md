> 有时候新增一条数据，知道新增成功即可，但是有时候，需要这条新增数据的主键，以便逻辑使用，再将其查询出来明显不符合要求，效率也变低了,这时候，通过一些设置，mybatis可以将insert的数据的主键返回，直接拿到新增数据的主键，以便后续使用。

> 很多时候新增一条数据，仅仅知道操作结果（新增成功）是远远不够的，更多的时候需要这条新增数据的主键，以便下文使用。通常的办法是：先新增，后将其查询出来，这在MySQL中有专门的函数可以获取到：SELECT LAST_INSERT_ID()，顾名思义，此函数的目的是获取最后插入的自增ID。



> mybatis中通过一些设置可以将insert的数据的主键返回，直接拿到新增数据的主键，以便后续使用，主要有两种场景，分别针对mysql和oracle进行设置

http://www.mybatis.cn/archives/909.html



## @SelectKey简介

@SelectKey注解的作用域是方法，效果与<selectKey>标签等同。

@SelectKey注解用在已经被 @Insert 或 @InsertProvider 或 @Update 或 @UpdateProvider 注解了的方法上。若在未被上述四个注解的方法上作 @SelectKey 注解则视为无效。



## @SelectKey的应用场景

如果向数据库中插入一条数据，同时有希望返回该条记录的主键，该怎么处理了？有两种情况：

（1）数据库主键不是自增列，需要预先生成
（2）是自增列，插入之后才能获知

这两种情况都可以通过SelectKey解决，第一个种就是before，第二张是after。



## 使用@Options注解（userGeneratedKeys和keyProperty属性）获取主键





### 补充说明：非自增主键的获取方法