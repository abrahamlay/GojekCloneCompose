package com.abrahamlay.gojekclone.app.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@ExperimentalUnitApi
@Preview
@Composable
fun ChatScreen(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Text(text = "Chat", fontSize = TextUnit(20F, TextUnitType.Sp),modifier = Modifier.align(Alignment.Center))
    }
}