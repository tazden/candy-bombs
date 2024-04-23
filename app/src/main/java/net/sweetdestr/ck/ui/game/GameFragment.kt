package net.sweetdestr.ck.ui.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import net.sweetdestr.ck.ui.NavViewModel
import net.sweetdestr.ck.util.Constants
import net.sweetdestr.ck.util.Nav
import kotlinx.coroutines.launch
import net.sweetdestr.ck.databinding.FragmentGameBinding
import java.lang.Integer.max
import java.lang.Integer.min
import kotlin.random.Random

class GameFragment : Fragment() {


    private lateinit var binding: FragmentGameBinding
    private val gameViewModel: GameViewModel by activityViewModels()
    private val navViewModel: NavViewModel by activityViewModels()
    private var coordinate = Constants.MINUS_ONE to Constants.MINUS_ONE
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        for (i in Constants.ONE..Constants.SEVEN)
            for (j in Constants.ZERO..Constants.THREE) {
                generateItem(i, j, ::randomItem)
            }
        gameViewModel.loadState(Constants.ZERO)
        lifecycleScope.launch {
            gameViewModel.stateScore.collect {
                binding.tvGameScore.text = it.toString()
            }
        }
        binding.ivItem00.setOnClickListener {
            checkClick(Constants.ONE, Constants.ZERO)
        }
        binding.ivItem01.setOnClickListener {
            checkClick(Constants.ONE, Constants.ONE)
        }
        binding.ivItem02.setOnClickListener {
            checkClick(Constants.ONE, Constants.TWO)
        }
        binding.ivItem03.setOnClickListener {
            checkClick(Constants.ONE, Constants.THREE)
        }
        binding.ivItem10.setOnClickListener {
            checkClick(Constants.TWO, Constants.ZERO)
        }
        binding.ivItem11.setOnClickListener {
            checkClick(Constants.TWO, Constants.ONE)
        }
        binding.ivItem12.setOnClickListener {
            checkClick(Constants.TWO, Constants.TWO)
        }
        binding.ivItem13.setOnClickListener {
            checkClick(Constants.TWO, Constants.THREE)
        }
        binding.ivItem20.setOnClickListener {
            checkClick(Constants.THREE, Constants.ZERO)
        }
        binding.ivItem21.setOnClickListener {
            checkClick(Constants.THREE, Constants.ONE)
        }
        binding.ivItem22.setOnClickListener {
            checkClick(Constants.THREE, Constants.TWO)
        }
        binding.ivItem23.setOnClickListener {
            checkClick(Constants.THREE, Constants.THREE)
        }
        binding.ivItem30.setOnClickListener {
            checkClick(Constants.FOUR, Constants.ZERO)
        }
        binding.ivItem31.setOnClickListener {
            checkClick(Constants.FOUR, Constants.ONE)
        }
        binding.ivItem32.setOnClickListener {
            checkClick(Constants.FOUR, Constants.TWO)
        }
        binding.ivItem33.setOnClickListener {
            checkClick(Constants.FOUR, Constants.THREE)
        }
        binding.ivItem40.setOnClickListener {
            checkClick(Constants.FIVE, Constants.ZERO)
        }
        binding.ivItem41.setOnClickListener {
            checkClick(Constants.FIVE, Constants.ONE)
        }
        binding.ivItem42.setOnClickListener {
            checkClick(Constants.FIVE, Constants.TWO)
        }
        binding.ivItem43.setOnClickListener {
            checkClick(Constants.FIVE, Constants.THREE)
        }
        binding.ivItem50.setOnClickListener {
            checkClick(Constants.SIX, Constants.ZERO)
        }
        binding.ivItem51.setOnClickListener {
            checkClick(Constants.SIX, Constants.ONE)
        }
        binding.ivItem52.setOnClickListener {
            checkClick(Constants.SIX, Constants.TWO)
        }
        binding.ivItem53.setOnClickListener {
            checkClick(Constants.SIX, Constants.THREE)
        }
        binding.ivItem60.setOnClickListener {
            checkClick(Constants.SEVEN, Constants.ZERO)
        }
        binding.ivItem61.setOnClickListener {
            checkClick(Constants.SEVEN, Constants.ONE)
        }
        binding.ivItem62.setOnClickListener {
            checkClick(Constants.SEVEN, Constants.TWO)
        }
        binding.ivItem63.setOnClickListener {
            checkClick(Constants.SEVEN, Constants.THREE)
        }

