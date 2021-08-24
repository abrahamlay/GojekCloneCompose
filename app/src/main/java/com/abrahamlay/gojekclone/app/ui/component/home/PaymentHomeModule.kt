package com.abrahamlay.gojekclone.app.ui.component.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamlay.gojekclone.app.ui.theme.Blue


@Preview
@Composable
fun PaymentHomeModule() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Blue, RoundedCornerShape(16.dp))
    ) {

    }
}