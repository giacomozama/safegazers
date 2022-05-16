package test.safegazers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import test.safegazers.ui.StargazersScreen
import test.safegazers.ui.theme.SafegazersTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafegazersTheme {
                StargazersScreen()
            }
        }
    }
}