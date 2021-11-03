package pontinisystems.doctorbrewer.features.profile.impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import pontinisystems.doctorbrewer.design_system.theme.DoctorBrewerTheme
import pontinisystems.doctorbrewer.features.profile.impl.presentation.screens.ui.CreateProfileScreen
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewmodel.CreateProfileViewModel

@AndroidEntryPoint
class CreateProfileActivity : ComponentActivity() {
    private val viewModel: CreateProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoctorBrewerTheme {
                CreateProfileScreen(viewModel = viewModel)

            }
        }
    }
}

