package com.example.nftui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftui.R
import com.example.nftui.models.nfts

@Composable
fun NFTCard(title: String, subtitle: String, image: Int, likes: Int, eth: Double) {
    var isLiked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .height(262.dp)
            .width(175.dp)
            .border(
                width = 1.dp, color = Color.White.copy(0.5f), shape = RoundedCornerShape(30.dp)
            )
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White.copy(0.2f))
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier
                .size(155.dp)
                .padding(10.dp)
                .border(1.dp, color = Color.Transparent, shape = RoundedCornerShape(27.dp))
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(start = 10.dp, top = 0.dp, end = 10.dp, 10.dp)) {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                textAlign = TextAlign.Left
            )
            Text(
                text = subtitle,
                color = Color(235, 235, 245).copy(0.6f),
                fontSize = 12.sp,
                textAlign = TextAlign.Left
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_eth),
                    contentDescription = "Ethereum Icon",
                    modifier = Modifier.size(13.dp)
                )
                Text(
                    text = eth.toString(),
                    color = Color.White,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Left
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Likes(likes = likes, isLiked = isLiked) {
                isLiked = !isLiked
            }
        }
    }
}

@Preview
@Composable
fun NFTCardPreview() {
    NFTCard(
        title = nfts[0].title,
        subtitle = nfts[0].subtitle,
        image = nfts[0].image,
        likes = nfts[0].likes,
        eth = nfts[0].eth
    )
}