package com.cssun.appiconchanger.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cssun.appiconchanger.data.AppData
import com.cssun.appiconchanger.data.iconOptions
import com.cssun.appiconchanger.data.stringOptions
import com.cssun.appiconchanger.logic.changeAppIcon
import com.cssun.appiconchanger.logic.getPkgName
import com.cssun.appiconchanger.ui.screen.compose.AppPreviewCard
import com.cssun.appiconchanger.ui.screen.compose.CardButton
import com.cssun.appiconchanger.ui.screen.compose.IconSelectorCard
import com.cssun.appiconchanger.ui.screen.compose.InfoCard
import com.cssun.appiconchanger.ui.screen.compose.NameSelectorCard
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Composable
fun MainScreen(context: Context) {
    val dataStore = AppData(context)
    val scope = rememberCoroutineScope()
    val intImg = dataStore.getIcon.collectAsState(initial = 0)
    val intStr = dataStore.getName.collectAsState(initial = 0)
    val intImgTemp = mutableIntStateOf(intImg.value)
    val intStrTemp = mutableIntStateOf(intStr.value)
    Surface(
        modifier = Modifier.wrapContentSize(),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            val scrollState = rememberScrollState()
            val infoVisibility = remember { mutableStateOf(false) }
            OutlinedCard(
                modifier = Modifier
                    .padding(20.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(.9999f)
                    .align(Alignment.Center),
            ) {
                Box(
                    modifier = Modifier.wrapContentHeight()
                ) {
                    Column(
                        modifier = Modifier.verticalScroll(scrollState),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "Icon And Name Changer",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier
                                    .clickable(onClick = {infoVisibility.value = !infoVisibility.value})
                                    .align(Alignment.CenterHorizontally)
                            )
                        AnimatedVisibility(visible = infoVisibility.value) {
                            InfoCard(context = context)
                        }
                        IconSelectorCard(
                            onIconSelected = {
                                intImgTemp.intValue = it!!
                            },
                            iconOptions = iconOptions,
                            selectedIconRes = intImgTemp.intValue
                        )
                        NameSelectorCard(
                            onStringSelected = {
                                intStrTemp.intValue = it!!
                            },
                            stringOptions = stringOptions, selectedString = intStrTemp.intValue
                        )
                        AnimatedVisibility(visible = intImgTemp.intValue != 0 && intStrTemp.intValue != 0) {
                            Box {
                                AppPreviewCard(
                                    iconResId = intImgTemp.intValue,
                                    strgId = intStrTemp.intValue
                                )
                            }
                        }
                        CardButton(text = "Apply") {
                            if (intImgTemp.intValue != 0 && intStrTemp.intValue != 0) {
                                scope.launch {
                                    dataStore.setIcon(intImgTemp.intValue)
                                    dataStore.setName(intStrTemp.intValue)
                                }
                                changeAppIcon(
                                    context,
                                    getPkgName(intImgTemp.intValue, intStrTemp.intValue)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


