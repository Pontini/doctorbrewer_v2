package pontinisystems.doctorbrewer.features.profile.impl.presentation.viewstate

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile


class CreateProfileViewState {
    val state = MutableLiveData<State>()

    private val _action = MutableStateFlow<Action>(Action.Init)
    val action = _action.asStateFlow()

    fun setNewAction(newAction: Action) {
        _action.value = newAction
    }

    private val _isEnableButton = MutableStateFlow<Boolean>(false)
    val iSEnableButton = _isEnableButton.asStateFlow()
    fun setButtonIsEnable(newValue: Boolean) {
        _isEnableButton.value = newValue
    }

    var profile = MutableStateFlow<Profile>(Profile(name = "", lastName = ""))

    sealed class Action {
        object Init : Action()
        data class ShowMessage(val message: String) : Action()
    }


    sealed class State {
        data class Success(val profile: Profile) : State()
        object Loading : State()
        data class Error(val message: String) : State()
    }
}

