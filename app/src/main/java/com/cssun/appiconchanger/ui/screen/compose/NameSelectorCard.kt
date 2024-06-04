package com.cssun.appiconchanger.ui.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cssun.appiconchanger.R

@Composable
fun NameSelectorCard(
    stringOptions: List<Int>,
    onStringSelected: (Int?) -> Unit,
    modifier: Modifier = Modifier,
    selectedString: Int
) {
    OutlinedCard(modifier = Modifier.padding(20.dp, 10.dp, 20.dp, 10.dp)) {
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.select_the_name),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                stringOptions.forEach { stringResId ->
                    StringOption(
                        stringResId = stringResId,
                        isSelected = selectedString == stringResId,
                        onStringSelected = {
                            onStringSelected(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun StringOption(
    stringResId: Int,
    isSelected: Boolean,
    onStringSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onStringSelected(stringResId) }
                .background(
                    color = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                    else Color.Transparent
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(id = stringResId))
        }
    }
}