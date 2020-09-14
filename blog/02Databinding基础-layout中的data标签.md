## Layout 中的标签

## 1.实体类 

xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable
            name="bean"
            type="com.yww.demo02.User" />
    </data>
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:id="@+id/demo_01_text"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="@{bean.name}"
            android:textColor="#000000"
            android:textSize="28sp"
            tools:text="测试文字" />
    </FrameLayout>
</layout>
```

kotlin

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityDemo01Binding>(
        this@Demo01Activity,
        R.layout.activity_demo_01
    )
    binding.apply {
        val user = User("测试绑定实体类")
        binding.bean = user
    }
}
```

## 2.onclickListener

接口

```kotlin
interface MyClickListener {
    fun click(name: String)
}
```

viewmodel

这里借助了livedata 

```kotlin
class ViewModel {
    var name: MutableLiveData<String> = MutableLiveData<String>()
}
```

xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable
            name="click"
            type="com.yww.demo02.MyClickListener" />
        <variable
            name="viewModel"
            type="com.yww.demo02.ViewModel" />
    </data>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <EditText
            android:id="@+id/name_et"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:text="@={viewModel.name}" />
        <Button
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:onClick="@{()->click.click(viewModel.name)}"
            android:text="点击监听" />
    </LinearLayout>
</layout>
```

kotlin

```kotlin
class Demo02Activity : AppCompatActivity(), MyClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDemo02Binding>(
            this@Demo02Activity,
            R.layout.activity_demo_02
        )
        binding.apply {
            click = this@Demo02Activity
            viewModel = ViewModel()
        }
    }
    override fun click(name: String) {
        Toast.makeText(applicationContext, "输入框输入:$name", Toast.LENGTH_LONG).show()
    }
}
```

## 3.工具类使用

xml

需要使用import 引入工具类  可以使用其中的静态方法

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <import type="com.yww.demo02.Utils" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:text="@{Utils.add(1,1)}" />
    </LinearLayout>
</layout>
```

## 4.特殊语法 及逻辑判断

### 	三元运算

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
        <import type="com.yww.demo02.R" />
        <variable
            name="user"
            type="com.yww.demo02.User" />
    </data>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="@{user==null?R.string.app_name : R.string.app_name2}"
            android:textColor="@color/colorAccent"
            android:textSize="40dp"
            tools:text="测试" />
    </LinearLayout>
</layout>
```



### 实例代码：[github demo02](https://github.com/yuanweiwork/DatabindingDemo/tree/master)

### 最后 如果有更多用法 可以 在github中找到我的邮箱 发邮件给我 或者评论  

[01Databinding基础-Databinding是什么附带helloword小Demo](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/01Databinding基础-Databinding是什么附带helloword小Demo.md)
[02Databinding基础-layout中的data标签](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/02Databinding基础-layout中的data标签.md)
[03Databinding基础-activity:fragment:adapter绑定](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/03Databinding基础-activity:fragment:adapter绑定.md)
[04Databinding基础-各种注释](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/04Databinding基础-各种注释.md)

