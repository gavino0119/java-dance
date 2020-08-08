# 概述

​	Spring中有个**RestTemplate**类用来发送HTTP请求很方便    

​	RestTemplate与httpClient类似，都是java中可以模拟http请求的封装。httpClient的使用，已经在另一篇文章中有所论述，但是RestTemplate比httpClient更优雅，它是spring中的一个封装功能。

​    RestTemplate也是java中的模板类。采用的设计模式中的模板模式。



# springboot对RestTemplate的集成





# 其他

## 一、OKHttp

​	在SpringBoot应用中，发送Http通常我们使用RestTemplate，但有部分组件底层是使用OkHttp进行Http的操作，而且OKHttp也是一个很优秀的HTTP组件。

​	1、高效的HTTP客户端，它能允许同一ip和端口的请求重用一个socket，这种方式能大大降低网络连接的时间，和每次请求都建立socket，再断开socket的方式相比，降低了服务器服务器的压力，透明的GZIP压缩减少响应数据的大小；缓存响应内容。
 	2、okhttp 对http和https都有良好的支持。
​	 3、okhttp 对大数据量的网络请求支持非常好。



> 特点
>
> 1.支持http和https协议,api相同,易用; 
>
> 2.http使用线程池,https使用多路复用; 
>
> 3.okhttp支持同步和异步调用; 
>
> 4.支持普通form和文件上传form; 
>
> 5.提供了拦截器,操作请求和响应(日志,请求头,body等); 
>
> 6.okhttp可以设置缓存;

## 二、HttpClient



# 在微服务中的使用

> 1、第三方服务调用, 常用 RestTemplate, 这里RestTemplate未进行封装，直接使用其方法。
>
> 2、微服务间调用，使用feign，同时使用OKhttp替换feign中默认的httpClient。
>  Feign在默认情况下使用的是JDK原生的URLConnection发送HTTP请求，没有连接池，但是对每个地址会保持一个长连接，即利用HTTP的persistence connection 。 我们可以用**HTTP Client 或 OKhttp 替换Feign原始的http client**, 从而获取连接池、超时时间等与性能息息相关的控制能力。

# 总结

​    整个restTemplate比httpClient使用更加优雅，分装的更好

​    restTemplate是org.springframework.web.client包中的类,是spring提供的类。

​    httpclient是org.apache.http.client包中的类，是apache提供的类。