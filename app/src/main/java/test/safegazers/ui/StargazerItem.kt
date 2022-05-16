package test.safegazers.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import test.safegazers.R
import test.safegazers.sdk.domain.entities.Stargazer
import java.time.format.DateTimeFormatter

@Composable
fun StargazerItem(stargazer: Stargazer) {

    val datTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = stargazer.user.login)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(
                    R.string.starred_at,
                    stargazer.starredAt.format(datTimeFormatter)
                )
            )
        }
    }
}