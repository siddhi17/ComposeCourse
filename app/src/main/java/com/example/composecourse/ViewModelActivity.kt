package com.example.composecourse

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenLiveData()
        }
    }
}

@Composable
fun MainScreenLiveData(viewModel: MainViewModel = MainViewModel()) {
    val newNameStateContent = viewModel.textFieldState.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingMessage(
            newNameStateContent.value
        ) { newName -> viewModel.onTextChanged(newName) }
    }
}

@Composable
fun GreetingMessage(
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit
) {

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)
    Button(onClick = { }) {
        Text(textFieldValue)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    MainScreen()
}