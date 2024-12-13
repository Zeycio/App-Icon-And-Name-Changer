package com.cssun.appiconchanger.data

import com.cssun.appiconchanger.R

data class AppIconInfo(
    val packageName: String,
    val iconStrRes: Int,
    val iconImgRes: Int
)
//not the most creative naming
val infoList  = listOf(
    AppIconInfo("com.cssun.appiconchanger.alternativeAa", R.string.app_nameA,R.drawable.round_swap_horiz_24),
    AppIconInfo("com.cssun.appiconchanger.alternativeAb", R.string.app_nameB,R.drawable.round_swap_horiz_24),
    AppIconInfo("com.cssun.appiconchanger.alternativeAc", R.string.app_nameC,R.drawable.round_swap_horiz_24),

    AppIconInfo("com.cssun.appiconchanger.alternativeBa", R.string.app_nameA,R.drawable.round_terminal_24),
    AppIconInfo("com.cssun.appiconchanger.alternativeBb", R.string.app_nameB,R.drawable.round_terminal_24),
    AppIconInfo("com.cssun.appiconchanger.alternativeBc", R.string.app_nameC,R.drawable.round_terminal_24),

    AppIconInfo("com.cssun.appiconchanger.alternativeCa", R.string.app_nameA,R.drawable.round_wallet_24),
    AppIconInfo("com.cssun.appiconchanger.alternativeCb", R.string.app_nameB,R.drawable.round_wallet_24),
    AppIconInfo("com.cssun.appiconchanger.alternativeCc", R.string.app_nameC,R.drawable.round_wallet_24),
)

val stringOptions = listOf(
    R.string.app_nameA,
    R.string.app_nameB,
    R.string.app_nameC
)


val iconOptions = listOf(
    R.drawable.round_swap_horiz_24,
    R.drawable.round_terminal_24,
    R.drawable.round_wallet_24
)