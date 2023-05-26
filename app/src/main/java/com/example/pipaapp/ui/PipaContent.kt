package com.example.pipaapp.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pipaapp.R
import com.example.pipaapp.model.Place

// Displays the detail screen
@Composable
fun PipaDetailsScreen(
    modifier: Modifier = Modifier,
    pipaUiState: PipaUiState,
    isFullScreen: Boolean = false,
    onBackPressed: () -> Unit,
) {
    BackHandler {
        onBackPressed()
    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.inverseOnSurface)
            .padding(top = 12.dp)
    ) {
        item {
            if (isFullScreen) {
                PipaDetailsScreenTopBar(onBackPressed, pipaUiState)
            }
            PipaPlaceDetailsCard(
                place = pipaUiState.currentPlace,
                isFullScreen = isFullScreen,
                modifier = if (isFullScreen) {
                    Modifier.padding(horizontal = 16.dp)
                } else {
                    Modifier.padding(end = 16.dp)
                }
            )
        }
    }
}

//Displays the top bar of the detail screen with the title and back button
@Composable
fun PipaDetailsScreenTopBar(
    onBackButtonClicked: () -> Unit,
    pipaUiState: PipaUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBackButtonClicked,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.navigation_back)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(pipaUiState.currentPlace.titleResourceId),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


// Card that shows the information of the place`s detail
@Composable
fun PipaPlaceDetailsCard(
    modifier: Modifier = Modifier,
    place: Place,
    isFullScreen: Boolean = false,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            DetailsScreenCard(place)
        }
    }
}

// Displays the info of the card detail
@Composable
fun DetailsScreenCard(place: Place, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        verticalArrangement = Arrangement.Center
        ) {
        Image(
            painter = painterResource(place.imageResourceId),
            contentDescription = stringResource(id = place.titleResourceId),
            modifier = modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)
        )
        Spacer(modifier = modifier.padding(8.dp))
        Text(
            text = stringResource(id = place.titleResourceId),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.outline
        )
        Spacer(modifier = modifier.padding(8.dp))
        Text(
            text = place.textResource,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = modifier.padding(10.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { getLocation(context, place.mapResourceDirections) }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

// Get location for the selected item
fun getLocation(context: Context, mapDirections: String) {
    val intentUri = Uri.parse("geo:0,0?q=$mapDirections")
    val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
    mapIntent.setPackage("com.google.android.apps.maps")

    // Check if there are any apps that can handle the intent
    mapIntent.resolveActivity(context.packageManager)?.let {
        context.startActivity(mapIntent)
    }
}

// Display the list screen for small devices
@Composable
fun PipaListOnlyContent(
    pipaUiState: PipaUiState,
    onPlaceCardPressed: (Place) -> Unit,
    modifier: Modifier
) {
    val places = pipaUiState.currentListPlace

    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        item {
            PipaHomeTopBar(pipaUiState)
        }
        items(places, key = { place -> place.id }) { place ->
            PipaPlaceListItem(
                place = place,
                onCardClick = { onPlaceCardPressed(place) }
            )
        }
    }
}

// Top bar for small screens with the logo
@Composable
fun PipaHomeTopBar(
    pipaUiState: PipaUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.pipa_app_logo),
            modifier = modifier
                .height(50.dp)
                .width(50.dp)
        )
        Text(
            text = pipaUiState.currentPlaceType.toString(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

// Displays the list and content for big screens like tablet
@Composable
fun PipaListAndDetailContent(
    pipaUiState: PipaUiState,
    onPlaceCardPressed: (Place) -> Unit,
    modifier: Modifier
) {
    val places = pipaUiState.currentListPlace
    Row(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .weight(0.7f)
                .padding(end = 16.dp, top = 8.dp)
        ) {
            items(places, key = { place -> place.id }) { place ->
                PipaPlaceListItem(
                    place = place,
                    onCardClick = {
                        onPlaceCardPressed(place)
                    }
                )
            }
        }
        val activity = LocalContext.current as Activity
        PipaDetailsScreen(
            pipaUiState = pipaUiState,
            modifier = Modifier.weight(1f),
            onBackPressed = { activity.finish() }
        )
    }
}

// Displays each item of the list
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PipaPlaceListItem(
    place: Place,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(vertical = 4.dp)
            .height(100.dp),
        onClick = onCardClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = place.imageResourceId),
                contentDescription = null,
                modifier = modifier.weight(0.8f),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = modifier
                    .weight(1f)
                    .padding(10.dp)

            ) {
                Text(
                    text = stringResource(id = place.titleResourceId),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 25.dp)
                )
            }
        }
    }
}