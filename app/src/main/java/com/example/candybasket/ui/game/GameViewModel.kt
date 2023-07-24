package com.example.candybasket.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.candybasket.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(): ViewModel() {
    private val _stateScore = MutableStateFlow<Int>(Constants.ZERO)
    val stateScore: StateFlow<Int> = _stateScore

    fun loadState(score: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateScore.emit(score)
        }
    }
    private val _stateRecordScore = MutableStateFlow<Int>(Constants.ZERO)
    val stateRecordScore: StateFlow<Int> = _stateRecordScore

    fun loadRecordState(recordScore: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateRecordScore.emit(recordScore)
        }
    }
}