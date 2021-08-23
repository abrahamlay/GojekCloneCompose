package com.abrahamlay.gojekclone.app.ui.component

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int = 0, var title: String, var screen: ComposableFun){
    object Home:TabItem(title = "Home", screen = { HomeScreen() })
    object Promo:TabItem(title = "Promos", screen = { PromoScreen() })
    object Order:TabItem(title = "Orders", screen = { OrderScreen() })
    object Chat:TabItem(title = "Chat", screen = { ChatScreen() })
}