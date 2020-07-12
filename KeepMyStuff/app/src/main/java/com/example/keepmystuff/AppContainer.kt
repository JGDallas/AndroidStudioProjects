package com.example.keepmystuff

import android.os.Parcel
import android.os.Parcelable

// Container of objects shared across the whole app
class AppContainer {

    // Since you want to expose userRepository out of the container, you need to satisfy
    // its dependencies as you did before
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://learnsqlscripting.com")
        .build()
        .create(LoginService::class.java)

    class Retrofit {
        private  val Builder = this.hashCode()
    }

    private val remoteDataSource = UserRemoteDataSource(retrofit)
    private val localDataSource = UserLocalDataSource()

    // userRepository is not private; it'll be exposed
    val userRepository = UserRepository(localDataSource, remoteDataSource)
    val loginViewModelFactory = LoginViewModelFactory(userRepository)

    class LoginActivity() : Activity(), Parcelable {

        private lateinit var loginViewModel: LoginViewModel

        constructor(parcel: Parcel) : this() {

        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Gets LoginViewModelFactory from the application instance of AppContainer
            // to create a new LoginViewModel instance
            val appContainer = (application as MyApplication).appContainer
            loginViewModel = appContainer.loginViewModelFactory.create()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<LoginActivity> {
            override fun createFromParcel(parcel: Parcel): LoginActivity {
                return LoginActivity(parcel)
            }

            override fun newArray(size: Int): Array<LoginActivity?> {
                return arrayOfNulls(size)
            }
        }
    }
}