package pontinisystems.doctorbrewer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import pontinisystems.doctorbrewer.features.profile.impl.CreateProfileActivity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, CreateProfileActivity::class.java))
        finish()
    }
}

