package android.pass.mirshadaliapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.pass.mirshadaliapp.databinding.SplashScreenActivityBinding
import com.onesignal.OneSignal
import com.onesignal.OneSignal.setNotificationOpenedHandler

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: SplashScreenActivityBinding = SplashScreenActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.splash_screen_activity)

        setnotification()



        Handler().postDelayed({
            startActivity(Intent(this, WebViewActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)


    }

    private fun setnotification() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId("0cbfe077-f31a-4b05-aec6-afe927d5061d")
       setNotificationOpenedHandler {
           startActivity(Intent(this, WebViewActivity::class.java))
       }
        OneSignal.promptForPushNotifications()

    }
}