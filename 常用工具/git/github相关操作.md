### github常用命令

**一、从本地上传**

git add .

git commit -m "xxx"

**二、下载**

git clone `<repo>(仓库)`

git clone `<repo>(仓库)` `<directory>（到本地目录）`

### 项目上传

> ```shell
> git init
> git add .
> git commit -m "first commit"
> git push -u origin master
> ```
>
> 

### github搜索开源项目

1. 搜索项目名中包含某些关键字的的项目

   **in:name key **    

   * 如：in:name spring boot	[名字里面带有spring boot]
   * 如：in:name spring boot stars>3000	[名字里面带有spring boot且stars数大于3000的]

   

2. 搜索项目详情中包含某些关键字的的项目

   **in:readme key**

   * 如：in:readme spring boot	[详情介绍里面带有spring boot]

3. 在描述中搜索项目包含某些关键字的的项目

   **in:description key**

   * 如：in:description 微服务 language:java pushed:>2019-09-03	[搜索java相关的最新提交时间为2019的微服务项目]

### hexo搭建博客


​	hexo new "文章名"    新建文章
​	hexo g 	                    生成静态网页
​	hexo s 	                     可以本地预览效果
​	hexo d 	                    上传到github上