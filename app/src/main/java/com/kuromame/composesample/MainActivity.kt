package com.kuromame.composesample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuromame.composesample.ui.theme.ComposeSampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    Column {
                        Greeting("Android")
                        Divider(color = Color.Black)
                        Greeting("there")
                        Counter()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Text(text = "Hello $name!", modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
        .scrollable(
            rememberScrollState(),
            orientation = Orientation.Horizontal
        )
        .background(backgroundColor)
        .clickable(onClick = { isSelected = !isSelected }))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeSampleTheme {
        Greeting("Android")
    }
}
@Composable
fun Counter() {

    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text("I've been clicked ${count.value} times")
    }
}