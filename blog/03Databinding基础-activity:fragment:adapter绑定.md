## 03activity/fragment/adapter绑定

首先xml中根布局要是<layout> 这样才可以生成对应的bindding文件 

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable
            name="bean"
            type="com.yww.demo03.User" />
    </data>
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="80dp">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="@{bean.name}"
            android:textSize="28sp"
            tools:text="测试" />
    </FrameLayout>
</layout>
```

生成规则  

​	xml :activity_main.xml

​	生成 ：ActivityMainBinding

​	实际生成逻辑文件 ActivityMainBindingImpl

ActivityMainBindingImpl文件可以查看相关绑定的源码等 



## activity中使用

```kotlin
DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
```

等同于 

```kotlin
    setContentView( R.layout.activity_main)
```

## fragment中使用

```kotlin
   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentMainBinding>(LayoutInflater.from(activity), R.layout.fragment_main, null, false)
        return binding.root
    }
```

binding.root 可以返回一个view

## adapter中使用

​	最简单的 

```kotlin

class MainAdapter(var list: List<User>) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_main,
                null,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind.bean = list[position]
    }

}

class MainViewHolder(var bind: ItemMainBinding) : RecyclerView.ViewHolder(bind.root) {
}
```





最后  出了绑定的地方 与之前不一样 之后的使用并没有变



[01Databinding基础-Databinding是什么附带helloword小Demo](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/01Databinding基础-Databinding是什么附带helloword小Demo.md)
[02Databinding基础-layout中的data标签](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/02Databinding基础-layout中的data标签.md)
[03Databinding基础-activity:fragment:adapter绑定](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/03Databinding基础-activity:fragment:adapter绑定.md)
[04Databinding基础-各种注释](https://github.com/yuanweiwork/DatabindingDemo/blob/master/blog/04Databinding基础-各种注释.md)

