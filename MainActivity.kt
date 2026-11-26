package com.siddique.voterlist

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {
    @Suppress("SetJavaScriptEnabled", "DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val web = WebView(this)
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.settings.allowFileAccess = true
        web.settings.allowContentAccess = true
        web.settings.allowFileAccessFromFileURLs = true
        web.settings.allowUniversalAccessFromFileURLs = true

        web.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                try {
                    val jsonText = assets.open("voters.json").bufferedReader().use { it.readText() }
                    val jsCode = """
                        (function() {
                            try {
                                var raw = $jsonText;
                                var list = Array.isArray(raw) ? raw : (raw.voters || raw.data || raw.records || Object.values(raw).find(Array.isArray) || []);
                                voters = list;
                                document.getElementById('count').textContent = list.length + ' জন';
                                render(list.slice(0, 100));
                            } catch (e) {
                                document.getElementById('count').textContent = 'JSON Error: ' + e.message;
                            }
                        })();
                    """.trimIndent()
                    view?.evaluateJavascript(jsCode, null)
                } catch (e: Exception) {
                    val errMsg = e.message?.replace("'", "") ?: "File missing"
                    view?.evaluateJavascript("document.getElementById('count').textContent = 'Asset Error: $errMsg';", null)
                }
            }
        }

        setContentView(web)
        web.loadUrl("file:///android_asset/index.html")
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        val web = (window.decorView.findViewById(android.R.id.content) as? android.view.ViewGroup)
            ?.getChildAt(0) as? WebView
        if (web?.canGoBack() == true) web.goBack() else super.onBackPressed()
    }
}
