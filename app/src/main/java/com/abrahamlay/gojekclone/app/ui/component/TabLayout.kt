package com.abrahamlay.gojekclone.app.ui.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.abrahamlay.gojekclone.app.ui.theme.Green
import com.abrahamlay.gojekclone.app.ui.theme.GreenSecondary
import com.abrahamlay.gojekclone.app.ui.theme.text_14_normal
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalUnitApi
@ExperimentalPagerApi
class TabLayout {

    private val indicatorHeight = 30.dp
    private val indicatorPathHeight = 40.dp
    private val tabLayoutHeight = 64.dp
    private val cornerRadius = 40.dp
    private val indicatorPadding = 12.dp
    private val indicatorPathPadding = 8.dp

    @Composable
    fun CustomHomeTab(
        tabs: List<TabItem>,
        pagerState: PagerState
    ) {
        val scope = rememberCoroutineScope()
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier
                .height(tabLayoutHeight)
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
                            topStart = cornerRadius,
                            bottomStart = cornerRadius
                        )
                        tabs.lastIndex -> RoundedCornerShape(
                            topEnd = cornerRadius,
                            bottomEnd = cornerRadius
                        )
                        else -> RectangleShape
                    }

                    val paddingStart = if (index == 0) indicatorPathPadding else 0.dp
                    val paddingEnd = if (index == tabs.lastIndex) indicatorPathPadding else 0.dp

                    Box {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = paddingStart, end = paddingEnd)
                                .clip(shape)
                                .height(indicatorPathHeight)
                                .background(color = GreenSecondary)
                        )
                        Text(
                            tab.title,
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.White,
                            style = text_14_normal
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
                .padding(start = indicatorPadding, end = indicatorPadding)
                .clip(RoundedCornerShape(cornerRadius))
                .height(indicatorHeight)
                .background(color = Color.White)
        ) {
            Text(
                tabs[tabIndex].title,
                modifier = Modifier.align(Alignment.Center),
                color = Green, style = text_14_normal
            )
        }
    }
}