package test.safegazers.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColors = darkColors(
    primary = Purple80,
    secondary = PurpleGrey80
)

@Composable
fun SafegazersTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColors,
        typography = Typography,
        content = content
    )
}