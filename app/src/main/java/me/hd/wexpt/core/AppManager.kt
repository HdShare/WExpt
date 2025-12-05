package me.hd.wexpt.core

import me.hd.wexpt.utils.wrapper.ConfigWrapper
import me.hd.wexpt.utils.wrapper.MMKVWrapper

class AppManager {
    private val uin by lazy {
        ConfigWrapper.get("system_config_prefs").getUin()
    }

    private val appKeyMmkv by lazy {
        MMKVWrapper.get("${uin}_WxExptAppKeyMmkv")
    }

    private val appIdMmkv by lazy {
        MMKVWrapper.get("${uin}_WxExptAppIdMmkv")
    }

    fun putAppItem(appItem: AppItem) {
        appKeyMmkv.apply {
            appItem.args.forEach { arg ->
                putInt(arg.key, appItem.exptId)
            }
        }
        appIdMmkv.apply {
            putString(appItem.exptId.toString(), appItem.toString())
        }
    }
}
