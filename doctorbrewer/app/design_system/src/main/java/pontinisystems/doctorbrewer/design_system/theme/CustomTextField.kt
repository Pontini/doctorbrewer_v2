package pontinisystems.doctorbrewer.design_system.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pontinisystems.doctorbrewer.design_system.R

@Composable
fun CustomTextField(
    maxLength: Int = 100,
    label: String,
    labelColor: Color = colorBlueZodiac,
    backgroundColor: Color = Color.White,
    callback: Callback
) {
    Column(modifier = Modifier.padding(16.dp)) {
        var textState by remember { mutableStateOf("") }

        OutlinedTextField(
            isError = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Phone",
                    style = TextStyle(
                        color = colorBlueZodiac,
                    )
                )
            },

            placeholder = {
                Text(
                    text = label,
                    style = TextStyle(
                        color = colorTomato,
                        textAlign = TextAlign.Center
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor=backgroundColor,
                focusedBorderColor = colorBlueZodiac,
                unfocusedBorderColor = colorBlueZodiac,
                focusedLabelColor = MaterialTheme.colors.secondary,
                cursorColor = labelColor
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            value = textState,
            onValueChange = { textState = it },
        )
        Text(
            text = "${textState.length} / $maxLength",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.End,
            color = labelColor
        )
    }
}

interface Callback {
    fun onChangeText(newText: String)
}