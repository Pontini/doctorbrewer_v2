package pontinisystems.doctorbrewer.features.profile.impl.presentation.viewaction

import pontinisystems.doctorbrewer.features.profile.publ.domain.entities.Profile


sealed class CreateProfileViewAction {
    data class OnChange(val profile: Profile):CreateProfileViewAction()
}