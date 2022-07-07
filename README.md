# Compose-Intro ✅

## Yes, I'm too bad in naming my libraries : )

![buildStatus](https://img.shields.io/github/workflow/status/theapache64/twyper/Java%20CI%20with%20Gradle?style=plastic)
![latestVersion](https://img.shields.io/github/v/release/KapilYadav-dev/ComposeIntro)


> Yet another Intro Screen library made with the love of Kotlin and Jetpack compose : )❤️

### ✨ Demo

https://github.com/KapilYadav-dev/ComposeIntro/blob/main/demo.mp4

## Screenshot

<img src="https://github.com/KapilYadav-dev/ComposeIntro/blob/main/ss.png"/>

## ⌨️ Usage

![latestVersion](https://img.shields.io/github/v/release/KapilYadav-dev/ComposeIntro)

### 1. Add dependency.
```groovy
repositories {
  maven { url 'https://jitpack.io' } // Add jitpack
}

dependencies {
  implementation 'com.github.KapilYadav-dev:ComposeIntro:<latest.version>'
}

```

### 2. Use `IntroScreen` composable.
```kotlin
// These are the must fields.
IntroScreen(
    //Passing the list
    items = items,
    // Setting the Header icon
    headerIcon = Icons.Outlined.Password,
    //Left click handler
    onLeftButtonClick = { },
    //Right click handler
    onRightButtonClick = { },
    //On backpress handler
    onBackPress = { },
    //Get current Page
    currentPage = { }
)
   
```
### 3. `IntroScreen` composable all params.
```kotlin
fun IntroScreen(
    items: List<IntroData>,
    infiniteLoop: Boolean = false,
    /*
     * These are the color which will shape the color of UI
     */
    headerIconTint: Color = Color(0xfffFF6464),
    primaryColor: Color = Color(0xfffFF6464),
    secondaryColor: Color = Color(0xfffBABABA),
    /*
     * These are the fonts which will shape the fonts of UI
     */
    primaryFont: FontFamily = BebasNue(),
    secondaryFont: FontFamily = Poppins(),
    /*
     * This is the header drawable
     */
    headerIcon: ImageVector,
    /*
     * These are callbacks or high order function which will help to interact with buttons
     */
    onRightButtonClick: () -> Unit,
    onLeftButtonClick: () -> Unit,
    onBackPress: () -> Unit,
    currentPage:(Int) -> Unit,
    /*
     * These are the text of the buttons
     */
    leftButtonText: String = "REGISTER",
    rightButtonText: String = "LOGIN",
    /*
     * These are the units of various text and views
     */
    headerIconSize: Dp = 48.dp,
    primaryFontSize: TextUnit = 56.sp,
    secondaryFontSize: TextUnit = 15.sp,
    highlightFontSize: TextUnit = 40.sp,
    unhighlightFontSize: TextUnit = 20.sp,
    buttonFontSize: TextUnit = 18.sp,
)
```
### 4. Example use of `IntroScreen` composable.
```kotlin
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
```

## ✍️ Author

👤 **mrkaydev**

* Linkedin: <a href="https://www.linkedin.com/in/mrkaydev/" target="_blank">@mrkaydev</a>
* Email: infokaydev@gmail.com

Feel free to ping me 😉

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Open an issue first to discuss what you would like to change.
1. Fork the Project
1. Create your feature branch (`git checkout -b feature/amazing-feature`)
1. Commit your changes (`git commit -m 'Add some amazing feature'`)
1. Push to the branch (`git push origin feature/amazing-feature`)
1. Open a pull request

Please make sure to update tests as appropriate.

## ❤ Show your support

Give a ⭐️ if this project helped you!

<a href="https://www.buymeacoffee.com/mrkaydev" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" width="160">
</a>

## ☑️ TODO

- [ ] Add UI tests and unit tests
- [ ] Add Text size support and more responsive

## 📝 License

```
Copyright © 2022 - mrkaydev

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
