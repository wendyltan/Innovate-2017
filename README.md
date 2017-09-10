# Innovate-2017
> 一个学校安卓开放性试验，只有两个按钮具有功能，一个是speaker，一个是map。使用了百度地图的api
> 用时五天完成


----------
## 1.下载安装

 1. **git clone**
 2. **Android Stdio - import project**


----------


## 2.开发环境

 - Android Stdio 2.3
 - jdk 1.8
 - 测试实机：HUAWEI nova


----------


## 3.功能介绍


### 3.1 主界面
>在**home**界面，点击Speaker按钮可以进入SpeakerList，查看Speakers的详细情况；
>点击map按钮可以进入百度map，查看事先标注好的几个地点的信息；
>点击左下角home键可以随时退回主界面；
>点击右下角info则是打开一个webview。

### 3.2演讲者列表
>在这个界面展示了演讲者的信息，以RecyclerView的方式。点击小箭头可以跳转到详情页面。

### 3.3演讲者详情页
>展示了演讲者的详细信息，按后退键或者返回箭头可以退出这个界面

### 3.4地图界面
>点击标注好的地点可以看到Toast提示的地点名称和地址。

*注意*：请务必先申请自己的百度map的ak。然后重新签名（不知道我的是否会失效）
[Click here][1]


----------

## 4.关于维护和功能添加
*不定时或不再维护的练习项目*


  [1]: http://lbsyun.baidu.com/index.php?title=androidsdk