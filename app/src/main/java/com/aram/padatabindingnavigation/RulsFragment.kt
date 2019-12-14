package com.aram.padatabindingnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.aram.padatabindingnavigation.databinding.FragmentRulsBinding

/**
 * A simple [Fragment] subclass.
 */
class RulsFragment : Fragment() {

    lateinit var binding: FragmentRulsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_ruls,container,false)
        return binding.root
    }


}
