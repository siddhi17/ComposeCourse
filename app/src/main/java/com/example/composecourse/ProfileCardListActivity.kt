package com.example.composecourse

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.composecourse.ui.theme.MyTheme
import com.example.composecourse.ui.theme.lightGreen200


class ProfileCardListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Adding Theme and colors
            MyTheme {
                MainScreenProfileCard()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenProfileCard(userProfiles: List<UserProfile> = userProfileList) {
    //Adding App Bar
    //  Does not work without column app bar overlaps with content
    /*  Scaffold(topBar = { AppBar() }) {
          Surface(
              modifier = Modifier.fillMaxSize().padding(),
          ) {
              ProfileCard()
          }
      }*/
    //Adding column to content app bar does not overlap with content
    Scaffold(
        topBar = { AppBar() } // Top bar with transparency
    ) { paddingValues ->
        // scroll container instead.
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            // Screen contents
            items(userProfiles) { userProfile ->
                ProfileCard(userProfile = userProfile)
            }
        }
    }
}

@Composable
fun ProfileCard(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            ProfilePicture(userProfile.drawableId, userProfile.status)
            ProfileContent(userProfile.name, userProfile.status)
        }

    }
}

@Composable
fun ProfilePicture(drawableId: String, onlineStatus: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus)
                lightGreen200
            else Color.Red
        ),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        //Using Coil Library
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(drawableId)
                    .build()),
            contentDescription = "Profile image",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides (
                    if (onlineStatus)
                        1f else ContentAlpha.medium)
        ) {
            Text(
                text = userName,
                style = MaterialTheme.typography.labelLarge
            )
        }
        CompositionLocalProvider(LocalContentAlpha provides (ContentAlpha.medium)) {
            Text(
                text = if (onlineStatus)
                    "Active now"
                else "Offline",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }

}


//Adding App Bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Home,
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 12.dp),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        title = { Text("Messaging Application users") }
    )
}


@Preview(showBackground = true)
@Composable
fun DefPreview() {
    MyTheme {
        MainScreenProfileCard()
    }
}