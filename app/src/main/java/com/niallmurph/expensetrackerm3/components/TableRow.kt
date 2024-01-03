package com.niallmurph.expensetrackerm3.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.niallmurph.expensetrackerm3.R
import com.niallmurph.expensetrackerm3.ui.theme.Destructive
import com.niallmurph.expensetrackerm3.ui.theme.TextPrimary
import com.niallmurph.expensetrackerm3.ui.theme.Typography

@Composable
fun TableRow(label : String, hasArrow : Boolean = false, isDestructive : Boolean = false){

    val textColour = if(isDestructive) Destructive else TextPrimary

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = label,
            style = Typography.bodyMedium,
            color = textColour
        )
        if(hasArrow){
            Icon(painter = painterResource(id = R.drawable.ic_arrow_forward), contentDescription = "Forward chevron")
        }


    }
}