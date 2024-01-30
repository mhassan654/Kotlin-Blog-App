package com.saavatech.composableblogui

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saavatech.composableblogui.enums.MainRoute
import com.saavatech.composableblogui.models.NavigationItem
import com.saavatech.composableblogui.ui.theme.ComposableBlogUITheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableBlogUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationDrawer()

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableBlogUITheme {
        NavigationDrawer()
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationDrawer(
//    val selectedItem by remember { mutableStateOf(menuItems[0])},
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
    val selectedItem = remember { mutableStateOf(menuItems[0]) }


    ModalNavigationDrawer(
        drawerState = drawerState,

        drawerContent = {
            ModalDrawerSheet {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Blog Application", style = MaterialTheme.typography.headlineMedium)
                }
                menuItems.forEach {
                        navigationItem ->
                    NavigationDrawerItem(
                        label = { Text(text = navigationItem.title)},
                        icon = { Icon(
                            imageVector = navigationItem.selectedIcon,
                            contentDescription = navigationItem.title)},
                        selected = navigationItem == selectedItem.value,
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        onClick = { /*TODO*/ })
                }

//                DrawerContent(menuItems){
//                    route ->
//                }
            }

        }
    ) {

        Scaffold(
            topBar = {
                AppBar("Blog Application", Icons.Default.Menu, iconClickAction = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })} ) {
            Text("Home Screen")

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, icon:ImageVector,iconClickAction: ()->Unit){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.secondary
        ),
        navigationIcon = {
            Icon(imageVector = icon,
                contentDescription = "",
                Modifier
                    .padding(horizontal = 12.dp)
                    .clickable(onClick = { iconClickAction.invoke() })
                    .background(Color.White)


            )
        },
        title = { Text(title)})
}

@Composable
private fun DrawerContent(
    menus: Array<NavigationItem>,
    onMenuClick: (String)->Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            imageVector = Icons.Filled.AccountCircle,
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
    Spacer(modifier = Modifier.height(12.dp))

    menus.forEach {
            navigationItem ->
        NavigationDrawerItem(
            label = { Text(text = navigationItem.title)},
            icon = { Icon(
                imageVector = navigationItem.selectedIcon,
                contentDescription = navigationItem.title)},
            selected = false,
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            onClick = {
                navigationItem.route?.let { onMenuClick(it) }
            })
    }
}