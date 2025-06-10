package org.example.project.core.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppTypography(): Typography {
    return Typography(
        headlineLarge = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
        ),
        headlineMedium = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        ),
        titleSmall = TextStyle(
            fontSize = 14.sp,
            color = ColorOnSurfaceVariantDark
        ),
    )
}