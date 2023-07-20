package com.example.candybasket.ui.game_over

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.candybasket.R

class GameOverFragment : Fragment() {

    companion object {
        fun newInstance() = GameOverFragment()
    }

    private lateinit var viewModel: GameOverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_over, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameOverViewModel::class.java)
        // TODO: Use the ViewModel
    }

}