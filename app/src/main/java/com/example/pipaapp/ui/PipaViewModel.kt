package com.example.pipaapp.ui

import androidx.lifecycle.ViewModel
import com.example.pipaapp.data.LocalPlacesDataProvider
import com.example.pipaapp.model.Place
import com.example.pipaapp.model.PlaceType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PipaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PipaUiState())
    val uiState: StateFlow<PipaUiState> = _uiState

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        var places: Map<PlaceType, List<Place>> =
            LocalPlacesDataProvider.allPlaces.groupBy { it.place }
        _uiState.value =
            PipaUiState(
                list = places,
                currentPlace = places[PlaceType.PRAIAS]?.get(0)
                    ?: LocalPlacesDataProvider.defaultPlace
            )
    }

    fun updateDetailsScreenStates(place: Place) {
        _uiState.update {
            it.copy(
                currentPlace = place,
                isShowingListPage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentPlace = it.list[it.currentPlaceType]?.get(0)
                    ?: LocalPlacesDataProvider.defaultPlace,
                isShowingListPage = true
            )
        }
    }

    fun updateCurrentPlaceType(placeType: PlaceType) {
        _uiState.update {
            it.copy(
                currentPlaceType = placeType
            )
        }
    }
}