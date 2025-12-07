package me.hd.wexpt.hook.hooker

import android.widget.FrameLayout
import com.highcapable.kavaref.KavaRef.Companion.asResolver
import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import me.hd.wexpt.hook.HostData.toAppClass
import me.hd.wexpt.utils.webview.WebConfig
import me.hd.wexpt.utils.webview.WebJsApi
import java.net.URL

object SettingHooker : YukiBaseHooker() {
    private class WebViewWrapper private constructor(private val webView: Any) {
        companion object {
            fun get(iWebView: Any): WebViewWrapper {
                return WebViewWrapper(iWebView)
            }
        }

        fun addJavascriptInterface(obj: Any, tag: String) {
            webView.asResolver().firstMethod {
                name = "addJavascriptInterface"
                parameters(Any::class, String::class)
                superclass()
            }.invoke(obj, tag)
        }

        fun loadDataWithBaseURL(
            baseUrl: String?,
            data: String,
            mimeType: String = "text/html",
            encoding: String = "UTF-8",
            historyUrl: String? = null
        ) {
            webView.asResolver().firstMethod {
                name = "loadDataWithBaseURL"
                parameters(String::class, String::class, String::class, String::class, String::class)
                superclass()
            }.invoke(baseUrl, data, mimeType, encoding, historyUrl)
        }
    }

    override fun onHook() {
        "com.tencent.mm.ui.widget.MMWebView".toAppClass().resolve().firstMethod {
            name = "loadUrl"
            parameters(String::class)
        }.hook {
            before {
                val url = args(0).cast<String>()
                if (URL(url).host == URL(WebConfig.getUrl()).host) {
                    val webView = instance<FrameLayout>()
                    val webViewWrapper = WebViewWrapper.get(webView)
                    webViewWrapper.addJavascriptInterface(WebJsApi(), "WExpt")
                    webViewWrapper.loadDataWithBaseURL("file:///android_asset/setting/", WebConfig.getHtml())
                    resultNull()
                }
            }
        }
    }
}
