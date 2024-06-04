package com.cssun.appiconchanger.logic

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager

fun changeAppIcon(context: Context, aliasToEnable: String) {
    val pm = context.packageManager
    val aliases = listOf(
        "com.cssun.appiconchanger.alternativeAa",
        "com.cssun.appiconchanger.alternativeAb",
        "com.cssun.appiconchanger.alternativeAc",
        "com.cssun.appiconchanger.alternativeBa",
        "com.cssun.appiconchanger.alternativeBb",
        "com.cssun.appiconchanger.alternativeBc",
        "com.cssun.appiconchanger.alternativeCa",
        "com.cssun.appiconchanger.alternativeCb",
        "com.cssun.appiconchanger.alternativeCc"
    )
    try {
        pm.setComponentEnabledSetting(
            ComponentName(context, aliasToEnable),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        for (alias in aliases) {
            if (alias != aliasToEnable) {
                pm.setComponentEnabledSetting(
                    ComponentName(context, alias),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP
                )
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}