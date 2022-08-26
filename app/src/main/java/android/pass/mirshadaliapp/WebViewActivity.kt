package android.pass.mirshadaliapp

import android.os.Bundle
import android.pass.mirshadaliapp.databinding.ActivityWebViewBinding
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_web_view)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //webview fun
        webview()
onBackPressed()



    }

    override fun onBackPressed() {
        val web = binding.webView

        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private fun webview() {

        val web = binding.webView
        web.webViewClient = WebViewClient()

        web.loadUrl("https://surviswala.xyz/login")
        web.setClickable(true)
        web.settings.javaScriptEnabled = true
        web.settings.setSupportZoom(true)
        web.settings.domStorageEnabled = true
        web.settings.saveFormData = true
        web.settings.allowContentAccess = true
        web.settings.allowFileAccess = true
        web.settings.allowFileAccessFromFileURLs = true
        web.settings.allowUniversalAccessFromFileURLs = true
        web.settings.setLoadWithOverviewMode(true);
        web.settings.setUseWideViewPort(true);
    }
}