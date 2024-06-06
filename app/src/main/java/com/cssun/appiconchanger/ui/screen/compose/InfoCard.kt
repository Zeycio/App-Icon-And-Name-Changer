package com.cssun.appiconchanger.ui.screen.compose

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cssun.appiconchanger.R

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun InfoCard(context: Context) {
    OutlinedCard(
        modifier = Modifier
            .padding(20.dp, 20.dp, 20.dp, 0.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.about),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.a_demo_app_that_can_change_it_s_icon_and_name_programmatically),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(R.string.zeycio),
                color = Color.Cyan,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable(onClick = {
                      openWebsite("https://github.com/Zeycio",context)
                    })
            )
        }
    }
}


private fun openWebsite(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}