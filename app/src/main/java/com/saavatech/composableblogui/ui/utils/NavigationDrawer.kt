package com.saavatech.composableblogui.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saavatech.composableblogui.enums.MainRoute
import com.saavatech.composableblogui.models.NavigationItem
import com.saavatech.composableblogui.ui.screens.AboutScreen
import com.saavatech.composableblogui.ui.screens.MainScreen
import com.saavatech.composableblogui.ui.screens.SettingsScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope()
){
    val menuItems = arrayOf(
        NavigationItem("Home",Icons.Default.Home,null,null),
        NavigationItem("About",Icons.Default.ThumbUp,null, MainRoute.About.name),
        NavigationItem("Profile",Icons.Default.AccountCircle,null, MainRoute.Profile.name),
        NavigationItem("Notifications",Icons.Default.Email,null,null),
        NavigationItem("Settings",Icons.Default.Settings,null,null),
        NavigationItem("Logout",Icons.Default.ExitToApp,null,null),
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(
                    Modifier.background(MaterialTheme.colorScheme.primaryContainer),
                    menuItems){route ->
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate(route)
                }
            }
        }
    ) {
        NavHost(navController = navController,
            startDestination = MainRoute.Profile.name){
            composable(MainRoute.Profile.name){
                MainScreen(drawerState)
            }

            composable(MainRoute.Settings.name){
                SettingsScreen()
            }

            composable(MainRoute.About.name){
                AboutScreen()
            }
        }
    }
}

@Composable
private fun DrawerContent(
    modifier: Modifier,
    menus: Array<NavigationItem>,
    onMenuClick: (String)->Unit
){

    val selectedItem = remember { mutableStateOf(menus[0]) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Row(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                imageVector = Icons.Filled.AccountCircle,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            Column {
                Text(
                    "Hassan Saava",
                    style = MaterialTheme.typography.headlineLarge
                )

                Text("hassansaava@gmail.com",
                    color= Color.Magenta,
                    style = MaterialTheme.typography.bodySmall)
            }
        }


        //                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 32.dp),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "Blog Application", style = MaterialTheme.typography.headlineMedium)
//                }
    }
    Spacer(modifier = Modifier.height(4.dp))

    menus.forEach {
            navigationItem ->
        NavigationDrawerItem(
            label = { Text(text = navigationItem.title)},
            icon = { Icon(
                imageVector = navigationItem.selectedIcon,
                contentDescription = navigationItem.title)
            },
            selected = navigationItem == selectedItem.value,
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            onClick = {
                selectedItem.value = navigationItem
                navigationItem.route?.let { onMenuClick(it) }
            })
    }
}