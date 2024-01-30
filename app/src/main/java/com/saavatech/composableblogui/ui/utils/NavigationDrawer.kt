package com.saavatech.composableblogui.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saavatech.composableblogui.enums.MainRoute
import com.saavatech.composableblogui.models.NavigationItem

@Composable
fun NavigationDrawer(){
    val menuItems = listOf<NavigationItem>(
        NavigationItem("Home",Icons.Default.Home,null,null),
        NavigationItem("About",Icons.Default.Home,null,MainRoute.About.name),
        NavigationItem("Profile",Icons.Default.Home,null,MainRoute.Profile.name),
        NavigationItem("Home",Icons.Default.Home,null,null),
        NavigationItem("Home",Icons.Default.Home,null,null),
        NavigationItem("Home",Icons.Default.Home,null,null),
    )
    
    val selectedItem by remember {        mutableStateOf(menuItems[0])        
    }
    
    ModalNavigationDrawer(
        drawerContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 64.dp),
                contentAlignment = Alignment.Center
            ) {
                menuItems.forEach { 
                    navigationItem ->  
                    NavigationDrawerItem(
                        label = { Text(text = navigationItem.title)},
                        selected = navigationItem == selectedItem,
                        onClick = { /*TODO*/ })
                }
                
            }
        }
    ) {

    }
}