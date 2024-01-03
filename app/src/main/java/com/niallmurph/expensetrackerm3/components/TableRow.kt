package com.niallmurph.expensetrackerm3.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
            .padding(horizontal = 16.dp)
    ){
        Text(text = label,
            style = Typography.bodyMedium,
            color = textColour
        )
        Spacer(modifier = Modifier.fillMaxWidth())
        if(hasArrow){
            Icon(painter = painterResource(id = R.drawable.ic_arrow_forward), contentDescription = "Forward chevron")
        }


    }
}