package org.example.project.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
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
import kotlinproject.composeapp.generated.resources.events
import kotlinproject.composeapp.generated.resources.ic_calendar_filled
import kotlinproject.composeapp.generated.resources.ic_calendar_outlined
import kotlinproject.composeapp.generated.resources.past_days
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

object PastDaysTab : Tab{
    val filledIcon = Res.drawable.ic_calendar_filled
    val outlinedIcon = Res.drawable.ic_calendar_outlined
    val label = Res.string.events

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(vectorResource(outlinedIcon))
            val title = stringResource(Res.string.past_days)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon,
                )

            }
        }
    @Composable
    override fun Content() {
        PastDays()
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PastDays() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        items(5) { _ ->
            PastDayItem("Today", "Mostly Sunny", "25°C")
            Box(modifier = Modifier.size(14.dp) )
        }
    }

}

@Composable
fun PastDayItem(day: String, weatherCondition: String, temperature: String) {
    Row {
        Column {
            Text(text = day, style = MaterialTheme.typography.titleMedium)
            Text(text = weatherCondition, style = MaterialTheme.typography.titleSmall)
        }
        Box(modifier = Modifier.weight(1f).fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd){
            Text(temperature)
        }
    }
}