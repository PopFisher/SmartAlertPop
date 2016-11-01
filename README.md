# SmartAlertPop
&nbsp;&nbsp;&nbsp;&nbsp;封装一个独立弹窗Module，这里的弹窗包括普通的Dialog方式弹框和WindowManager方式弹窗。提供一种管理项目里面弹窗的方案，便于后期修改和维护。首先描述一个在大项目中普遍存在的一个现象：

&nbsp;&nbsp;&nbsp;&nbsp;由于项目的功能多，负责功能的人不同，当功能中需要一个普通的确定取消对话框时，大部分人都选择自己写了一个，自己new一个独立的弹窗出来。这样做的好处有以下几个：
  
  1. 代码逻辑独立，自己写的代码自己能控制
  2. 快速方便，便于修改，便于满足各种奇怪的需求
  
&nbsp;&nbsp;&nbsp;&nbsp;可是这个做法导致项目中存在大量的代码冗余，大量的分散的弹窗，短期内一般也不会有什么问题，如果这个时候项目要重构，要修改所有弹窗的样式，接下来面临几个问题：

  1. 不知道有多少个弹窗
  2. 不知道代码中什么地方会有弹窗
  3. 不知道弹窗写法都有哪些（样式不知道，弹出的方式是Dialog还是WindowManager）
  4. 改动点多，工作量大，风险大
  
&nbsp;&nbsp;&nbsp;&nbsp;项目重构就要把所有弹窗重新管理起来，方便维护和拓展，具体设计与实现细节见博客，下面是弹窗的样式：

## 动画演示

![动画演示](/docpic/example.GIF "app操作演示")

## 弹窗样式截图

### 首页

![homepage1](/docpic/homepage1.png "首页1") ![homepage2](/docpic/homepage2.png "首页2")

### 对话框弹窗类型

![type1](/docpic/type1.png "type1") ![type2](/docpic/type2.png "type2") 

![type3](/docpic/type3.png "type3") ![type4](/docpic/type4.png "type4")

![type101](/docpic/type101.png "type101") ![type103](/docpic/type103.png "type103")

![type106](/docpic/type106.png "type106")

![type102](/docpic/type102.png "type102")  ![type104](/docpic/type104.png "type104")

![type105](/docpic/type105.png "type105") 

![type201](/docpic/type201.png "type201") 

![type202](/docpic/type202.png "type202") ![type203](/docpic/type203.png "type203")  

### WindowManager弹窗类型

![windowtype1](/docpic/windowtype1.png "windowtype1")  

![windowtype2](/docpic/windowtype2.png "windowtype2") 

## 使用说明

&nbsp;&nbsp;&nbsp;&nbsp;在自己的项目中导入CommonAlertPop Module，参考本案例中的使用方法即可。 本项目只是提供一种基本的框架，具体的对话框样式可以根据自身项目的需求而改变，可以随意添加删除修改一种类型，主要是为了统一管理项目中的弹窗，方便维护与管理。