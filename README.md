# 图书管理系统

#### 该系统使用技术：

#### eclipse（或IDEA）+ mysql + jdk 1.7 + WindowBuilder插件



### 1.实现功能

- 登录界面

- 图书管理系统主界面

- 图书类别添加

- 图书类别维护

- 安全退出

- 关于我们——基本信息

### 2.未实现功能

- 图书添加
- 图书维护



### 系统登录

账号：1

密码：1



### 入口函数

运行LogOnFrm.java文件



### 数据库建表

#### t_book表中：

属性：

id主键，自增  
bookName  
author  
sex  
price 
bookTypeld  
bookDesc  

#### t_bookType表中：

属性：

id主键  
bookTypeName  
bookTypeDesc  

#### t_user表中：

属性：

id主键  
userName  
password  



##### 外键

名  		  	t_bookibfk1;  
字段			 bookTypeld  
参考模式	 db_ book   
参考表	  	t_booktype  
参考字段   id  
删除时	    RESTRICT  
更新时	    RESTRICT 

