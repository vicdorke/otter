package com.github.apognu.otter.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.apognu.otter.utils.AppContext

class SplashActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    getSharedPreferences(AppContext.PREFS_CREDENTIALS, Context.MODE_PRIVATE).apply {
      when (contains("access_token")) {
        true -> Intent(this@SplashActivity, MainActivity::class.java).apply {
          flags = Intent.FLAG_ACTIVITY_NO_ANIMATION

          startActivity(this)
        }

        false -> Intent(this@SplashActivity, LoginActivity::class.java).apply {
          flags = Intent.FLAG_ACTIVITY_NO_ANIMATION

          startActivity(this)
        }
      }
    }
  }
}