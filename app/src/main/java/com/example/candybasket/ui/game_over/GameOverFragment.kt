package com.example.candybasket.ui.game_over

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.candybasket.databinding.FragmentGameOverBinding
import com.example.candybasket.ui.NavViewModel
import com.example.candybasket.ui.game.GameViewModel
import com.example.candybasket.util.Nav
import kotlinx.coroutines.launch
import java.lang.Integer.max

class GameOverFragment : Fragment() {

    private val navViewModel: NavViewModel by activityViewModels()
    private val gameViewModel: GameViewModel by activityViewModels()
    private lateinit var binding: FragmentGameOverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameOverBinding.inflate(inflater, container, false)
        binding.btnReplay.setOnClickListener {
            navViewModel.loadState(Nav.START)
        }

        //if (gameViewModel.stateRecordScore.value < gameViewModel.stateScore.value)
        gameViewModel.loadRecordState(max(gameViewModel.stateScore.value, gameViewModel.stateRecordScore.value))
        lifecycleScope.launch {
            gameViewModel.stateRecordScore.collect {

                binding.tvRecordScore.text = it.toString()
            }
        }
        lifecycleScope.launch {
            gameViewModel.stateScore.collect {
                binding.tvGameOverScore.text = it.toString()
            }
        }
        return binding.root
    }
}