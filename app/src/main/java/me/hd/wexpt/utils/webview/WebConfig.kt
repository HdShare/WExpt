package me.hd.wexpt.utils.webview

import com.highcapable.yukihookapi.hook.factory.injectModuleAppResources
import me.hd.wexpt.hook.HostData

object WebConfig {
    fun getUrl(): String {
        return "http://wexpt.weixin.com/"
    }

    fun getHtml(): String {
        HostData.appContext.injectModuleAppResources()
        val assetManager = HostData.appContext.assets
        val bytes = assetManager.open("setting/index.html").readBytes()
        return bytes.toString(Charsets.UTF_8)
    }
}
