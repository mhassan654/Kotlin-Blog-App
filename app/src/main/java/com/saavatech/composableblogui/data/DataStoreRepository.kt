package com.saavatech.composableblogui.data

import android.content.Context

//package com.saavatech.composableblogui.data
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.catch
//import java.io.IOException
//import java.util.prefs.Preferences
//
//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")
//
//class DataStoreRepository(context: Context) {
//
//    private object PreferencesKey {
//        val onBoardingKey = booleanPreferencesKey(name = "on_boarding_completed")
//    }
//
//    private val dataStore = context.dataStore
//
//    suspend fun saveOnBoardingState(completed: Boolean) {
//        dataStore.edit { preferences ->
//            preferences[PreferencesKey.onBoardingKey] = completed
//        }
//    }
//
//    fun readOnBoardingState(): Flow<Boolean> {
//        return dataStore.data
//            .catch { exception ->
//                if (exception is IOException) {
//                    emit(emptyPreferences())
//                } else {
//                    throw exception
//                }
//            }
//            .map { preferences ->
//                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
//                onBoardingState
//            }
//    }
//}
