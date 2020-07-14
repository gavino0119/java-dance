## Oracle 简介

Oracle 安装

Oracle 基础命令

Oracle 客户端工具

## Oracle 服务

 Oracle在window下安装完毕，会安装很多服务 

1. **OracleService+服务名（ORCL）:**

   该服务是Oracle数据库的基础，只有启动该服务才能正常使用Oracle数据库。

2. **OracleOraDb11g_home1TNSlistener ：**

   该服务为Oracle客户端提供监听程序的服务，只有启动该服务，本地的客户端程序才能通过监听连接到数据库，和数据库进行交互。

**注意：**

```
以上两个服务必须启动（建议手动启动），其他服务为非必须启动
在使用第三方客户端连接Oracle数据库时，OracleOraDb11g_home1TNSlistener 服务必须启动，才能连接到远程数据库！
```

## Oracle 用户

> oracle用户的概念对于Oracle数据库至关重要，在现实环境当中一个服务器一般只会安装一个Oracle实例，一个Oracle用户代表着一个用户群，他们通过该用户登录数据库，进行数据库对象的创建、查询等开发。
>
> 每一个用户对应着该用户下的N多对象，因此，在实际项目开发过程中，不同的项目组使用不同的Oracle用户进行开发，不相互干扰。也可以理解为一个Oracle用户既是一个业务模块，这些用户群构成一个完整的业务系统，不同模块间的关联可以通过Oracle用户的权限来控制，来获取其它业务模块的数据和操作其它业务模块的某些对象。

## SQL语句介绍

在 Oracle 开发中，客户端把 SQL 语句发送给服务器，服务器对 SQL 语句进行编译、执行，把执行的结果返回给客户端。常用的SQL语句大致可以分为五类：

- 数据定义语言（DDL），包括 CREATE（创建）命令、 ALTER（修改）命令、 DROP（删除）命令等。
- 数据操纵语言（DML），包括 INSERT（插入）命令、 UPDATE（更新）命令、 DELETE（删除）命令、 SELECT … FOR UPDATE（查询）等。
- 数据查询语言（DQL），包括基本查询语句、 Order By 子句、 Group By 子句等。
- 事务控制语言（TCL），包括 COMMIT（提交）命令、 SAVEPOINT（保存点）命令、ROLLBACK（回滚）命令。   
- 数据控制语言（DCL）， GRANT（授权）命令、 REVOKE（撤销）命令。

## Oracle 表介绍

#### （一）Oracle建表(create table)

1. **Oracle字段数据类型**

2. **create table语句**

   

#### （二）Oracle查询（select） 

1.  **select命令结构**

   ```sql
   select *|列名|表达式 from 表名 where 条件 order by 列名
   ```

   

2. **备份查询数据**

    Oracle进行表数据备份时，可以利用create table（建表）的方式对select查询的结果进行快速备份。 

    备份查询数据命令结构： 

   ```sql
   create table 表名 as select 语句
   ```

   

#### （三）Oracle插入（insert into）

1.  **insert 命令结构** 

   ```sql
   insert into 表名（列名1,列名2,列名3.....）values(值1,值2,值3.....);
   ```

   

2. **insert插入一个select的结果集**

    在 Oracle 中，一个 INSERT 命令可以把一个select结果集一次性插入到一张表中。 

    语法结构如下： 

   ```sql
   INSERT INTO 表 SELECT 子句，
   ```

   

**注意**

> 数据操纵语言（DML）包括 INSERT（插入）命令、 UPDATE（更新）命令、 DELETE（删除）命令、 SELECT … FOR UPDATE（查询）等。只有提交（commit）后才能持久化到数据库。

（四）Oracle 建表

Oracle 运算符

Oracle 系统关键字

Oracle 集合运算

Oracle 连接查询

Oracle 伪例

Oracle 内置函数

Oracle 子查询

Oracle 同义词

Oracle 序列

Oracle 视图

Oracle 索引



