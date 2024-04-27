<img src="https://img.shields.io/badge/-Kotlin-ffffff.svg?logo=kotlin&style=flat"> <img src="https://img.shields.io/badge/-Android-ffffff.svg?logo=android&style=flat"> <img src="https://img.shields.io/badge/-Compose-ffffff.svg?logo=jetpackcompose&style=flat">

# IntTextField

IntTextField is a custom Compose library designed to handle integer input efficiently within Jetpack Compose UIs. 
This library simplifies the process of taking integer input by ensuring that only numeric values are accepted and handled in the text field.

## Get Started
`setting.gradle`
```gradle
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
  }
}

// or setting.gradle.kts
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
  }
}
```

`build.gradle`
```gradle
dependencies {
  implementation 'com.github.Rikuto13ten:IntTextField:1.0.0'

  // or build.gradle.kts
  implementation("com.github.Rikuto13ten:IntTextField:1.0.0")
}
```

## License
MIT
