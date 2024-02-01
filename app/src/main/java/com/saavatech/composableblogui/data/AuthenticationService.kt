package com.saavatech.composableblogui.data//package com.saavatech.composableblogui.data
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.preferencesDataStore
//import com.saavatech.composableblogui.constants.BASE_URL
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//import java.util.prefs.Preferences
//
//private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_preference")
//
//class AuthenticationService(private val context: Context) {
//    private lateinit var api: BlogApi
//
//    init {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        api = retrofit.create(BlogApi::class.java)
//    }
//
//    interface BlogApi {
//        @GET("categories.php")
//    }
//}