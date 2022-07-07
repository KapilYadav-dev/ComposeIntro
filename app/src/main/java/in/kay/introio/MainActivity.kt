package `in`.kay.introio

import `in`.kay.composeintro.IntroData
import `in`.kay.composeintro.IntroScreen
import `in`.kay.introio.ui.theme.IntroioTheme
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Password
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

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
                    val context = LocalContext.current
                    //Usage
                    IntroScreen(
                        //Passing the list
                        items = introItems(),

                        // Setting the Header icon
                        headerIcon = Icons.Outlined.Password,
                        //Left click handler
                        onLeftButtonClick = {
                            Toast.makeText(context,"Left click", Toast.LENGTH_SHORT).show()
                        },
                        //Right click handler
                        onRightButtonClick = {
                            Toast.makeText(context,"Right click", Toast.LENGTH_SHORT).show()
                        },
                        //On backpress handler
                        onBackPress = {
                            Toast.makeText(context,"BackPRess Page", Toast.LENGTH_SHORT).show()
                        },
                        //Get current Page
                        currentPage = {
                            Toast.makeText(context,"Current Page: $it", Toast.LENGTH_SHORT).show()
                        },

                    )
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