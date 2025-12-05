package me.hd.wexpt.hook

import android.content.Context
import com.highcapable.kavaref.extension.toClass
import kotlin.properties.Delegates

object HostData {
    var appContext by Delegates.notNull<Context>()
    var appClassLoader by Delegates.notNull<ClassLoader>()

    fun init(baseContext: Context) {
        appContext = baseContext
        appClassLoader = baseContext.classLoader
    }

    fun String.toAppClass() = toClass(appClassLoader)
}
