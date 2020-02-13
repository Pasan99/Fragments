package com.example.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.fragment_message.*

class MessageFragment : Fragment() {
    private val YES = 0
    private val NO = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        val radioGroup = view.findViewById<RadioGroup>(R.id.post_preference_radio_group)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<RadioButton>(checkedId)
            val index = group.indexOfChild(radioButton)
            when(index){
                YES -> post_preference_status.text = resources.getString(R.string.yes_message)
                NO -> post_preference_status.text = resources.getString(R.string.no_message)
            }
            radioGroup.visibility = View.GONE
        }
        return view
    }


}
