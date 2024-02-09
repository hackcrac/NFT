package com.example.nftui.stats

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nftui.models.Ranking
import com.example.nftui.models.ranking

@Composable
fun RankingTable(ranking: List<Ranking>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        itemsIndexed(items = ranking, key = { _, item -> item.id }) { index, item ->
            RankingRow(
                index = index,
                title = item.title,
                image = item.image,
                change = item.percentChange,
                eth = item.eth
            )
        }
    }
}

@Preview
@Composable
fun PreviewRankingTable() {
    RankingTable(ranking)
}