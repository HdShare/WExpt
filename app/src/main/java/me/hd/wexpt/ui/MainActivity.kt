package me.hd.wexpt.ui

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            TextView(this).apply {
                text = buildString {
                    appendLine("Welcome to WExpt!")
                    appendLine("1. LSPosed 启用模块")
                    appendLine("2. 微信中打开 wexpt.weixin.com")
                }
            }
        )
    }
}
