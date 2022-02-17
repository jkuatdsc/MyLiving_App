package com.dsc.myliving.presentation.features.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dsc.myliving.presentation.features.auth.AuthActivity
import com.dsc.myliving.presentation.theme.MyLivingTheme
import com.dsc.myliving.utils.onSwipe
import com.dsc.myliving.utils.unRippled
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroActivity : ComponentActivity() {
    private val viewmodel: IntroViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyLivingTheme {
                Surface {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = SpaceBetween) {
                        Spacer(modifier = Modifier)
                        Slides()
                        Indicators()
                    }
                }
            }
        }
    }

    @Composable
    fun Slides() {
        val current by viewmodel.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .onSwipe(
                    left = { viewmodel.next() },
                    right = { viewmodel.prev() }
                ),
            horizontalAlignment = CenterHorizontally
        ) {
            Image(
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = viewmodel.images[current]),
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                textAlign = TextAlign.Center,
                text = viewmodel.texts[current],
                modifier = Modifier.width(275.dp),
            )
        }
    }

    @Composable
    fun Indicators() {
        val current by viewmodel.current

        Row(modifier = Modifier.padding(20.dp), verticalAlignment = CenterVertically) {
            Text(
                text = "skip",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .width(50.dp)
                    .unRippled {
                        viewmodel.skip()
                    }
            )

            Box(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier
                        .width(75.dp)
                        .align(Center),
                    horizontalArrangement = SpaceBetween
                ) {
                    (0..3).forEach {
                        val color = if (current == it) colors.onSecondary else colors.primaryVariant
                        val animate by animateColorAsState(targetValue = color)
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(animate)
                        )
                    }
                }
            }

            Text(
                style = MaterialTheme.typography.body1,
                text = if (current != 3) "next" else "start",
                modifier = Modifier
                    .width(50.dp)
                    .unRippled {
                        if (current != 3) viewmodel.next() else start()
                    }
            )
        }
    }

    private fun start() {
        viewmodel.finishIntro()
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}