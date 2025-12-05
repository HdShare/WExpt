package me.hd.wexpt.utils.webview

import android.webkit.JavascriptInterface
import kotlinx.serialization.json.Json
import me.hd.wexpt.core.AppItem
import me.hd.wexpt.core.AppManager

class WebJsApi {
    @JavascriptInterface
    fun putExptArgs(jsonArrayStr: String) {
        val json = Json { ignoreUnknownKeys = true }
        val args = json.decodeFromString<List<AppItem.Arg>>(jsonArrayStr)
        AppManager().putAppItem(
            AppItem(
                exptId = 99999,
                args = args
            )
        )
    }
}
