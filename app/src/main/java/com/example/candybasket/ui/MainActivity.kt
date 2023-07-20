package com.example.candybasket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.candybasket.R
import com.example.candybasket.databinding.ActivityMainBinding
import com.example.candybasket.ui.game.GameFragment
import com.example.candybasket.ui.game_over.GameOverFragment
import com.example.candybasket.ui.start.StartFragment
import com.example.candybasket.util.Nav
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navViewModel: NavViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        lifecycleScope.launch {
            navViewModel.stateNav.collect {
                when(it) {
                    Nav.START -> replaceFragment(StartFragment())
                    Nav.GAME -> replaceFragment(GameFragment())
                    Nav.GAME_OVER -> replaceFragment(GameOverFragment())
                    else -> {}
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}