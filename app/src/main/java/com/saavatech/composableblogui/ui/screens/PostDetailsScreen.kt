package com.saavatech.composableblogui.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.saavatech.composableblogui.R
import com.saavatech.composableblogui.ui.utils.AppBar
import com.saavatech.composableblogui.ui.utils.RoundedCornerImage
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Preview
@Composable
fun PostDetailsScreen(navControllerCallback: Int, navController: NavHostController?) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = {
            AppBar(
                "Details",
                Icons.AutoMirrored.Filled.ArrowBack,
                Icons.Filled.Share,
                iconClickAction = {
                    navController?.navigateUp()
                })
        },
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show snackbar") },
//                icon = { Icon(Icons.Filled.Email, contentDescription = "") },
//                onClick = {
//                    scope.launch {
//                        snackbarHostState.showSnackbar("Snackbar")
//                    }
//                }
//            )
//        }
    ) {
             paddingValues ->
        Surface {
            Column(

                Modifier.padding(12.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Box {
                    RoundedCornerImage(
                        resourceId = R.drawable.sample_image,
                        Modifier.fillMaxWidth(),
                        null,
                    )
                }

                Spacer(Modifier.height(15.dp))

                Text("4 Retro Kitchen Trends That are making a comeback",
                    modifier = Modifier
                        .padding(2.dp),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium)

                Spacer(Modifier.height(10.dp))

                Text(
                    "Sed molestie pellentesque tortor ut blandit. Donec risus velit, " +
                            "faucibus quis massa eget, dictum scelerisque dui. Integer pellentesque lectus " +
                            "ac ligula facilisis, et commodo dolor lacinia. Sed pharetra justo massa," +
                            " eget finibus purus luctus in. Fusce et nisl non magna bibendum semper." +
                            " Duis euismod ultricies sollicitudin. Nam et tortor nibh. Quisque vel " +
                            "sodales erat.",
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start){
                    Text("Read more",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelSmall)

                    Icon(
                        modifier=Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary,
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription =null )
                }

                Spacer(Modifier.height(8.dp))

                Text("Tags",
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                    )
                Spacer(Modifier.height(8.dp))
                Row {
                    Button(
                        modifier=Modifier.height(34.dp),
                        onClick = { /*TODO*/ }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,

                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "Interior")
                            Icon(
                                modifier=Modifier.size(16.dp),
                                imageVector = Icons.Filled.Close, contentDescription = "close icon")
                        }

                        
                    }
                }
            }
        }
    }
}


@Composable
fun SnackBar(){
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {        SnackbarHostState()    }

    ExtendedFloatingActionButton(
        text = { Text("Show snackbar") },
        icon = { Icon(Icons.Filled.MailOutline, contentDescription = "") },
        onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("Snackbar")
            }
        }
    )
}