package com.example.pipaapp.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pipaapp.R
import com.example.pipaapp.model.Place
import com.example.pipaapp.model.PlaceType
import com.example.pipaapp.ui.utils.PipaNavigationType
import com.example.pipaapp.ui.utils.PlaceContentType

// Class for the Drawer Navigation
private data class NavigationItemContent(
    val placeType: PlaceType,
    val icon: Painter,
    val text: String
)

// Composable that displays all the app
@Composable
fun PipaApp(
    windowsSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val viewModel: PipaViewModel = viewModel()
    val pipaUiState by viewModel.uiState.collectAsState()

    val contentType: PlaceContentType
    val navigationType: PipaNavigationType

    when (windowsSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = PlaceContentType.LIST_ONLY
            navigationType = PipaNavigationType.BOTTOM_NAVIGATION
        }
        WindowWidthSizeClass.Medium -> {
            contentType = PlaceContentType.LIST_ONLY
            navigationType = PipaNavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = PlaceContentType.LIST_AND_DETAIL
            navigationType = PipaNavigationType.PERMANENT_NAVIGATION_DRAWER
        }
        else -> {
            contentType = PlaceContentType.LIST_ONLY
            navigationType = PipaNavigationType.BOTTOM_NAVIGATION
        }
    }

    PipaHomeScreen(
        navigationType = navigationType,
        contentType = contentType,
        pipaUiState = pipaUiState,
        onTabPressed = { placeType: PlaceType ->
            viewModel.updateCurrentPlaceType(placeType = placeType)
            viewModel.resetHomeScreenStates()
        },
        onPlaceCardPressed = { place: Place ->
            viewModel.updateDetailsScreenStates(place = place)
        },
        onDetailScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )

}

// Composable that build the home screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PipaHomeScreen(
    navigationType: PipaNavigationType,
    contentType: PlaceContentType,
    pipaUiState: PipaUiState,
    onTabPressed: (PlaceType) -> Unit,
    onPlaceCardPressed: (Place) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            placeType = PlaceType.PRAIAS,
            icon = painterResource(id = R.drawable.beach_access),
            text = stringResource(id = R.string.praia)
        ),
        NavigationItemContent(
            placeType = PlaceType.HOTÉIS,
            icon = painterResource(id = R.drawable.hotel),
            text = stringResource(id = R.string.hotel)
        ),
        NavigationItemContent(
            placeType = PlaceType.RESTAURANTES,
            icon = painterResource(id = R.drawable.restaurant),
            text = stringResource(id = R.string.restaurante)
        ),
        NavigationItemContent(
            placeType = PlaceType.BARES,
            icon = painterResource(id = R.drawable.nightlife),
            text = stringResource(id = R.string.bares)
        ),
        NavigationItemContent(
            placeType = PlaceType.UTILIDADES,
            icon = painterResource(id = R.drawable.signpost),
            text = stringResource(id = R.string.utilidades)
        ),
    )
    if (navigationType == PipaNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.width(250.dp)) {
                    NavigationDrawerContent(
                        selectedDestination = pipaUiState.currentPlaceType,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList
                    )
                }
            }
        ) {
            PipaAppContent(
                navigationType = navigationType,
                contentType = contentType,
                pipaUiState = pipaUiState,
                onTabPressed = onTabPressed,
                onPlaceCardPressed = onPlaceCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        }
    } else {
        if (pipaUiState.isShowingListPage) {
            PipaAppContent(
                navigationType = navigationType,
                contentType = contentType,
                pipaUiState = pipaUiState,
                onTabPressed = onTabPressed,
                onPlaceCardPressed = onPlaceCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        } else {
            PipaDetailsScreen(
                pipaUiState = pipaUiState,
                isFullScreen = true,
                onBackPressed = onDetailScreenBackPressed,
                modifier = modifier
            )
        }
    }
}

// Displays the content
@Composable
private fun PipaAppContent(
    navigationType: PipaNavigationType,
    contentType: PlaceContentType,
    pipaUiState: PipaUiState,
    onTabPressed: (PlaceType) -> Unit,
    onPlaceCardPressed: (Place) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier
) {
    Row(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(visible = navigationType == PipaNavigationType.NAVIGATION_RAIL) {
            PipaNavigationRail(
                currentTab = pipaUiState.currentPlaceType,
                onTabPressed = onTabPressed,
                navigationItemContentList = navigationItemContentList
            )
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            if (contentType == PlaceContentType.LIST_AND_DETAIL) {
                PipaListAndDetailContent(
                    pipaUiState = pipaUiState,
                    onPlaceCardPressed = onPlaceCardPressed,
                    modifier = Modifier.weight(1f)
                )
            } else {
                PipaListOnlyContent(
                    pipaUiState = pipaUiState,
                    onPlaceCardPressed = onPlaceCardPressed,
                    modifier = Modifier.weight(1f)
                )
            }
            AnimatedVisibility(visible = navigationType == PipaNavigationType.BOTTOM_NAVIGATION) {
                val bottomNavigationContentDescription = stringResource(id = R.string.navigation_bottom)
                PipaBottomNavigationBar(
                    currentTab = pipaUiState.currentPlaceType,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier.testTag(bottomNavigationContentDescription)
                )
            }
        }
    }
}

// If small screen, displays a bottom navigation
@Composable
private fun PipaBottomNavigationBar(
    currentTab: PlaceType,
    onTabPressed: (PlaceType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier.fillMaxWidth()) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.placeType,
                onClick = { onTabPressed(navItem.placeType) },
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text,
                        modifier = modifier.height(30.dp).width(30.dp)
                    )
                }
            )
        }
    }
}

// If medium screen, displays a left side rail navigation
@Composable
private fun PipaNavigationRail(
    modifier: Modifier = Modifier,
    currentTab: PlaceType,
    onTabPressed: (PlaceType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>
) {
    NavigationRail(modifier = modifier.fillMaxHeight()) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.placeType,
                onClick = { onTabPressed(navItem.placeType) },
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text,
                        modifier = modifier.height(30.dp).width(30.dp)
                    )
                }
            )
        }
    }
}

// If big screen, displays a drawer
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavigationDrawerContent(
    selectedDestination: PlaceType,
    onTabPressed: (PlaceType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(12.dp)
    ) {
        NavigationDrawerHeader()
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                },
                selected = selectedDestination == navItem.placeType,
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent,
                    selectedContainerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                onClick = { onTabPressed(navItem.placeType) }
            )
        }
    }
}

// Head of the drawer for big screens
@Composable
private fun NavigationDrawerHeader(modifier: Modifier = Modifier) {
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
            text = stringResource(R.string.pipa_app),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}