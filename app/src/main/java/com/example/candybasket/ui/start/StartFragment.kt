package com.example.candybasket.ui.start

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.candybasket.R
import com.example.candybasket.databinding.FragmentStartBinding
import com.example.candybasket.ui.NavViewModel
import com.example.candybasket.util.Nav

class StartFragment : Fragment() {

    private val navViewModel: NavViewModel by activityViewModels()
    private lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.btnStart.setOnClickListener {
            navViewModel.loadState(Nav.GAME)
        }
        return binding.root
    }

}