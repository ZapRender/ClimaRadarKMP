package org.example.project.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.favorites
import kotlinproject.composeapp.generated.resources.ic_favorites_filled
import kotlinproject.composeapp.generated.resources.ic_favorites_outlined
import kotlinproject.composeapp.generated.resources.ic_locations_outlined
import org.example.project.presentation.components.WeatherEventsItem
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

object FavoriteTab : Tab{
    val filledIcon = Res.drawable.ic_favorites_filled
    val outlinedIcon = Res.drawable.ic_favorites_outlined

    val label = Res.string.favorites

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(vectorResource(outlinedIcon))

            val title = stringResource(Res.string.favorites)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon,
                )

            }
        }
    @Composable
    override fun Content() {
        Favorites()
    }
}

@Composable
fun Favorites() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        items(5) { _ ->
            WeatherEventsItem(vectorResource(Res.drawable.ic_locations_outlined), "Wind damage", "Wind Damage")
            Box(modifier = Modifier.size(14.dp) )
        }
    }

}

