package me.hd.wexpt.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class AppItem(
    @SerialName("ExptId")
    var exptId: Int = 0,
    @SerialName("GroupId")
    var groupId: Int = 0,
    @SerialName("ExptSequence")
    var exptSequence: Int = 1,
    @SerialName("Priority")
    var priority: Int = 1,
    @SerialName("NeedReport")
    var needReport: Int = 0,
    @SerialName("StartTime")
    var startTime: Long = 0,
    @SerialName("EndTime")
    var endTime: Long = 0,
    @SerialName("ExptType")
    var exptType: Int = 4,
    @SerialName("SvrType")
    var svrType: Int = 1,
    @SerialName("ExptCheckSum")
    var exptCheckSum: String = "",
    @SerialName("Args")
    var args: List<Arg> = emptyList(),
) {
    @Serializable
    data class Arg(
        @SerialName("Key")
        val key: String = "",
        @SerialName("Val")
        var value: String = "",
    )

    override fun toString(): String {
        val json = Json { encodeDefaults = true }
        return json.encodeToString(this)
    }
}
