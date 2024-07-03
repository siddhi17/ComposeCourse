package com.example.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecourse.ui.theme.ComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*      ComposeCourseTheme {
                GreetingText("Siddhi")
                }
            }*/

           // MainScreen()

           // RowColumnTest()

          //  ReUseComposable()

           // ColumnComposable()

            RowColumnNesting()

        }
    }

    @Composable
    fun GreetingText(name: String) {
        Text(
            text = " Hello $name!",
            modifier = Modifier
                .clickable(onClick = { })
                .padding(all = 24.dp)
                .width(200.dp)
                .height(240.dp),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.SemiBold
        )
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Composable
    fun GreetingButton() {
        Button(onClick = { }) {
            GreetingText(name = "button")
            GreetingText(name = "remaining button")
        }
    }

    @Composable
    fun MainScreen() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                color = Color.Magenta,
                modifier = Modifier.wrapContentSize(
                    align = Alignment.BottomStart
                )
            ) {
                Text(
                    text = "Wrapped content",
                    style = MaterialTheme.typography.headlineMedium
                )
            }

        }
    }

    @Composable
    fun RowColumnTest() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxSize()
        ) {
            Row {
                Surface(
                    color = Color.Magenta,
                    modifier = Modifier
                        .height(600.dp)
                        .width(60.dp)
                ) { }
                Surface(
                    color = Color.Red,
                    modifier = Modifier
                        .height(600.dp)
                        .width(60.dp)
                ) { }
            }
        }
    }

    @Composable
    fun ReUseComposable() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxSize()

        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalColoredBar(Color.Red)
                HorizontalColoredBar(Color.Magenta)
                HorizontalColoredBar(Color.Cyan)
                HorizontalColoredBar(Color.Yellow)
                HorizontalColoredBar(Color.Blue)
            }
        }
    }

    @Composable
    fun HorizontalColoredBar(color: Color) {
        Surface(
            color = color,
            modifier = Modifier
                .height(600.dp)
                .width(60.dp)
        ) { }
    }


    @Composable
    fun ColumnComposable() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalColoredBar(Color.Red)
                HorizontalColoredBar(Color.Magenta)
                HorizontalColoredBar(Color.Cyan)
                HorizontalColoredBar(Color.Yellow)
                HorizontalColoredBar(Color.Blue)
            }
        }
    }

    @Composable
    fun RowColumnNesting() {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    ColoredSquare(Color.Red)
                    ColoredSquare(Color.Magenta)
                }
                ColoredSquare(Color.Cyan)
                ColoredSquare(Color.Yellow)
                ColoredSquare(Color.Blue)
            }
        }
    }

    @Composable
    fun ColoredSquare(color: Color) {
        Surface(
            color = color,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        ) { }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        /*   ComposeCourseTheme {
        Greeting("siddhi")
        GreetingButton()
    }*/
        //MainScreen()
       // RowColumnTest()
       // ReUseComposable()
       // ColumnComposable()

        RowColumnNesting()
    }
}