package com.cssun.appiconchanger.ui.screen.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cssun.appiconchanger.R


@SuppressLint("UnrememberedMutableState")
@Composable
fun IconSelectorCard(
    onIconSelected: (Int?) -> Unit,
    iconOptions: List<Int>,
    modifier: Modifier = Modifier,
    selectedIconRes: Int
) {
    OutlinedCard(
        modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 10.dp)
    ) {
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.select_the_icon),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            IconRow(iconOptions = iconOptions,
                selectedIconResId = selectedIconRes,
                onIconSelected = {
                    onIconSelected(it)
                }
            )
        }
    }
}

@Composable
fun IconRow(
    iconOptions: List<Int>,
    selectedIconResId: Int?,
    onIconSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(iconOptions) { iconResId ->
            IconItem(
                iconResId = iconResId,
                isSelected = iconResId == selectedIconResId,
                onIconSelected = onIconSelected
            )
        }
    }
}

@Composable
fun IconItem(
    iconResId: Int,
    isSelected: Boolean,
    onIconSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier.padding(8.dp)
    ) {
        Box(modifier = Modifier
            .clickable { onIconSelected(iconResId) }
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                else Color.Transparent,
            )) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier
                    .padding(40.dp, 10.dp)
                    .size(21.dp)
            )
        }
    }
}