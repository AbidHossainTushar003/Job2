# Implementation Plan - Fix Project Inconsistencies and Build Errors

The project is currently in a broken state due to a partial package rename, missing manifest declarations, and build-time incompatibilities with AGP 9.0's built-in Kotlin support. This plan will standardize the project to use the `com.example.job2` package and fix the User Profile Registration flow.

## User Review Required

> [!IMPORTANT]
> - `MainActivity.kt` will be updated to act as a redirect to `WelcomeActivity`, or removed in favor of making `WelcomeActivity` the entry point.
> - `gradle.properties` will be modified to allow legacy Kotlin source sets for KSP compatibility.

## Proposed Changes

### Build Configuration

#### [MODIFY] [gradle.properties](file:///C:/Users/lab%20505/Desktop/New%20folder%20(2)/gradle.properties)
- Add `android.disallowKotlinSourceSets=false` to resolve KSP compatibility issues with AGP 9.0 built-in Kotlin.

#### [MODIFY] [libs.versions.toml](file:///C:/Users/lab%20505/Desktop/New%20folder%20(2)/gradle/libs.versions.toml)
- Move Room and Lifecycle dependencies to the version catalog for consistency.

#### [MODIFY] [app/build.gradle.kts](file:///C:/Users/lab%20505/Desktop/New%20folder%20(2)/app/build.gradle.kts)
- Use version catalog for Room and Lifecycle dependencies.

### Source Code Refactoring

#### [MODIFY] All Kotlin files in `app/src/main/java/com/example/job2/`
- Update package declarations from `com.example.userprofileregistration` to `com.example.job2`.
- Update imports to match the new package structure.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/lab%20505/Desktop/New%20folder%20(2)/app/src/main/java/com/example/job2/MainActivity.kt)
- Update or replace to properly integrate with the User Profile flow (currently refers to non-existent Student classes).

### Android Manifest

#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/lab%20505/Desktop/New%20folder%20(2)/app/src/main/AndroidManifest.xml)
- Register `WelcomeActivity`, `ProfileListActivity`, `AddProfileActivity`, and `SingleProfileActivity`.
- Set `WelcomeActivity` as the launcher activity.

## Verification Plan

### Automated Tests
- Run `./gradlew help` to verify build configuration.
- Run `./gradlew assembleDebug` to ensure all activities and Room components compile.

### Manual Verification
- Deploy to device/emulator and verify that the app starts at the Welcome screen and can navigate to the Profile List.
