package com.example.nftui.models

import com.example.nftui.R

data class NFTCollection (
    val title: String,
    val image: Int,
    var likes: Int
)

val collections = listOf<NFTCollection>(
    NFTCollection(title = "3D Art", image= R.drawable.card_3d, likes= 123),
    NFTCollection(title = "Abstract Art", image= R.drawable.card_abstract, likes= 200),
    NFTCollection(title = "Portrait", image= R.drawable.card_portrait, likes= 242),
    NFTCollection(title = "Metaverse", image= R.drawable.card_metaverse, likes= 420)

)