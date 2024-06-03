package com.cssun.appiconchanger.ui.screen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cssun.appiconchanger.dataClass.infoList
import com.cssun.appiconchanger.logic.changeAppIcon
import com.cssun.appiconchanger.ui.screen.compose.IconPicker
import com.cssun.appiconchanger.ui.screen.compose.StringResourcePicker

@Composable
fun MainScreen(context: Context) {
    var intImg by remember { mutableIntStateOf(0) }
    var intStr by remember { mutableIntStateOf(0) }
    Surface(
        modifier = Modifier.wrapContentSize(),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedCard(
                modifier = Modifier
                    .fillMaxHeight(.5f)
                    .fillMaxWidth(.8f)
                    .align(Alignment.Center),

                ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Select the Icon And Name",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                    Box { IconPicker(onIconSelected = { intImg = it!! }) }
                    Box { StringResourcePicker(onStringSelected = { intStr = it!! }) }
                    Button(onClick = {
                        if (intImg != 0 && intStr != 0) {
                            changeAppIcon(context, getPkgName(intImg, intStr))
                        }
                    }) {
                        Text(text = "Set as AppIcon And Name")
                    }
                }
            }

        }
    }

}

fun getPkgName(intImg: Int, intStr: Int): String {
    for (i in infoList.indices) {
        if (infoList[i].iconImgRes == intImg && infoList[i].iconStrRes == intStr) {
            return infoList[i].packageName
        }
    }
    return ""
}