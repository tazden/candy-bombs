package net.sweetdestr.ck.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope

import net.sweetdestr.ck.ui.game.GameFragment
import net.sweetdestr.ck.ui.game_over.GameOverFragment
import net.sweetdestr.ck.ui.start.StartFragment
import net.sweetdestr.ck.util.Nav
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.sweetdestr.ck.R
import net.sweetdestr.ck.databinding.ActivityMainBinding

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