package com.example.nftui.stats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftui.R
import com.example.nftui.models.ranking

@Composable
fun RankingRow(index: Int, title: String, image: Int, change: Double, eth: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(48.dp)
    ) {
        Text(
            text = "${index + 1}",
            color = Color(235, 235, 245).copy(0.6f),
            fontSize = 15.sp
        )
        Image(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = image),
            contentDescription = title,
            contentScale = ContentScale.Crop
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "view info",
                    color = Color(235, 235, 245).copy(0.6f),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Start
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
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
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.End
                    )
                }
                Text(
                    text = "$change%",
                    color = if (change > 0) Color.Green else Color.Red,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewRankingRow() {
    RankingRow(
        index = 0,
        title = ranking[0].title,
        image = ranking[0].image,
        change = ranking[0].percentChange,
        eth = ranking[0].eth
    )
}