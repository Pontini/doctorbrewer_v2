package pontinisystems.doctorbrewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pontinisystems.doctorbrewer.ui.theme.DoctorBrewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoctorBrewerTheme {
                // A surface container using the 'background' color from the theme
               MainScreen( )
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "wrappde content", modifier = Modifier.wrapContentSize())
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DoctorBrewerTheme {
       MainScreen()
    }
}