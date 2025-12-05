package me.hd.wexpt.utils.webview

object WebConfig {
    fun getUrl(): String {
        return "http://wexpt.weixin.com/"
    }

    fun getHtml(): String {
        return """
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>WExpt</title>
            </head>

            <body>
                <div id="expt-container">
                </div>

                <div>
                    <button onclick="save()">保存</button>
                </div>

                <script>
                    const exptConfigs = [
                        {
                            name: '62语音输入',
                            key: 'clicfg_chatting_voice_input',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '63实况发送',
                            key: 'clicfg_chatting_c2c_live_send_v4',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '64半屏通知',
                            key: 'clicfg_notification_half_screen_chat_enable_new',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '65多选分析聊天',
                            key: 'clicfg_yuanbao_analyze_chat_records_entrance',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '65多选分析聊天允许单聊',
                            key: 'clicfg_yuanbao_analyze_private_chat',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '65聊天长按菜单总结',
                            key: 'clicfg_yuanbao_summary_entrance',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '65元宝制作头像',
                            key: 'clicfg_yuanbao_making_avatar_enable',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '66新设置页',
                            key: 'clicfg_new_setting',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '66新设置页搜索',
                            key: 'clicfg_setting_search',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        },
                        {
                            name: '66批量撤回',
                            key: 'clicfg_batch_revoke_msg_enable',
                            trueVal: "MQ==",
                            falseVal: "MA=="
                        }
                    ];

                    function save() {
                        const args = exptConfigs.map(config => ({
                            Key: config.key,
                            Val: document.getElementById(config.key).checked ? config.trueVal : config.falseVal
                        }));
                        console.log('保存配置:', args);
                        if (window.WExpt && WExpt.putExptArgs) {
                            try {
                                WExpt.putExptArgs(JSON.stringify(args));
                                alert('保存成功');
                            } catch (error) {
                                alert('保存出错: 调用失败');
                            }
                        } else {
                            alert('保存出错: 接口异常');
                        }
                    }

                    document.addEventListener('DOMContentLoaded', function () {
                        const container = document.getElementById('expt-container');
                        exptConfigs.forEach(config => {
                            const exptDiv = document.createElement('div');
                            exptDiv.innerHTML = `
                                <input type="checkbox" id="${'$'}{config.key}">
                                <label for="${'$'}{config.key}">${'$'}{config.name}</label>
                            `;
                            container.appendChild(exptDiv);
                        });
                    });
                </script>
            </body>

            </html>
        """.trimIndent()
    }
}
