package com.cssun.appiconchanger.ui.screen.compose

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cssun.appiconchanger.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconPicker(onIconSelected: (Int?) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIconResId by remember { mutableStateOf<Int?>(null) }
    val iconOptions = listOf(
        R.drawable.round_swap_horiz_24,
        R.drawable.round_terminal_24,
        R.drawable.round_wallet_24
    )


    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = "", // No text displayed but still have a blank space need to find a workaround
            onValueChange = { },
            readOnly = true,
            label = { Text("Select an icon") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            leadingIcon = {
                selectedIconResId?.let {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            modifier = Modifier
                .wrapContentWidth()
                .menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            iconOptions.forEach { iconResId ->
                DropdownMenuItem(
                    text = {
                        Icon(
                            painter = painterResource(id = iconResId),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    onClick = {
                        selectedIconResId = iconResId
                        expanded = false
                        onIconSelected(selectedIconResId)
                    }
                )
            }
        }
    }
}

