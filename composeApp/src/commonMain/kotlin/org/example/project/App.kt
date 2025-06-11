package org.example.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.weather
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.core.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.example.project.presentation.screen.FavoriteTab
import org.example.project.presentation.screen.HomeTab
import org.example.project.presentation.screen.PastDaysTab
import org.jetbrains.compose.resources.vectorResource

@Composable
@Preview
fun App() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            TabNavigator(HomeTab) {
                Scaffold(
                    topBar = { topBar() },
                    bottomBar = { navigationBar() }
                ) { paddingValues ->
                    Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                        CurrentTab()
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(
) {
    CenterAlignedTopAppBar(
        title = {
            Box {
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
    NavigationBar(
        content = {
            listOf(FavoriteTab, HomeTab, PastDaysTab).forEach { tab ->
                TabNavigationBarItem(tab)
            }
        },
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}

@Composable
private fun RowScope.TabNavigationBarItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    val selected = tabNavigator.current == tab

    val iconRes = when (tab) {
        is HomeTab -> if (selected) tab.filledIcon else tab.outlinedIcon
        is FavoriteTab -> if (selected) tab.filledIcon else tab.outlinedIcon
        is PastDaysTab -> if (selected) tab.filledIcon else tab.outlinedIcon
        else -> null
    }

    val labelRes = when (tab) {
        is HomeTab -> tab.label
        is FavoriteTab -> tab.label
        is PastDaysTab -> tab.label
        else -> null
    }

    NavigationBarItem(
        selected = false,
        onClick = { tabNavigator.current = tab },
        icon = {
            iconRes?.let { icon ->
                Icon(
                    painter = rememberVectorPainter(vectorResource(icon)),
                    contentDescription = null,
                    tint = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        },
        label = {
            labelRes?.let {
                Text(
                    stringResource(it),
                    color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    )
}