        return binding.root
    }

    private fun generateItem(i: Int, j: Int, func: (Int, Int) -> Int) {
        when (i) {
            Constants.ONE -> when (j) {
               Constants.ZERO -> binding.ivItem00.setImageResource(func(i, j))
                Constants.ONE -> binding.ivItem01.setImageResource(func(i, j))
                Constants.TWO -> binding.ivItem02.setImageResource(func(i, j))
                Constants.THREE -> binding.ivItem03.setImageResource(func(i, j))
            }
            Constants.TWO -> when (j) {
               Constants.ZERO -> binding.ivItem10.setImageResource(func(i, j))
                Constants.ONE -> binding.ivItem11.setImageResource(func(i, j))
                Constants.TWO -> binding.ivItem12.setImageResource(func(i, j))
                Constants.THREE -> binding.ivItem13.setImageResource(func(i, j))
            }
            Constants.THREE -> when (j) {
               Constants.ZERO -> binding.ivItem20.setImageResource(func(i, j))
                Constants.ONE -> binding.ivItem21.setImageResource(func(i, j))
                Constants.TWO -> binding.ivItem22.setImageResource(func(i, j))
                Constants.THREE -> binding.ivItem23.setImageResource(func(i, j))
            }
            Constants.FOUR -> when (j) {
               Constants.ZERO -> binding.ivItem30.setImageResource(func(i, j))
                Constants.ONE -> binding.ivItem31.setImageResource(func(i, j))
                Constants.TWO -> binding.ivItem32.setImageResource(func(i, j))
                Constants.THREE -> binding.ivItem33.setImageResource(func(i, j))
            }
            Constants.FIVE -> when (j) {
               Constants.ZERO -> binding.ivItem40.setImageResource(func(i, j))
                Constants.ONE -> binding.ivItem41.setImageResource(func(i, j))
                Constants.TWO -> binding.ivItem42.setImageResource(func(i, j))
                Constants.THREE -> binding.ivItem43.setImageResource(func(i, j))
            }
            Constants.SIX -> when (j) {
               Constants.ZERO -> binding.ivItem50.setImageResource(func(i, j))
                Constants.ONE -> binding.ivItem51.setImageResource(func(i, j))
                Constants.TWO -> binding.ivItem52.setImageResource(func(i, j))
                Constants.THREE -> binding.ivItem53.setImageResource(func(i, j))
            }
            Constants.SEVEN -> when (j) {
               Constants.ZERO -> binding.ivItem60.setImageResource(func(i, j))
                Constants.ONE -> binding.ivItem61.setImageResource(func(i, j))
                Constants.TWO -> binding.ivItem62.setImageResource(func(i, j))
                Constants.THREE -> binding.ivItem63.setImageResource(func(i, j))
            }
        }
    }

    private fun randomItem(i: Int, j: Int): Int {
        val random = Random.nextInt(Constants.TEN)
        Constants.listOfItems[i][j] = random
        return Constants.mapOfItems[random]
    }

    private fun checkClick(i: Int, j: Int) {
        Log.d("vfv", Constants.listOfItems[i][j].toString())
        if (Constants.listOfItems[i][j] == 1) {
            navViewModel.loadState(Nav.GAME_OVER)
        }

        else if (coordinate != Constants.MINUS_ONE to Constants.MINUS_ONE && coordinate != i to j) {
            if (Constants.listOfItems[i][j] == Constants.listOfItems[coordinate.first][coordinate.second]) {

                if (j == coordinate.second) {
                    letDownItems(max(i, coordinate.first), j)
                    letDownItems(min(i, coordinate.first) + Constants.ONE, j)
                }
                else {
                    letDownItems(i, j)
                    letDownItems(coordinate.first, coordinate.second)
                }

            }
            coordinate = Constants.MINUS_ONE to Constants.MINUS_ONE
        } else {
            coordinate = i to j
        }
        checkGameOver()
    }

    private fun letDownItems(line: Int, column: Int) {
        for (i in line - Constants.ONE downTo Constants.ZERO) {
            Constants.listOfItems[i + Constants.ONE][column] = Constants.listOfItems[i][column]
            generateItem(i + Constants.ONE, column, ::setItem)
        }
        gameViewModel.loadState(gameViewModel.stateScore.value + Constants.ONE)

    }

    private fun checkGameOver() {
        var list = mutableListOf(
            Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO, Constants.ZERO,
            Constants.ZERO)
        var maxValue = Constants.ZERO

        for (i in Constants.ONE..Constants.SEVEN)
            for (j in Constants.ZERO..Constants.THREE) {
                list[Constants.listOfItems[i][j]] += Constants.ONE
                if (Constants.listOfItems[i][j] != Constants.TEN &&  (Constants.listOfItems[i][j] != 1))
                    maxValue = Integer.max(maxValue, list[Constants.listOfItems[i][j]])
            }
        if (maxValue < Constants.TWO)
            navViewModel.loadState(Nav.GAME_OVER)
    }

    private fun setItem(i: Int, j: Int): Int {
        return Constants.mapOfItems[Constants.listOfItems[i][j]]
    }
}