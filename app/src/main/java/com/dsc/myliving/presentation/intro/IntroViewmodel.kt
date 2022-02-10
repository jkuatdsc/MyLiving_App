package com.dsc.myliving.presentation.intro

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dsc.myliving.R.drawable.*

class IntroViewmodel : ViewModel() {

    val images = listOf(feedback, rating, electricity, water)
    val texts = listOf(
        "Contribute data and feedback about your location to our data pool",
        "See what other people living near you think about the area",
        "Check the power outage history and get future predictions",
        "Check the water shortage history and get future predictions"
    )

    private var _current = mutableStateOf(0)
    val current: State<Int> = _current

    fun skip() = _current.also { _current.value = 3 }
    fun next() = _current.also { _current.value = if (_current.value == 3) 3 else it.value + 1 }
    fun prev() = _current.also { _current.value = if (_current.value == 0) 0 else it.value - 1 }

}