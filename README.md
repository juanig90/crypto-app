# Crypto 

##  About
This is a sample Android application built to demonstrate use of Clean Architecture.

The app shows all crypto market data from [coingecko api](https://www.coingecko.com/es/api#explore-api). It does not need any API key 

## Tech stack
- [Kotlin](https://kotlinlang.org/)
- [RxJava](https://github.com/ReactiveX/RxJava) a library for composing asynchronous and event-based programs by using observable sequences.
- [Dagger 2](https://dagger.dev/dev-guide/android.html) for dependency injection
- [Retrofit](https://github.com/square/retrofit) a type-safe HTTP client for Android 
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java
- JetPack
  - Lifecycle - perform actions in response to a change in the lifecycle status of another component
  - ViewModel - to store and manage UI-related data in a lifecycle
  - Room Persistence - provides an abstraction layer over SQLite
  - Data Binding - bind UI components in layouts to data sources

## New
 Check [this branch](https://github.com/juanig90/crypto-app/tree/asynchronousFlow) out to see another version using coroutines
