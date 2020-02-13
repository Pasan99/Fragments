# Fragments
A Fragment is a self-contained component with its own user interface (UI) and lifecycle that can be reused in different parts of an app's UI.Fragment reperesent a behaviour or a portion of user interface in a FragmentActivity. Combine multiple fragments in a single activity to build multi pane ui and reuse fragments is multiple activities. Fragments has its own lifecycle. Fragments must always be hosted in an activity and it's lifecyle is directly affected by the activity's lifecycle. 

There is two ways of adding fragment to an activity
 1. Adding Fragments Dynamically
 2. Adding Fragments statically (Remain on the screen during the entire lifecyle of an activity)

Ex : DatePicker object (Dynamic Fragment), which is an isnstance of DialogFagment, a subclass of Fragment

 Fragment can retain an instance of its data after a configuration change (such as changing the orientation). This feature makes a Fragment useful as a UI component, as compared to using separate Views. While an Activity is destroyed and recreated when a device's configuration changes, a Fragment is not destroyed.

<h4>Statically Add fragments from layout XML file</h4>

```XML
<fragment
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:name="com.example.fragments.MessageFragment"
        tools:layout="@layout/fragment_message"
        android:layout_margin="2dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
<img src="https://github.com/Pasan99/Fragments/blob/master/FragmentScreenshots/ArticalBeforeLike.png" width="300">     <img src="https://github.com/Pasan99/Fragments/blob/master/FragmentScreenshots/ArticleAfterLike.png" width="300">
