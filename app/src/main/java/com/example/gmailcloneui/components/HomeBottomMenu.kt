package com.example.gmailcloneui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gmailcloneui.models.BottomMenuData

/**
 * Created by Patrick Adutwum on 14/10/2022.
 */

@Composable
fun HomeBottomMenu(){
    val items = listOf(
        BottomMenuData.Mail,
        BottomMenuData.Meet
    )
    
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black,
    ) {
        items.forEach { 
            BottomNavigationItem(
                label = { Text(text = it.title)},
                alwaysShowLabel = true,
                selected = false, onClick = { /*TODO*/ },
                icon = {Icon(imageVector = it.icon, contentDescription = it.title)},
            )
        }
    }
}