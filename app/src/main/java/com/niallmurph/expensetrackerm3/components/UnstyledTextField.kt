package com.niallmurph.expensetrackerm3.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.niallmurph.expensetrackerm3.ui.theme.Primary
import com.niallmurph.expensetrackerm3.ui.theme.TextPrimary

@Composable
fun UnstyledBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(4.dp)
        .defaultMinSize(minWidth = 80.dp, minHeight = 40.dp)
        .wrapContentHeight(align = Alignment.CenterVertically),
    textStyle: TextStyle,
    cursorBrush: Brush = SolidColor(Primary),
    keyboardOptions: KeyboardOptions
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = textStyle.merge(
            TextStyle(
                color = TextPrimary,
                fontSize = 16.sp
            )
        ),
        keyboardOptions = keyboardOptions,
        cursorBrush = cursorBrush
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnstyledDefaultTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(4.dp)
        .defaultMinSize(minWidth = 80.dp, minHeight = 40.dp)
        .wrapContentHeight(align = Alignment.CenterVertically),
    placeholder : String = "",
    textStyle: TextStyle,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = textStyle,
        placeholder = {
            Text(text = placeholder)
        },
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            textColor = TextPrimary,
            cursorColor = TextPrimary,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}