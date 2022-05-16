package test.safegazers.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import test.safegazers.domain.use_case.GetStargazersPagerUseCase
import javax.inject.Inject

@HiltViewModel
class StargazersScreenViewModel @Inject constructor(
    private val getStargazersPagerUseCase: GetStargazersPagerUseCase
) : ViewModel() {

    private data class StargazersQuery(val owner: String, val repo: String)

    private val query = MutableStateFlow<StargazersQuery?>(null)

    val error = MutableStateFlow<Throwable?>(null)

    val stargazers = query.filterNotNull().flatMapLatest { (owner, repo) ->
        val result = getStargazersPagerUseCase.invoke(owner, repo)
        val ex = result.exceptionOrNull()
        if (ex != null) {
            error.value = ex
            flowOf()
        } else {
            result.getOrThrow().flow
        }
    }.cachedIn(viewModelScope)

    fun query(owner: String, repo: String) {
        if (owner.isBlank() || repo.isBlank()) return
        query.value = StargazersQuery(owner, repo)
    }
}