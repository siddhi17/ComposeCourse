package com.example.composecourse

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddingListStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MainScreen()
            AddEditText()
        }
    }
}

@Composable
fun MainScreen() {
    val greetingListState = remember { mutableStateListOf<String>("John", "Amanda") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(greetingListState) {
            greetingListState.add("Michael")
        }
    }
}

@Composable
fun GreetingList(namesList: List<String>, buttonClick: () -> Unit) {

    for(name in namesList) {
        Greeting(name = name)
    }

    Button(onClick = buttonClick) {
        Text("Add new name")
    }
}


@Composable
fun AddEditText() {
    val greetingListState = remember {
        mutableStateListOf<String>("John", "Amanda")
    }
    val newNameStateContent = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(greetingListState,
            { greetingListState.add(newNameStateContent.value) },
            newNameStateContent.value,
            { newName -> newNameStateContent.value = newName })
    }
}

@Composable
fun GreetingList(namesList: List<String>,
                 buttonClick: () -> Unit,
                 textFieldValue: String,
                 textFieldUpdate: (newName: String) -> Unit
) {
    for (name in namesList) {
        Greeting(name = name)
    }

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)

    Button(onClick = buttonClick) {
        Text("Add new name")
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
   // MainScreen()

    AddEditText()
}