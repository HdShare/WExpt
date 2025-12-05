package me.hd.wexpt.hook

import com.highcapable.yukihookapi.YukiHookAPI.configs
import com.highcapable.yukihookapi.YukiHookAPI.encase
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.wexpt.BuildConfig

@InjectYukiHookWithXposed(entryClassName = "Entry")
object HookEntry : IYukiHookXposedInit {
    override fun onInit() = configs {
        debugLog { tag = BuildConfig.APP_NAME }
        isDebug = false
        isEnableDataChannel = false
    }

    override fun onHook() = encase {
    }
}
