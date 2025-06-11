package org.example.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.events
import kotlinproject.composeapp.generated.resources.favorites
import kotlinproject.composeapp.generated.resources.ic_calendar_filled
import kotlinproject.composeapp.generated.resources.ic_calendar_outlined
import kotlinproject.composeapp.generated.resources.ic_favorites_filled
import kotlinproject.composeapp.generated.resources.ic_favorites_outlined
import kotlinproject.composeapp.generated.resources.ic_locations_filled
import kotlinproject.composeapp.generated.resources.ic_locations_outlined
import kotlinproject.composeapp.generated.resources.locations
import kotlinproject.composeapp.generated.resources.weather
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.core.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import androidx.compose.material3.Scaffold
import org.example.project.presentation.screen.PastDays

@Composable
@Preview
fun App() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Scaffold(
                topBar = { topBar() },
                bottomBar = { navigationBar() }
            ) { paddingValues ->
                Box(modifier = Modifier.fillMaxSize().padding(paddingValues)){
                    PastDays()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(
) {
    TopAppBar(
        title = {
            Box{
                Text(stringResource(Res.string.weather))
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        )

    )
}

@Composable
fun navigationBar(
) {
    val selectedIcons = listOf(
        vectorResource(Res.drawable.ic_calendar_filled),
        vectorResource(Res.drawable.ic_locations_filled),
        vectorResource(Res.drawable.ic_favorites_filled)
    )

    val unselectedIcons = listOf(
        vectorResource(Res.drawable.ic_calendar_outlined),
        vectorResource(Res.drawable.ic_locations_outlined),
        vectorResource(Res.drawable.ic_favorites_outlined)
    )


    NavigationBar(
        content = {
            NavigationBarItem(
                icon = {
                    Icon(vectorResource(
                        Res.drawable.ic_calendar_outlined),
                        "",
                    )

                },
                selected = false,
                onClick = { /* Handle click */ },
                label = {
                    Text(stringResource(Res.string.events))
                }

            )
            NavigationBarItem(
                icon = {
                    Icon(vectorResource(
                        Res.drawable.ic_locations_outlined),
                        "",
                    )

                },
                selected = false,
                onClick = { /* Handle click */ },
                label = {
                    Text(stringResource(Res.string.locations))
                }

            )
            NavigationBarItem(
                icon = {
                    Icon(vectorResource(
                        Res.drawable.ic_favorites_outlined),
                        "",
                    )

                },
                selected = false,
                onClick = { /* Handle click */ },
                label = {
                    Text(stringResource(Res.string.favorites))
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}
