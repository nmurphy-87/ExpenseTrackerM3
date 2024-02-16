package com.niallmurph.expensetrackerm3.components

import android.annotation.SuppressLint
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.niallmurph.expensetrackerm3.R
import com.niallmurph.expensetrackerm3.ui.theme.Destructive
import com.niallmurph.expensetrackerm3.ui.theme.TextPrimary
import com.niallmurph.expensetrackerm3.ui.theme.Typography

@SuppressLint("SuspiciousIndentation")
@Composable
fun TableRow(
    label: String ? = null,
    modifier: Modifier = Modifier,
    hasArrow: Boolean = false,
    isDestructive: Boolean = false,
    detailContent: (@Composable RowScope.() -> Unit)? = null,
    content: (@Composable RowScope.() -> Unit)? = null
) {

    val textColour = if (isDestructive) Destructive else TextPrimary

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(label != null){
            Text(
                text = label,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp),
                style = Typography.bodyMedium,
                color = textColour
            )
        }
        if (hasArrow) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_forward),
                contentDescription = "Forward chevron",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)
            )
        }
        if(detailContent != null){
            detailContent()
        }
        if(content != null) {
            content()
        }
    }
}