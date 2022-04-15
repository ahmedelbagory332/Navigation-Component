package com.play.eg.navigationcomponent.NavigationDrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.play.eg.navigationcomponent.R


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)

         val tv:TextView  = view.findViewById(R.id.txtViewFrag1)
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(20)
        tv.setOnClickListener { Navigation.findNavController(view).navigate(action) }

        return view
    }

}