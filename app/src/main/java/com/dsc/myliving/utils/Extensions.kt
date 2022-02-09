package com.dsc.myliving.utils

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset


fun Modifier.unRippled(click: () -> Unit): Modifier = composed {
    val interactionSource = remember { MutableInteractionSource() }
    this.clickable(indication = null, interactionSource = interactionSource) {
        click()
    }
}

fun Modifier.onSwipe(left: () -> Unit = {}, right: () -> Unit = {}): Modifier = composed {
    var offsetX by remember { mutableStateOf(0f) }
    val animate by animateIntOffsetAsState(targetValue = IntOffset(offsetX.toInt(), 0))
    this.offset { animate }.pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {
                when {
                    offsetX < 0 -> left()
                    offsetX > 0 -> right()
                }
                offsetX = 0f
            },
            onDrag = { change, dragAmount ->
                change.consumeAllChanges()
                offsetX += dragAmount.x
            },
        )
    }
}