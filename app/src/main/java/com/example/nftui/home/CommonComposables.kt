package com.example.nftui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Likes(likes: Int, isLiked: Boolean, onClick:()->Unit){
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconToggleButton(
            checked = isLiked,
            onCheckedChange = {
                onClick()
            },
            modifier = Modifier.size(13.dp)
        ) {
            Icon(
                imageVector = if(isLiked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                tint = if(isLiked) Color.Red else Color(235, 235, 245).copy(0.6f),
                contentDescription = "Favourite Button"
            )
        }
        Text(
            likes.toString(),
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            textAlign = TextAlign.Right,
            color = Color(235, 235, 245).copy(0.6f)
        )
    }
}