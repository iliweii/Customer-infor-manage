# JAVA实训项目 客户管理系统

## 项目说明

​	客户关系管理（[CRM](https://baike.baidu.com/item/CRM/165070)）起源于80年代初提出的“接触管理”，即专门搜集整理客户联系的所有信息，至90年代初演变为包括电话服务、网络支撑、数据库支持等资料分析的“客户服务”。经过近20年的不断发展，[CRM](https://baike.baidu.com/item/CRM/165070)最终形成一套基于客户价值管理的完整的理论体系。它既是一种“以客户为中心”的企业经营服务的理念；也是一整套优化市场资源、整合营销渠道、提升服务价值等面向客户的业务流程；增强企业内部部门间协同工作的能力，加快客户服务和支持的相应速度、提高客户满意度和忠诚度的解决方案。 

​     本系统以[CRM](https://baike.baidu.com/item/CRM/165070)为基础，实现了基本的客户资料录入，按城市查询客户，修改客户资料，删除客户资料，浏览已经保存的客户资料，这些基本功能，为学生者讲解一个开发的入门。

## 目录说明

文件包括实训报告、实训记录、实训总结。

文件夹包括客户资料管理系统项目源码及SQL数据库备份文件。

## 如何快速运行程序

### 1、导入项目代码

打开eclipse或者其他Java编辑器，这里以eclipse为例。

右键选择Import

[![OjEu.png](http://img.cywacg.com/images/2020/01/10/OjEu.png)](http://img.cywacg.com/image/OjEu)

Select an import wizard: 选择General > Existing Projects into Workspace.

然后进入Select a directory to search for existing Eclipse Project.界面，

Select root directory > Browse 选择下载项目代码的根目录，Options 选中Copy newly imported projects upon completion，完成导入。

### 2、导入数据库文件

运行MySQL服务。

导入数据库文件[![Ol6o.png](http://img.cywacg.com/images/2020/01/10/Ol6o.png)](http://img.cywacg.com/image/Ol6o)

### 3、修改项目配置文件

打开crms工程目录下src > c3p0-config.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>
	<named-config name="tcbd1011">
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/crms?useSSL=false&amp;characterEncoding=utf-8&amp;useUnicode=true</property>
		<property name="user">root</property>
		<property name="password">root</property>
		<property name="maxPoolSize">20</property>
		<property name="minPoolSize">3</property>
		<property name="maxStatements">30</property>
		<property name="maxIdleTime">150</property>
	</named-config>
</c3p0-config>
```

其中jdbcUrl属性中3306为数据库端口号（一般默认），crms为数据库名字（导入成功后自动创建）

user属性为数据库登录名

password属性为数据库密码

### 4、运行项目

打开crms工程目录下src > cn.edu.sdut.customer.user.swing，LoginFrame.java

右键 Run As > 1 Java Application[![Omsn.png](http://img.cywacg.com/images/2020/01/10/Omsn.png)](http://img.cywacg.com/image/Omsn)

### 5、运行结果

[![OLUA.png](http://img.cywacg.com/images/2020/01/10/OLUA.png)](http://img.cywacg.com/image/OLUA)

使用    用户名:root，密码:1234    登录高级管理员管理界面

[![ONVZ.png](http://img.cywacg.com/images/2020/01/10/ONVZ.png)](http://img.cywacg.com/image/ONVZ)

点击"关于我们"按钮弹出浏览器页面打开指定链接。

[![OX4O.png](http://img.cywacg.com/images/2020/01/11/OX4O.png)](http://img.cywacg.com/image/OX4O)