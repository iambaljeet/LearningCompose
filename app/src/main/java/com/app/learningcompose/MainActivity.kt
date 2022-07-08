package com.app.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.app.learningcompose.ui.theme.LearningComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StateExample()
                }
            }
        }
    }
}

@Composable
fun StateExample() {
    var count by remember {
        mutableStateOf(0)
    }
    var count2 by remember {
        mutableStateOf(2)
    }
    var count3 by remember {
        mutableStateOf(4)
    }
    var count4 by remember {
        mutableStateOf(6)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Component1 {
            count += 1
            count2 += 2
            count3 += 4
            count4 += 6
        }
        Component2(count)
        Component2(count2)
        Component2(count3)
        Component2(count4)
    }
}

@Composable
fun Component1(onButtonClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "This is a Header")
        Button(onClick = onButtonClick) {
            Text(text = "Click Me")
        }
    }
}

@Composable
fun Component2(count: Int) {
    Text(text = "Value Of Count: $count")
}