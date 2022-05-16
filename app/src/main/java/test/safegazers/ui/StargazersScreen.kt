package test.safegazers.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import test.safegazers.R

@Composable
fun StargazersScreen(
    viewModel: StargazersScreenViewModel = viewModel()
) {
    var owner by rememberSaveable { mutableStateOf("") }
    var repo by rememberSaveable { mutableStateOf("") }
    val error by viewModel.error.collectAsState()

    val stargazers = viewModel.stargazers.collectAsLazyPagingItems()

    if (error != null || stargazers.loadState.source.append is LoadState.Error) {
        AlertDialog(
            onDismissRequest = { viewModel.error.value = null },
            shape = RoundedCornerShape(12.dp),
            title = {
                Text(
                    text = stringResource(id = R.string.error)
                )
            },
            backgroundColor = MaterialTheme.colors.primary,
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { viewModel.error.value = null },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.surface,
                            contentColor = MaterialTheme.colors.onSurface
                        )
                    ) {
                        Text(text = stringResource(id = android.R.string.ok))
                    }
                }
            },
            text = {
                Text(
                    error?.message
                        ?: (stargazers.loadState.source.append as? LoadState.Error)?.error?.message
                        ?: stringResource(id = R.string.unknown_error)
                )
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = owner,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.repo_owner)
                        )
                    },
                    onValueChange = {
                        owner = it
                    }
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = repo,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.repo_name)
                        )
                    },
                    onValueChange = {
                        repo = it
                    }
                )
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        viewModel.query(owner, repo)
                    }
                ) {
                    Text(stringResource(R.string.get_stargazers))
                }
            }
        }
        StargazerItemList(
            modifier = Modifier.weight(1f),
            stargazers = stargazers
        )
    }
}