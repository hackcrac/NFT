package com.example.nftui.models

import com.example.nftui.R
import java.util.UUID

data class NFTCategory(
    val title: String,
    val image: Int,
    val id: UUID = UUID.randomUUID()
)

val categories = listOf<NFTCategory>(
    NFTCategory(title=  "Art", image = R.drawable.card_art),
    NFTCategory(title= "Music", image= R.drawable.card_music),
    NFTCategory(title= "Virtual Worlds", image= R.drawable.card_vw)
)
