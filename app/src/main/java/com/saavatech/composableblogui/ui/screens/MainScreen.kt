package com.saavatech.composableblogui.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saavatech.composableblogui.R
import com.saavatech.composableblogui.ui.theme.ComposableBlogUITheme
import com.saavatech.composableblogui.ui.utils.AppBar
import com.saavatech.composableblogui.ui.utils.RoundedCornerImage
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    ComposableBlogUITheme {
    Scaffold(
        topBar = {
            AppBar("Home", Icons.Default.Menu, iconClickAction = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            })
        }
    ) {
              paddingValues ->
        Surface(modifier = Modifier.padding(8.dp)) {
            TrendingSection(paddingValues)

        }
    }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    // Create a sample DrawerState for preview
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // Call the MainScreen composable with the sample DrawerState
    MainScreen(drawerState = drawerState)
}


@Composable
fun TrendingSection(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
//              verticalArrangement = Arrangement.Center
    ) {
//                header row definition
        Row(
            modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text("Trending Blogs",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium)
            Text("See all",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelSmall)
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow {
            items(5) {
                PostCard()
                Spacer(modifier = Modifier.width(20.dp))
            }
        }

    }
}

@Composable
fun PostCard(){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .size(width = 200.dp, height = 280.dp)
            .background(Color.Transparent)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Top
        ) {
            RoundedCornerImage(
                resourceId = R.drawable.sample_image,
                modifier = Modifier.fillMaxWidth(),
                null,
            )
            Text(
                text = "A Retro kitchen Trends That Are making a comeback, rules to follow when",
                modifier = Modifier
                    .padding(2.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
//                            textAlign = TextAlign.Center,
            )

            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
//            .height(200.dp) // Set the height as needed
                        .clip(shape = shapes.medium)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Column {
                    Text("By Hassan Saava",
                        style = MaterialTheme.typography.labelMedium)
                    Text("02/12/2021",
                        style = MaterialTheme.typography.labelSmall)
                }

            }
        }

    }
}