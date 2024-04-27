![Kotlin Badge](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=fff&style=flat)
![Android Badge](https://img.shields.io/badge/Android-34A853?logo=android&logoColor=fff&style=flat)
![Jetpack Compose Badge](https://img.shields.io/badge/Jetpack%20Compose-4285F4?logo=jetpackcompose&logoColor=fff&style=flat)
![JitPack Badge](https://img.shields.io/badge/JitPack-000?logo=jitpack&logoColor=fff&style=flat)

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
    maven {
      url = uri("https://jitpack.io")
    }
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
