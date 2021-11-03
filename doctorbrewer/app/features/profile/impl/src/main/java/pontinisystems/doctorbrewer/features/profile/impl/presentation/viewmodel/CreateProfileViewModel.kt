package pontinisystems.doctorbrewer.features.profile.impl.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pontinisystems.core.DispatcherProvider
import pontinisystems.core.Either
import pontinisystems.doctorbrewer.features.profile.impl.domain.repositories.ProfileRepository
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewaction.CreateProfileViewAction
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewstate.CreateProfileViewState
import pontinisystems.doctorbrewer.features.profile.publ.domain.usecases.ValidateFormCreateProfile
import javax.inject.Inject


@HiltViewModel
class CreateProfileViewModel @Inject constructor(
    private val repository: ProfileRepository,
    private val validate: ValidateFormCreateProfile,
    private val dispatcherProvider: DispatcherProvider

) : BaseViewModel<CreateProfileViewState, CreateProfileViewAction>() {

    override val viewState: CreateProfileViewState = CreateProfileViewState()

    override fun dispatchViewAction(viewAction: CreateProfileViewAction) {
        when (viewAction) {
            is CreateProfileViewAction.OnChange -> {
                viewState.profile.value = viewAction.profile
                validateField()
            }
        }
    }

    private fun validateField() {
        viewModelScope.launch(dispatcherProvider.io()) {
            when (validate(viewState.profile.value)) {
                is Either.Success -> {
                    viewState.setButtonIsEnable(true)
                }
                is Either.Error -> {
                    viewState.setButtonIsEnable(false)
                }
            }
        }
    }

}
