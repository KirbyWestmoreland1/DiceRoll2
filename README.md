# DiceRoller App (Improved)

## Overview
This app simulates rolling dice. It was built in Kotlin and XML based on the tutorial series provided in the assignment.

## Baseline Features
- Roll button generates a random dice result (drawables)
- Dice image updates to match the roll

## My Enhancement
- **Feature:** Displays the last 10 dice rolls in a scrollable list.
- **Implementation:** 
- `RollHistoryAdapter.kt`: Manages a `mutableListOf<Pair<Int, Int>>`, removes oldest roll when >10 using `removeAt(0)` and `notifyItemRemoved()`.
- `MainActivity.kt`: Increments `rollCounter` and calls `addRoll()` on each dice tap.
- `item_roll.xml`: Layout for each history item (`Roll #X: Y`).
- **Layout:** `activity_main.xml` uses `CoordinatorLayout` with centered `MaterialCardView` for dice.
- **Button Placement:** Click on dice to roll dice using `layout_gravity`.
- **Styling:** `dimens.xml` and `activity_main.XML` for consistent sizes, Material 3 theme.
- **Binding:** `ActivityMainBinding` for type-safe view access.
- **Demo:** After 11 rolls, the first roll disappears from the top.

## How to Run
1. Download the APK from the submission
2. Install it on any Android device/emulator running Android 16.0 or higher

## External Resources
- https://developer.android.com/codelabs/basic-android-kotlin-compose-add-images#0

## Screenshots
<img width="872" height="919" alt="image" src="https://github.com/user-attachments/assets/38b62fb6-fd4a-4d76-a092-6ecb117684e0" />

<img width="908" height="957" alt="image" src="https://github.com/user-attachments/assets/46a20ada-ea66-48f4-b8f3-bef7a3648c4e" />
