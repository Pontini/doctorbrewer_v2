package pontinisystems.doctorbrewer.features.profile.impl.presentation.viewstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations


class CreateProfileViewState {
    val state = MutableLiveData<State>()

    val action = MutableLiveData<Action>()


    val movies = MutableLiveData<List<String>>()

    sealed class Action {
    }

    val isLoading: LiveData<Boolean> = Transformations.map(state) {
        it is State.Loading
    }

    val isError: LiveData<Boolean> = Transformations.map(state) {
        it is State.Error
    }

    val isSuccess: LiveData<Boolean> = Transformations.map(state) {
        it is State.Success
    }

    sealed class State {
        data class Success(val movies: List<String>) : State()
        object Loading : State()
        data class Error(val message: String) : State()
    }
}

