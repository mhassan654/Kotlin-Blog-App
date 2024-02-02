package com.saavatech.composableblogui.data//package com.saavatech.composableblogui.data
//
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.saavatech.composableblogui.constants.BASE_URL
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val AUTH_TOKEN_NAME = "auth_preference"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name=AUTH_TOKEN_NAME)

class AuthenticationService(private val context: Context) {
    private val client = OkHttpClient()

    private val apiBaseUrl = BASE_URL

    var isLoggedin by mutableStateOf(false)
        private set

    suspend fun login(email: String, password: String){
        val requestedBody = FormBody.Builder()
            .add("email",email)
            .add("password",password)
            .build()

        val request = Request.Builder()
            .url("$apiBaseUrl/login")
            .post(requestedBody)
            .build()

//        try {
//            val response = client.newCall()
//        }
    }

}