package com.cssun.appiconchanger.logic

import com.cssun.appiconchanger.data.infoList

fun getPkgName(intImg: Int, intStr: Int): String {
    for (i in infoList.indices) {
        if (infoList[i].iconImgRes == intImg && infoList[i].iconStrRes == intStr) {
            return infoList[i].packageName
        }
    }
    return ""
}