# 🎮 PixelBurstButton

A custom Android UI component where the button bursts into pixel particles on click, then resets automatically.

## ✨ Features

- Pixel explosion animation
- Auto-reset after animation
- Lightweight & dependency-free


---

## 📦 Installation (via JitPack)

Add the JitPack repository to your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
```

Then add this dependency to your app-level build.gradle.kts:
```kotlin
dependencies {
    implementation("com.github.appnapps:PixelBurstButton:1.0.0")
}
```

🛠 Usage
In XML
```kotlin
<com.appnapps.pixelburstbutton.PixelBurstButton
android:layout_width="200dp"
android:layout_height="80dp" />

```


Run it to see the animation in action!

<img src="https://github.com/appnapps/PixelBurstButton/blob/main/docs/PixelBurstButton.gif" width="320"/>