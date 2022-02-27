package com.abrahamlay.gojekclone.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.abrahamlay.gojekclone.app.ui.component.TabItem
import com.abrahamlay.gojekclone.app.ui.component.TabLayout
import com.abrahamlay.gojekclone.app.ui.theme.AppComposeTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalUnitApi
@ExperimentalPagerApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppComposeTheme {
                viewModel.fetchMovie()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeComponent()
                }
            }
        }
    }

    @ExperimentalFoundationApi
    @Preview
    @ExperimentalCoroutinesApi
    @Composable
    fun HomeComponent() {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            val tabs = listOf(
                TabItem.Home,
                TabItem.Promo,
                TabItem.Order,
                TabItem.Chat
            )
            val pagerState = rememberPagerState(pageCount = tabs.size)
            TabLayout().CustomHomeTab(tabs, pagerState)
            TabLayout().TabContent(tabs = tabs, pagerState = pagerState)
        }
    }

}