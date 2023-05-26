package com.example.pipaapp.ui

import com.example.pipaapp.data.LocalPlacesDataProvider
import com.example.pipaapp.model.Place
import com.example.pipaapp.model.PlaceType

data class PipaUiState(
    val list: Map<PlaceType, List<Place>> = emptyMap(),
    val currentPlaceType: PlaceType = PlaceType.PRAIAS,
    val currentPlace: Place = LocalPlacesDataProvider.defaultPlace,
    val isShowingListPage: Boolean = true
) {
    val currentListPlace: List<Place> by lazy { list[currentPlaceType]!! }
}