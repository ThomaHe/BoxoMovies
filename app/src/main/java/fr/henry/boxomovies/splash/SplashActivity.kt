package fr.henry.boxomovies.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import fr.henry.boxomovies.R
import fr.henry.boxomovies.main.MainActivity

class SplashActivity : AppCompatActivity() {

    private val splashTimer = 3000L // 3 seconds
    private lateinit var mHandler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mHandler = Handler()

        mHandler.postDelayed({
            goToMainActivity()
        },splashTimer)
    }

    private fun goToMainActivity(){

        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        startActivity(mainActivityIntent)
        finish()
    }
}
