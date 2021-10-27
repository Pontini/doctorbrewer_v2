package pontinisystems.doctorbrewer.features.profile.impl.presentation.screens.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewaction.CreateProfileViewAction
import pontinisystems.doctorbrewer.features.profile.impl.presentation.viewmodel.CreateProfileViewModel

@Composable
fun CreateProfileScreen(createProfileViewModel: CreateProfileViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Adopt Me" ) },
                backgroundColor = Color.Blue
            )
        },

        bottomBar = {
            Button(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .height(60.dp),
                content = { Text("Save") },
                onClick = {
                    createProfileViewModel.dispatchViewAction(CreateProfileViewAction.Fetch)
                }
            )
        },

        content = {
            var text by remember { mutableStateOf("") }
            val maxChar = 5

            Column(modifier = Modifier.padding(16.dp)) {
                var textState by remember { mutableStateOf("") }
                val maxLength = 110
                val lightBlue = Color(0xffd8e6ff)
                val blue = Color(0xff76a9ff)
                Text(
                    text = "Nome",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    textAlign = TextAlign.Start,
                    color = blue
                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = textState,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = lightBlue,
                        cursorColor = Color.Black,
                        disabledLabelColor = lightBlue,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    onValueChange = {
                        if (it.length <= maxLength) textState = it
                    },
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    trailingIcon = {
                        if (textState.isNotEmpty()) {
                            IconButton(onClick = { textState = "" }) {
                                Icon(
                                    imageVector = Icons.Outlined.Close,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                )
                Text(
                    text = "${textState.length} / $maxLength",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    textAlign = TextAlign.End,
                    color = blue
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //CreateProfileScreen(null )
}



