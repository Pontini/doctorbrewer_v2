package pontinisystems.doctorbrewer.design_system.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = colorBlueZodiac,
            ),
            placeholder = { Text(text = label, style = TextStyle(color = labelColor)) },
            onValueChange = {
                if (it.length <= maxLength) {
                    textState = it
                    callback.onChangeText(textState)

                }
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
            color = labelColor
        )
    }
}

interface Callback {
    fun onChangeText(newText: String)
}