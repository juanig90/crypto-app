# Crypto 

##  About
This is a sample Android application built to demonstrate use of Clean Architecture.

The app shows all crypto market data from [coingecko api](https://www.coingecko.com/es/api#explore-api). It does not need any API key 

## Tech stack
- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://developer.android.com/kotlin/coroutines) concurrency design pattern to simplify code that executes asynchronously
- [Flow](https://developer.android.com/kotlin/flow) stream of data that can be computed asynchronously
- [Dagger 2](https://dagger.dev/dev-guide/android.html) for dependency injection
- [Retrofit](https://github.com/square/retrofit) a type-safe HTTP client for Android 
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java
- JetPack
  - Lifecycle - perform actions in response to a change in the lifecycle status of another component
  - ViewModel - to store and manage UI-related data in a lifecycle
  - Room Persistence - provides an abstraction layer over SQLite
  - Data Binding - bind UI components in layouts to data sources
