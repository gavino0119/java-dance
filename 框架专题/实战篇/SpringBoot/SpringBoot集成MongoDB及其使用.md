## MongoDB 简介

## MongoDB 的增删改查



## Robo 3T的基本使用

## SpringBoot整合MongoDB

### 主要依赖

```java
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

### 常用API

> 一、save方法
> 遍历插入
> 若新增数据的主键已经存在，则会对当前已经存在的数据进行修改操作
>
> ```java
> mongoTemplate.save(user);
> ```
>
> 二、insert方法
> 一次性插入一整个列表，而不用进行遍历操作，效率相对较高
> 若新增数据的主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常提示主键重复，不保存当前数据。
>
> ```java
> mongoTemplate.insert(user);
> ```
>
> 三、批量插入
>
> ```java
> ArrayList<User> manyUser = new ArrayList<>();
> User user1 = new User();
> User user2 = new User();
> manyUser.add(user1);
> manyUser.add(user2);
> mongoTemplate.insertAll(manyUser);
> ```
>
> 四、插入嵌套文档
> 这种复杂的数据结构如果直接使用javabean是比较麻烦的，这种比较复杂的数据结构，
> 需要拿到json字符串，并将其转换成json对象，即可直接插入到mongodb中
>
> ```java
> String classStr = "{'classId':'1','Students':[{'studentId':'1','name':'zhangsan'}]}";
> JSONObject parseObject = JSON.parseObject(classStr);
> mongoTemplate.insert(parseObject,"class");//class为collection
> ```
>
> 五、更新数据
> upsert和updateFirst、updateMulti
>
> upsert方法时如果query条件没有筛选出对应的数据，那么upsert会插入一条新的数据，而update什么都不会做，等同于关系型数据库中的merge和update。
>
> ```java
> mongoTemplate.updateFirst(query, update, "class");
> mongoTemplate.updateMulti(query, update, "class");
> ```
>
> 
>
> 获取数量
>
> ```java
> mongoTemplate.count(query, User.class);
> ```
>
> software\DB\mysql\mysql-8.0.20-winx64

### 多数据源 MongoDB 的使用