package net.sweetdestr.ck.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import net.sweetdestr.ck.ui.NavViewModel
import net.sweetdestr.ck.ui.game.GameViewModel
import net.sweetdestr.ck.util.Nav
import kotlinx.coroutines.launch
import net.sweetdestr.ck.databinding.FragmentStartBinding

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