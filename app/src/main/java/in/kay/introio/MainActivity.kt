package `in`.kay.introio

import `in`.kay.composeintro.IntroData
import `in`.kay.composeintro.IntroScreen
import `in`.kay.introio.ui.theme.IntroioTheme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Password
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Usage
                    IntroScreen(
                        //Passing the list
                        introItems = introItems(),

                        // Setting the Header icon
                        headerIcon = Icons.Outlined.Password,
                        //Left click handler
                        onLeftButtonClick = {
                            Log.d("MERATAG", "left: ")
                        },
                        //Right click handler
                        onRightButtonClick = {
                            Log.d("MERATAG", "Right: ")
                        },
                        //On backpress handler
                        onBackPress = {

                        })
                }
            }
        }
    }
}


fun introItems() = listOf(
    IntroData(
        "Stop using unsecure passwords for your online accounts, level up with OnePass. Get the most secure and difficult-to-crack passwords.",
        "Generate \nSecure Passwords."
    ),
    IntroData(
        "Store and manage all of your passwords from one place. Don’t remember hundreds of passwords, just remember one.",
        "All your passwords are here"

    ),
    IntroData(
        "Don’t compromise your passwords by typing them in public, let OnePass autofill those and keep your credentials secure.",
        "Don't type,\nAutofill your credentials."
    )
)