package org.example.project.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.ic_locations_outlined
import org.example.project.presentation.components.WeatherEventsItem
import org.jetbrains.compose.resources.vectorResource

@Composable
fun Favorites() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        items(5) { _ ->
            WeatherEventsItem(vectorResource(Res.drawable.ic_locations_outlined), "Wind damage", "Wind Damage")
            Box(modifier = Modifier.size(14.dp) )
        }
    }

}

