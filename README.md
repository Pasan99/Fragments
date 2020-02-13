# Fragments
A Fragment is a self-contained component with its own user interface (UI) and lifecycle that can be reused in different parts of an app's UI.Fragment reperesent a behaviour or a portion of user interface in a FragmentActivity. Combine multiple fragments in a single activity to build multi pane ui and reuse fragments is multiple activities. Fragments has its own lifecycle. Fragments must always be hosted in an activity and it's lifecyle is directly affected by the activity's lifecycle. 

There is two ways of adding fragment to an activity
 1. Adding Fragments Dynamically
 2. Adding Fragments statically (Remain on the screen during the entire lifecyle of an activity)

Ex : `DatePicker` object (Dynamic Fragment), which is an isnstance of `DialogFagment`, a subclass of `Fragment`

 Fragment can retain an instance of its data after a configuration change (such as changing the orientation). This feature makes a Fragment useful as a UI component, as compared to using separate Views. While an Activity is destroyed and recreated when a device's configuration changes, a Fragment is not destroyed.

<h4>Adding Fragments statically</h4>
First, you need to create a fragment. (Use android studio's pre build templates). Give a name to the fragment (Ex:MessageFragment). Add the following XML code to the activity's layout file where you want to add the fragment.

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

<h4>Adding Fragments Dynamically</h4>
We need to use FragmentTransaction to add, remove or replace Fragment from an activity.

The best practice for instantiating the Fragment in the Activity is to provide a `newinstance()` factory method in the Fragment. Follow these steps to add the `newinstance()` method to Fragment and instantiate the Fragment in Activity. You will also add the `displayFragment()` and `closeFragment()` methods, and use Fragment transactions

 1. Open Fragment, and add the following method for instantiating and returning the Fragment to the Activity:
 ```kotlin
 companion object{
        fun newInstance() : RateFragment{
            return RateFragment()
        }
    }
```
 2. Open Activity, and create the following `displayRatingFragment()` method to instantiate and open `RateFragment`. It starts by creating an instance of `RateFragment` by calling the `newInstance()` method in `RateFragment`:
```kotlin
private fun displayRatingFragment(){
        val rateFragment = RateFragment.newInstance()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, rateFragment)
            .addToBackStack(null)
            .commit()
        isRatingFragmentDisplayed = true
        
        // Set the listener created in Fragment
        rateFragment.setOnCloseListener(object : RateFragment.OnCloseListener{
            @SuppressLint("SetTextI18n")
            override fun onRated(rating: Float) {
                rate_result.visibility = View.VISIBLE
                rate_result.text = "$rating ★"
            }

            override fun onClose(button: Button) {
                closeRatingFragment()
            }

        })
 }
 private fun closeRatingFragment(){
        val rateFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (rateFragment != null){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.remove(rateFragment).commit()
            isRatingFragmentDisplayed = false
        }
 }
 ```
Using `supportFragmentManager`, use `beginTransaction()` to get an instance of `FragmentTransaction`. `FragmentTransaction` can be used to add a new fragment. I add `OnCloseListener` (Interface was created in `RateFragment`) to identify the user interactions on `RateFragment`.

<h5>RateFragment</h5>

```kotlin
class RateFragment : Fragment() {

    private lateinit var closeListener : OnCloseListener

    companion object{
        fun newInstance() : RateFragment{
            return RateFragment()
        }
    }

    fun setOnCloseListener(listener: OnCloseListener){
        this.closeListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rate, container, false)
        val closeBtn = view.findViewById<Button>(R.id.close_btn)
        val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        closeBtn.setOnClickListener {
            closeListener.onClose(it as Button)
        }
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            closeListener.onRated(rating)
        }
        return view
    }

    interface OnCloseListener{
        fun onClose(button: Button)
        fun onRated(rating: Float)
    }

}
```
<img src="https://github.com/Pasan99/Fragments/blob/master/FragmentScreenshots/BeforeRate.png" width="250"/>   <img src="https://github.com/Pasan99/Fragments/blob/master/FragmentScreenshots/OnRating.png" width="250"/>   <img src="https://github.com/Pasan99/Fragments/blob/master/FragmentScreenshots/AfterRated.png" width="250"/>   
 
