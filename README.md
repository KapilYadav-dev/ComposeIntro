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

### 1. Add dependency
```groovy
repositories {
  maven { url 'https://jitpack.io' } // Add jitpack
}

dependencies {
  implementation 'com.github.KapilYadav-dev:ComposeIntro:<latest.version>'
}

```

### 3. Use `IntroScreen` composable
```kotlin
// These are the must fields.
IntroScreen(
    //Passing the list
    introItems = items,
    // Setting the Header icon
    headerIcon = Icons.Outlined.Password,
    //Left click handler
    onLeftButtonClick = { },
    //Right click handler
    onRightButtonClick = { },
    //On backpress handler
    onBackPress = { }
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
