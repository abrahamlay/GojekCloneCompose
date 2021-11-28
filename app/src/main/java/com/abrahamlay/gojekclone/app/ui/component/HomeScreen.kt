package com.abrahamlay.gojekclone.app.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.abrahamlay.gojekclone.app.ui.component.home.PaymentHomeModule
import com.abrahamlay.gojekclone.app.ui.component.home.SearchBar
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalUnitApi
@Preview(showBackground = false, showSystemUi = false)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        SearchBar()
        PaymentHomeModule()
    }
}
