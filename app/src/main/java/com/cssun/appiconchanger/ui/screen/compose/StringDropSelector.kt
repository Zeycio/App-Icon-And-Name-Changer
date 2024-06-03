package com.cssun.appiconchanger.ui.screen.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cssun.appiconchanger.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StringResourcePicker(onStringSelected: (Int?) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedStringResId by remember { mutableStateOf<Int?>(null) }
    val stringOptions = listOf(
        R.string.app_nameA,
        R.string.app_nameB,
        R.string.app_nameC
    )

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selectedStringResId?.let { stringResource(id = it) } ?: "",
            onValueChange = { },
            readOnly = true,
            label = { Text("Select a string") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .wrapContentWidth()
                .menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            stringOptions.forEach { stringResId ->
                DropdownMenuItem(
                    text = { Text(stringResource(id = stringResId)) },
                    onClick = {
                        selectedStringResId = stringResId
                        expanded = false
                        onStringSelected(selectedStringResId)
                    }
                )
            }
        }
    }
}

