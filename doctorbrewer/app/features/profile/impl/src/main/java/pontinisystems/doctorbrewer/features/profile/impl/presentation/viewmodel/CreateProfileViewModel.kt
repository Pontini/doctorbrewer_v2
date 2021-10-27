package pontinisystems.doctorbrewer.features.profile.impl.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pontinisystems.core.DispatcherProvider
import pontinisystems.doctorbrewer.features.profile.impl.domain.repositories.ProfileRepository
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewaction.CreateProfileViewAction
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewstate.CreateProfileViewState
import javax.inject.Inject


@HiltViewModel
class CreateProfileViewModel @Inject constructor(
    private val repository: ProfileRepository,
    private val dispatcherProvider: DispatcherProvider,
) : BaseViewModel<CreateProfileViewState, CreateProfileViewAction>() {

    override val viewState: CreateProfileViewState = CreateProfileViewState()

    override fun dispatchViewAction(viewAction: CreateProfileViewAction) {
        when (viewAction) {
            is CreateProfileViewAction.Fetch -> {
                viewModelScope.launch(dispatcherProvider.io()) {
                    val a = repository.getProfile()
                    Log.i("AAAAAA","aaaa")
                }
            }
            CreateProfileViewAction.Init -> TODO()
        }
    }

}






