package com.example.composecourse

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button

val namesList: ArrayList<String> = arrayListOf(
    "John",
    "Michael",
    "Andrew",
    "Danna",
    "Georgia")

class DynamicContentExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
           // GreetingList(names = namesList)
            RecomposeList(names = namesList)
        }
    }
}

    @Composable
    fun GreetingList(names: List<String>) {
        Column {
            for(name in names) {
                Greeting(name = name)
            }
        }
    }

@Composable
fun RecomposeList(names: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (name in names) {
            Greeting(name = name)
        }

        Button(onClick = { namesList.add("New name") }) {
            Text("Add new name")
        }
    }
}

@Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
      //  GreetingList(names = namesList)
        RecomposeList(names = namesList)
    }
