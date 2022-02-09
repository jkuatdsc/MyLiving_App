package com.dsc.myliving.presentation.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import com.dsc.myliving.presentation.theme.MyLivingTheme
import com.dsc.myliving.utils.unRippled

class IntroActivity : ComponentActivity() {
    private val viewmodel: IntroViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyLivingTheme {
                Surface {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = SpaceBetween
                    ) {
                        Spacer(modifier = Modifier)
                        Slide()
                        Indicators()
                    }
                }
            }
        }
    }

    @Composable
    fun Slide() {
        val current by viewmodel.current
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally) {
            Image(
                contentDescription = "",
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = viewmodel.images[current]),
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                textAlign = TextAlign.Center,
                text = viewmodel.texts[current],
                modifier = Modifier.width(250.dp),
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
                modifier = Modifier.width(50.dp).unRippled {
                    viewmodel.skip()
                }
            )

            Box(modifier = Modifier.weight(1f)) {
                Row(modifier = Modifier.width(75.dp).align(Center), horizontalArrangement = SpaceBetween) {
                    (0..3).forEach {
                        val color = if (current == it) colors.onSecondary else colors.primaryVariant
                        Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(color))
                    }
                }
            }

            Text(
                style = MaterialTheme.typography.body1,
                text = if (current != 3) "next" else "start",
                modifier = Modifier.width(50.dp).unRippled {
                    if (current != 3) viewmodel.next() else start()
                }
            )
        }
    }

    private fun start() {
        // TODO: move to login page
    }
}