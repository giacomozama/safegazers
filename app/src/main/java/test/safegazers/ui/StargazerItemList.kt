package test.safegazers.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import test.safegazers.sdk.domain.entities.Stargazer

@Composable
fun StargazerItemList(
    modifier: Modifier = Modifier,
    stargazers: LazyPagingItems<Stargazer>
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(
            items = stargazers,
            key = { it.user.id }
        ) {
            if (it != null) StargazerItem(stargazer = it)
        }
    }
}