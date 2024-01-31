package com.saavatech.composableblogui.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
        Surface(modifier = Modifier.padding(10.dp)) {
            Column {
                TrendingSection(paddingValues)
                Spacer(modifier = Modifier.height(10.dp))
                PostsByCategory()
            }
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


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TrendingSection(paddingValues: PaddingValues){
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    HorizontalPager(
        state = pagerState,
    ) { page ->
        // Our page content
        Column(
            modifier = Modifier
                .height(450.dp)
                .padding(paddingValues)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//                header row definition
            Row(
                modifier =  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text("Trending Blogs",
                    color = MaterialTheme.colorScheme.primaryContainer,
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
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
//            .align(Alignment.BottomCenter)
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration)
                MaterialTheme.colorScheme.primaryContainer
            else
                Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostsByCategory(){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(2.dp),
    ) {
        val pagerState= rememberPagerState(pageCount ={3})
        val coroutineScope = rememberCoroutineScope()

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor =Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primaryContainer,
            divider = {},
            indicator = {tabPosition->
                TabRowDefaults.Indicator(
                    Modifier
                        .tabIndicatorOffset(tabPosition[pagerState.currentPage])
                        .width(4.dp)
                    ,
                    height = 2.dp,
                    color= MaterialTheme.colorScheme.primary
                )
            }
        ) {
            Tab(
                selected = pagerState.currentPage == 0,
                text = { Text( "Design") },
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                }
            )

            Tab(
                selected = pagerState.currentPage == 1,
                text = { Text( "Financial") },
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                }
            )

            Tab(
                selected = pagerState.currentPage == 2,
                text = { Text( "Legal") },
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(2)
                    }
                }
            )
        }

        HorizontalPager(state = pagerState, userScrollEnabled = false) {
            page->
            Column(Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                LazyRow {
                    items(5) {
                        PostCard()
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }

            }

        }
    }


}

@Composable
fun PostCard(){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
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

                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text("By Hassan Saava",
                        style = MaterialTheme.typography.labelSmall)
                    Text("02/12/2021",
                        style = MaterialTheme.typography.bodySmall)
                }

            }
        }

    }
}