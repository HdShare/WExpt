package me.hd.wexpt.utils.wrapper

import com.highcapable.kavaref.KavaRef.Companion.asResolver
import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import me.hd.wexpt.hook.HostData.appClassLoader

class MMKVWrapper private constructor(private val mmkv: Any) {
    companion object {
        private fun mmkvWithID(mmapID: String): Any {
            return "com.tencent.mmkv.MMKV".toClass(appClassLoader).resolve().firstMethod {
                name = "mmkvWithID"
                parameters(String::class)
            }.invoke(mmapID)!!
        }

        fun get(name: String): MMKVWrapper {
            return MMKVWrapper(mmkvWithID(name))
        }
    }

    fun putInt(key: String, value: Int) {
        mmkv.asResolver().firstMethod {
            name = "putInt"
            parameters(String::class, Int::class)
        }.invoke(key, value)
    }

    fun putString(key: String, value: String) {
        mmkv.asResolver().firstMethod {
            name = "putString"
            parameters(String::class, String::class)
        }.invoke(key, value)
    }
}
