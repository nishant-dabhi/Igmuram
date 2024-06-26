# Igmuram - Native Android Stories and Feed APK

## Description
Igmuram is a native Android application designed to display stories and feeds, providing users with an immersive social media experience similar to popular platforms like Instagram. The app features a user-friendly interface for browsing and interacting with stories and feeds seamlessly.

## Screenshots
<img src="https://github.com/nishant-dabhi/Igmuram/assets/101393352/61c13493-2940-431f-8a15-afebff4a76e7" height="440">
<img src="https://github.com/nishant-dabhi/Igmuram/assets/101393352/b85190fa-042e-44de-9343-a6b61334fd2a" height="440">
<img src="https://github.com/nishant-dabhi/Igmuram/assets/101393352/e63dc49d-ed89-491f-8e87-efbb040e0fc7" height="440">



## Features
- **Stories Section**: Enjoy a visually appealing interface with a horizontal list of user stories. Each story is represented by a rounded profile picture, allowing users to tap and view stories effortlessly.
  
- **Feed Section**: Explore a diverse range of content categorized into "Hot" and "Top" feeds. Users can navigate between different feed sections to discover trending and popular content.

- **Interactive Story Viewer**: Dive into stories with an interactive viewer that provides a seamless experience. Users can navigate through stories, with an animated progress bar indicating story duration. Additionally, manual navigation options enable users to control story playback.

- **Home Screen Sections**:
  - **Horizontal List**: The home screen features a horizontal list, resembling the Instagram story section. This list is implemented using a horizontal RecyclerView, with each item designed as a CardView. Each CardView displays a rounded profile picture along with the user's username.
  
  - **Scrollable Feed Section**: Below the horizontal list, users can scroll through various feeds uploaded by users. This feed section is implemented using a vertical RecyclerView, with each item designed as a CardView. Each CardView represents a feed item.
  
  - **Bottom Navigation Bar**: The bottom navigation bar component allows users to navigate between "Hot" and "Top" feeds seamlessly. It is designed using a separate XML layout file, incorporating two Fragments for displaying different feed types without leaving the screen.

- **Backend Details**:
  - **MVVM Architecture**: Implemented MVVM architecture to manage code complexity and separation of concerns. This architecture promotes a clear separation between the user interface, business logic, and data handling components.
  
  - **Separate JAVA Module for API**: Developed a separate JAVA module for handling API requests and responses. This modular approach ensures reusability and ease of integration into other projects. Additionally, unit tests are written to validate API responses, ensuring reliability and robustness.
  
  - **Imgur API Integration**: Utilized the Imgur API to fetch stories, users, "Hot" feed, and "Top" feed data. This integration provides access to a wide range of multimedia content, enriching the user experience.
  
  - **Libraries Used**: Leveraged popular Android libraries such as Retrofit for handling API requests, Coil for image loading and caching, OkHttp for network operations, etc. These libraries simplify development tasks and enhance app performance.

## Installation
1. Clone this repository.
2. Navigate to the project directory.
3. Open the project in Android Studio.
4. Connect your Android device or start an emulator.
5. Build and run the application on your device/emulator.

## Usage
- **Story Viewing**: Simply tap on a user's profile picture to view their story. Swipe left or right to navigate between stories. The animated progress bar at the top indicates the duration of each story, automatically advancing to the next story upon completion.
  
- **Feed Exploration**: Navigate between "Hot" and "Top" feeds to explore different content categories. Scroll through the feed to discover new and interesting posts.

## Credits
- This app utilizes Kotlin: [Kotlin](https://kotlinlang.org/)
  - also uses Retrofit: [Retrofit](https://square.github.io/retrofit/)
