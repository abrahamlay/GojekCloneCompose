package com.abrahamlay.gojekclone.app.ui.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamlay.gojekclone.app.ui.theme.Green
import com.abrahamlay.gojekclone.app.ui.theme.GreenSecondary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
class TabLayout {

    @Composable
    fun CustomHomeTab(
        tabs: List<TabItem> = listOf(
            TabItem.Home,
            TabItem.Promo,
            TabItem.Order,
            TabItem.Chat
        ),
        pagerState: PagerState
    ) {
        val scope = rememberCoroutineScope()
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            indicator = { tabPositions ->
                TabIndicator(tabs, tabPositions, pagerState.currentPage)
            },
            backgroundColor = Green
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(selected = pagerState.currentPage == index, onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }) {

                    val shape = when (index) {
                        0 -> RoundedCornerShape(
                            topStart = 16.dp,
                            bottomStart = 16.dp
                        )
                        tabs.lastIndex -> RoundedCornerShape(
                            topEnd = 16.dp,
                            bottomEnd = 16.dp
                        )
                        else -> RectangleShape
                    }

                    val paddingStart = if (index == 0) 6.dp else 0.dp
                    val paddingEnd = if (index == tabs.lastIndex) 6.dp else 0.dp

                    Box {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = paddingStart, end = paddingEnd)
                                .clip(shape)
                                .height(28.dp)
                                .background(color = GreenSecondary)
                        )
                        Text(
                            tab.title,
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }


    @Composable
    fun TabContent(
        tabs: List<TabItem>,
        pagerState: PagerState
    ) {
        HorizontalPager(state = pagerState) { page ->
            tabs[page].screen.invoke()
        }
    }

    @Composable
    private fun TabIndicator(
        tabs: List<TabItem>,
        tabPositions: List<TabPosition>,
        tabIndex: Int
    ) {
        val currentTabPosition = tabPositions[tabIndex]
        val currentTabWidth = animateDpAsState(
            targetValue = currentTabPosition.width,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
        )
        val indicatorOffset = animateDpAsState(
            targetValue = currentTabPosition.left,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.CenterStart)
                .offset(x = indicatorOffset.value)
                .width(currentTabWidth.value)
                .padding(start = 8.dp, end = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .height(24.dp)
                .background(color = Color.White)
        ) {
            Text(
                tabs[tabIndex].title,
                modifier = Modifier.align(Alignment.Center),
                color = Green
            )
        }
    }
}