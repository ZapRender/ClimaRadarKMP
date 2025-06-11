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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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