package com.example.nftui.stats

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftui.models.ranking
import com.example.nftui.ui.theme.NFTUITheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StatsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Stats",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
        containerColor = Color(33, 17, 52)
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            CustomTabComponent()
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                shape = RoundedCornerShape(15.dp),
                color = Color.White.copy(0.15f),
                border = BorderStroke(1.dp, Color.White.copy(0.5f))
            ) {
                RankingTable(ranking = ranking)
            }
        }
    }
}


@Composable
fun CustomTabComponent() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabData = listOf(
        "Ranking" to Icons.Default.Assessment,
        "Activity" to Icons.Default.TrackChanges
    )
    TabRow(
        selectedTabIndex = tabIndex,
        containerColor = Color.Transparent,
        divider = {
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(Color(66, 34, 104))
            )
        },
        indicator = { tabPosition ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabOffset(tabPosition[tabIndex]),
                height = 4.dp,
                color = Color(148, 103, 255)
            )
        }
    ) {
        tabData.forEachIndexed { index, pair ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(imageVector = pair.second, contentDescription = null, tint = Color.White)
                    Text(
                        text = pair.first,
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

private fun Modifier.customTabOffset(tabPosition: TabPosition): Modifier = composed {
    val indicatorWidth = 118.dp
    val currentTabWidth = tabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = tabPosition.left + (currentTabWidth - indicatorWidth)/2 ,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing), label = "IndicatorOffset"
    )
    fillMaxSize()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}

@Preview
@Composable
fun PreviewStatsScreen() {
    NFTUITheme {
        StatsScreen()
    }
}