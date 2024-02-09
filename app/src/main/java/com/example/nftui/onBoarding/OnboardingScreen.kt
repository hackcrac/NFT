package com.example.nftui.onBoarding

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.nftui.ui.theme.NFTUITheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnBoardingScreen(navigationAction: () -> Unit) {
    Scaffold{
        Box {
            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = "Background Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 80.dp)
            ) {
                Text(
                    text = "Welcome to NFT Marketplace",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Black
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.65f))
                Surface(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(0.1f),
                            shape = RoundedCornerShape(27.dp)
                        )
                        .clip(RoundedCornerShape(27.dp)), tonalElevation = 4.dp, shadowElevation = 4.dp
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.cardblur),
                            contentDescription = "Card background",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(27.dp)
                        ) {
                            Text(
                                text = "Explore and Mint NFTs",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "You can buy and sell the NFTs of the best artists in the world",
                                color = Color.White.copy(alpha = 0.8f),
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = Modifier.padding(bottom = 27.dp))
                            Button(
                                onClick = navigationAction,
                                shape = RoundedCornerShape(percent = 50),
                                modifier = Modifier.border(
                                    width = 1.dp,
                                    color = Color.White.copy(0.5f),
                                    shape = RoundedCornerShape(percent = 50)
                                ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        151,
                                        169,
                                        246,
                                        alpha = 0x32
                                    ), contentColor = Color.White
                                )
                            ) {
                                Text(
                                    "Get Started now",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(horizontal = 40.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun OnBoardingCardPreview() {
    NFTUITheme {
        OnBoardingScreen {}
    }
}
