package pontinisystems.doctorbrewer.features.profile.impl.presentation.viewaction


sealed class CreateProfileViewAction {


    object Fetch : CreateProfileViewAction()

    object Init : CreateProfileViewAction()
}