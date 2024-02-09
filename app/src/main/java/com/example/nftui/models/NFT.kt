package com.example.nftui.models

import com.example.nftui.R
import java.util.UUID

data class NFT(
    val title: String,
    val subtitle: String,
    val image: Int,
    var likes: Int = 0,
    var eth: Double = 0.0,
    val id: UUID = UUID.randomUUID()
)

val nfts = listOf<NFT>(
    NFT("Wave", "wav2 #5672", R.drawable.card_wave2, 5168, 0.018),
    NFT("Abstract Pink", "abstract #5672", R.drawable.card_pink, 1808, 0.986),
    NFT("Wave", "wavpi #5267", R.drawable.card_wave2, 2030, 0.26),
    NFT("Abstract23", "abstract #2038", R.drawable.card_abs23, 2068, 0.246),
    NFT("Music", "nali #7890", R.drawable.card_musicnft, 690, 0.03),
    NFT("Ball", "baalli #4898", R.drawable.card_ball, 1698, 0.46),
    NFT("Ring", "Ring #9288", R.drawable.card_ring, 408, 0.106),
    NFT("Beer", "beer #1238", R.drawable.card_beer, 208, 0.26),
)