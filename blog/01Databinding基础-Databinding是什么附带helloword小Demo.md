## databinding是什么

引用官方文档的一句话 

> The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically
>
> ###### Data Binding是一个支持库，使用该库，您可以使用声明性格式而非编程方式将布局中的UI组件绑定到应用程序中的数据源

大白话：可以在布局中 写逻辑 /绑定数据源

## Databinding helloword

#### 0.开启databinding

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

#### 1.最简单的例子  setUser

+ 先写layout 文件  

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    </LinearLayout>
</layout>
```

> 注意 layout文件是不带 layout_width 和 layout_height 的  如果 <layout>和 <LinearLayout> 都加了 宽高  则会报错误
>
> AAPT: error: duplicate attribute
>
> AAPT: error: file failed to compile.
>
> 记得把<layout>标签宽高删了

+ 在activity中引用

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding =
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
}
```

> ​	先写layout布局  对应的xml中 有<layout>标签 databinding 才会生成 辅助文件ActivityMainBinding 

+ 创建User 类 并且 加入

  user类

  ```kotlin
  data class User(var name: String)
  ```

  加入xml中

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools">
      <data>
          <variable
              name="bean"
              type="com.yww.demo01.User" />
      </data>
      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:orientation="vertical">
          <TextView
              android:layout_width="match_parent"
              android:layout_height="50dp"
              android:layout_gravity="center"
              android:gravity="center"
              android:text="@{bean.name}"
              android:textColor="#000000"
              android:textSize="30dp"
              tools:text="测试位置" />
      </LinearLayout>
  </layout>
  ```

  

  在代码中使用

  ```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      val binding =
          DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
      binding.apply {
          val user = User("Hello World")
          binding.bean = user
      }
  }
  ```

#### 2.简单验证

问题：只更改bean中的值  可以达到数据的变更吗？

先说结论 ：不可以

```kotlin
btn2.setOnClickListener {
    user.name = "02修改"
}
```

必须再重新setbean一下 

```kotlin
btn1.setOnClickListener {
    bind.bean = user
}
```





