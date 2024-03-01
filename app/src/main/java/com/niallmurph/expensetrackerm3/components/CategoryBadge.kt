package com.niallmurph.expensetrackerm3.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niallmurph.expensetrackerm3.models.Category

@Composable
fun CategoryBadge(category: Category){
    Surface(
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 2.dp),
        shape = RoundedCornerShape(6.dp),
        color = category.colour.copy(alpha = 0.25f)
    ) {
        Text(
            text = category.name,
            modifier = Modifier
                .padding(vertical = 2.dp, horizontal = 6.dp),
            color = category.colour,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

//comment to push change