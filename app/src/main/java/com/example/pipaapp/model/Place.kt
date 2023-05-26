package com.example.pipaapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val id: Int,
    @StringRes val titleResourceId: Int,
    val textResource: String,
    @DrawableRes val imageResourceId: Int,
    val mapResourceDirections: String,
    var place: PlaceType = PlaceType.PRAIAS
)