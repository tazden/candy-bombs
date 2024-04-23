package net.sweetdestr.ck.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import net.sweetdestr.ck.util.Nav
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor(): ViewModel(){
    private val _stateNav = MutableStateFlow<Nav?>(Nav.START)
    val stateNav: StateFlow<Nav?> = _stateNav

    fun loadState(nav: Nav) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateNav.emit(nav)
        }
    }
}