package org.example.project.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.ic_favorites_outlined
import kotlinproject.composeapp.generated.resources.ic_locations_outlined
import kotlinproject.composeapp.generated.resources.weather_events
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(paddingValues).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        BasicWeatherInformation( )
        WeatherEvents()
    }
}

@Composable
fun BasicWeatherInformation(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text("San Francisco", style = MaterialTheme.typography.headlineLarge)
        Text("10:00 AM", style =  MaterialTheme.typography.titleSmall)
        Text("25°C", style = MaterialTheme.typography.headlineMedium)
        Text("Partly Cloudy", style = MaterialTheme.typography.titleMedium)
        Text("Humidity: 60%", style = MaterialTheme.typography.titleSmall)
        Box{
        }
    }
}

@Composable
fun WeatherEvents(){
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)){
        Box(modifier = Modifier.fillMaxWidth()){
            Text(stringResource(Res.string.weather_events), style = MaterialTheme.typography.titleLarge)
        }
        LazyColumn(modifier = Modifier.padding(vertical = 12.dp)) {
            items(10) { _ ->
                WeatherEventsItem(vectorResource(Res.drawable.ic_locations_outlined), "Wind damage", "Wind Damage")
            }
        }

    }
}

@Composable
@Preview
fun WeatherEventsItem(icon: ImageVector, title: String, description: String) {
    Row(modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.fillMaxHeight()
            .clip(shape = MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.surfaceVariant)
            .padding(12.dp)
           ) {
            Icon(icon, contentDescription = null)
        }
        Box(modifier = Modifier.width(16.dp))
        Column {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Text(text = description, style = MaterialTheme.typography.titleSmall)
        }
        Box(modifier = Modifier.weight(1f).fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd){
            Icon(vectorResource(Res.drawable.ic_favorites_outlined), "")
        }
    }

}

