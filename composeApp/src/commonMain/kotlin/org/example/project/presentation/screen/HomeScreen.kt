package org.example.project.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.ic_locations_filled
import kotlinproject.composeapp.generated.resources.ic_locations_outlined
import kotlinproject.composeapp.generated.resources.locations
import kotlinproject.composeapp.generated.resources.weather
import kotlinproject.composeapp.generated.resources.weather_events
import org.example.project.presentation.components.WeatherEventsItem
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

object HomeTab : Tab{
    val filledIcon = Res.drawable.ic_locations_filled
    val outlinedIcon = Res.drawable.ic_locations_outlined

    val label = Res.string.locations

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(vectorResource(outlinedIcon))
            val title = stringResource(Res.string.weather)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }
    @Composable
    override fun Content() {
        HomeScreen()
    }

}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize(),
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
