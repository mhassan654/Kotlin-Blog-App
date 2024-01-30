package com.saavatech.composableblogui.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCornerImage(
    resourceId: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    shape: RoundedCornerShape = RoundedCornerShape(4.dp) // Adjust the corner radius as needed
) {
    val shapes = Shapes(
        small = shape,
        medium = shape,
        large = shape
    )

    Image(
        painter = painterResource(id = resourceId),
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxWidth()
//            .height(200.dp) // Set the height as needed
            .clip(shape = shapes.medium)
    )
}