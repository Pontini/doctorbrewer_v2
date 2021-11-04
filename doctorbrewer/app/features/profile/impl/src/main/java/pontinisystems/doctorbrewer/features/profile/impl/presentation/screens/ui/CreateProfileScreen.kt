package pontinisystems.doctorbrewer.features.profile.impl.presentation.screens.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.asStateFlow
import pontinisystems.doctorbrewer.design_system.theme.Callback
import pontinisystems.doctorbrewer.design_system.theme.CustomTextField
import pontinisystems.doctorbrewer.design_system.theme.colorBlueZodiac
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewaction.CreateProfileViewAction
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewmodel.CreateProfileViewModel
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewstate.CreateProfileViewState

@Composable
fun CreateProfileScreen(viewModel: CreateProfileViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Create Profile",
                        style = TextStyle(color = colorBlueZodiac, fontSize = 18.sp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "Menu Btn")
                    }
                },
                backgroundColor = Color.White,
                elevation = 0.dp,
                modifier = Modifier.height(80.dp),
            )
        },

        bottomBar = {
            val isEnable = viewModel.viewState.iSEnableButton.value
            Button(

                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .height(60.dp),
                enabled = isEnable,
                content = { Text("Save") },
                onClick = {
                },

                )
        },

        content = {
            Column() {
                CustomTextField(label = "Nome", callback = object : Callback {
                    override fun onChangeText(newText: String) {
                        val copy = viewModel.viewState.profile.asStateFlow().value.copy(name = newText)
                        viewModel.dispatchViewAction(CreateProfileViewAction.OnChange(copy))
                    }

                })
            }

        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //CreateProfileScreen(null )
}


fun onChangeName() {

}


