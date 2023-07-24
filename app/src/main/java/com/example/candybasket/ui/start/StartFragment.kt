package com.example.candybasket.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.candybasket.databinding.FragmentStartBinding
import com.example.candybasket.ui.NavViewModel
import com.example.candybasket.ui.game.GameViewModel
import com.example.candybasket.util.Nav
import kotlinx.coroutines.launch

class StartFragment : Fragment() {

    private val navViewModel: NavViewModel by activityViewModels()
    private val gameViewModel: GameViewModel by activityViewModels()
    private lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.btnStart.setOnClickListener {
            navViewModel.loadState(Nav.GAME)
        }
        lifecycleScope.launch {
            gameViewModel.stateRecordScore.collect {
                binding.tvStartRecord.text = it.toString()
            }
        }
        return binding.root
    }

}