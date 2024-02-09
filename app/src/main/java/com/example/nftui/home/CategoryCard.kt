package com.example.nftui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftui.models.categories
import com.example.nftui.ui.theme.NFTUITheme

@Composable
fun CategoryCard(title: String, image: Int) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(27.dp))
            .border(
                width = 1.dp,
                color = Color.White.copy(0.5f),
                shape = RoundedCornerShape(27.dp)
            )
            .height(186.dp)
            .width(280.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Card Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(
                    Alignment.BottomCenter
                )
                .padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
fun PreviewCategoryCard() {
    NFTUITheme {
        Column{
            repeat(3){index ->
                CategoryCard(categories[index].title, categories[index].image)
            }
        }
    }
}