## 04BindingAdapter注释用法 

```kotlin
@BindingAdapter("setTitle")
fun setText(view: TextView, name: String) {
    view.text = name
}
```

在java中要是静态方法  kotlin中可以直接新建个文件写  或者kotlin中静态方式写

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <data>
        <variable
            name="activity"
            type="com.yww.demo04.MainActivity" />
    </data>
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:textColor="#000000"
            android:textSize="40sp"
            app:setTitle="@{activity.name}" />
    </FrameLayout>
</layout>
```

1.在项目build.gradle 引入 apply plugin: "kotlin-kapt" 开启databindding

2.在xml中 必须有<layout>标签 否则 @BindingAdapter 标记的方法无法使用

3.使用@BindingAdapter 时 必须使用 @{} 方式（这个是从某篇博客看的具体链接没有存）

##### 官方推荐文章

两篇官方推荐的文章  可以看看（需要科学上网）

- [Android Data Binding Library — From Observable Fields to LiveData in two steps](https://medium.com/androiddevelopers/android-data-binding-library-from-observable-fields-to-livedata-in-two-steps-690a384218f2)

- [Data Binding — Lessons Learnt](https://medium.com/androiddevelopers/data-binding-lessons-learnt-4fd16576b719)

