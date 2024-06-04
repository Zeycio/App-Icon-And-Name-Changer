package com.cssun.appiconchanger.ui.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cssun.appiconchanger.R

@Composable
fun AppPreviewCard(iconResId: Int, strgId: Int) {
    OutlinedCard(
        modifier = Modifier
            .padding(20.dp, 10.dp, 20.dp, 10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.app_preview),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
                .align(Alignment.Start)
        )
        OutlinedCard(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Box(
                modifier = Modifier.background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
            ) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(10.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Text(
            text = stringResource(id = strgId),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(15.dp))
    }
}