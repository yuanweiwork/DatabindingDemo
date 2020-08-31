## Databinding 基本用法

* #### databinding是什么

引用官方文档的一句话 

> The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically
>
> ###### Data Binding是一个支持库，使用该库，您可以使用声明性格式而非编程方式将布局中的UI组件绑定到应用程序中的数据源

大白话：可以在布局中 写逻辑 /绑定数据源

* #### databinding 基础用法

  1.怎么导入

  在想要用的model 的build.gradle 中加入以下代码  

  ```
  android {
      ...
      buildFeatures {
          dataBinding true
      } 
  }
  ```

  

  不需要其他代码了[点击这里 有官方文档  和 demo](https://developer.android.google.cn/jetpack/androidx/releases/databinding?hl=en)

  > The databinding library is bundled with [the Android Gradle plugin](https://developer.android.google.cn/studio/releases/gradle-plugin). You do not need to declare a dependency on the library
  >
  > 绑定库与Android Gradle插件绑定。您不需要声明该库的依赖项

  2.基本知识

   + 先按照 上面 开启 databinding 

   + 更改你的 layout 文件 

     更改之前 

     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
         android:layout_width="match_parent"
         android:layout_height="match_parent">
     
     </androidx.constraintlayout.widget.ConstraintLayout>
     ```

     更改之后 

     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <layout xmlns:android="http://schemas.android.com/apk/res/android"
         android:layout_width="match_parent"
         android:layout_height="match_parent">
        
         <data> 
         </data>
       
         <androidx.constraintlayout.widget.ConstraintLayout
             android:layout_width="match_parent"
             android:layout_height="match_parent">
         </androidx.constraintlayout.widget.ConstraintLayout>
     </layout>
     ```

     添加了<layout> 和 <data> 两个标签   <data>标签中 可以声明想要引入的工具类或者实体类 

     

     例如：

      	

  

  3.

  4.BindingAdapter用法

  

* 资料

  [databinding官方文档](https://developer.android.google.cn/topic/libraries/data-binding?hl=en#java)

  

