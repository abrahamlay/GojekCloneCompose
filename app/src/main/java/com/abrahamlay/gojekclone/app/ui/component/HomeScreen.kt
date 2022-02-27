package com.abrahamlay.gojekclone.app.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.abrahamlay.gojekclone.app.ui.component.home.BottomSheetListMenu
import com.abrahamlay.gojekclone.app.ui.component.home.ListMenuHomeModule
import com.abrahamlay.gojekclone.app.ui.component.home.PaymentHomeModule
import com.abrahamlay.gojekclone.app.ui.component.home.SearchBarModule
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalFoundationApi
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
        val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
        BottomSheetListMenu(bottomState,
            sheetContent = {
                ListMenuHomeModule(bottomState, true)
            }) {
            SearchBarModule()
            PaymentHomeModule()
            ListMenuHomeModule(bottomState, false)
        }
    }
}
