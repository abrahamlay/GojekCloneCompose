package com.abrahamlay.gojekclone.app.ui.component.home

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamlay.gojekclone.app.R
import com.abrahamlay.gojekclone.app.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState


@ExperimentalPagerApi
@Preview
@Composable
fun PaymentHomeModule() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Blue, RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        val listPaymentItem = listOf(
            PaymentItem.Coins,
            PaymentItem.Paylater,
            PaymentItem.Balance
        )
        val paymentModulesSize = listPaymentItem.size
        val pagerState = rememberPagerState(pageCount = paymentModulesSize)
        val selectedPage = mutableStateOf(pagerState.currentPage)

        PaymentIndicatorsModule(
            paymentModulesSize,
            Modifier
                .wrapContentHeight()
                .align(Alignment.CenterVertically)
                .padding(top = 24.dp),
            pagerState,
            selectedPage
        )
        PaymentContentModule(listPaymentItem, pagerState, selectedPage.value)
        PaymentModuleButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F, fill = true),
            id = R.drawable.ic_round_payment,
            buttonText = "Pay"
        )
        PaymentModuleButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F, fill = true),
            id = R.drawable.ic_round_topup,
            buttonText = "Top Up"
        )
        PaymentModuleButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F, fill = true),
            id = R.drawable.ic_round_more,
            buttonText = "Explore"
        )
    }
}

@Composable
private fun PaymentModuleButton(
    modifier: Modifier = Modifier,
    @DrawableRes id: Int = R.drawable.ic_account_circle,
    buttonText: String = "Pay"
) {
    val context = LocalContext.current
    Button(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        onClick = { Toast.makeText(context, buttonText, Toast.LENGTH_SHORT).show() },
        colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 4.dp, bottom = 8.dp)
    ) {
        Column() {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp),
                painter = painterResource(id = id),
                contentDescription = "icon"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = buttonText,
                style = text_14_bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun PaymentIndicatorsModule(
    paymentModules: Int,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    selectedPage: MutableState<Int>
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .width(16.dp)
    ) {
        for (index in 0 until paymentModules) {
            Tab(
                selected = pagerState.currentPage == index, onClick = {}
            ) {
                selectedPage.value = pagerState.currentPage
                Box(
                    modifier = Modifier
                        .height(16.dp)
                        .width(8.dp)
                        .padding(start = 4.dp, top = 2.dp, bottom = 2.dp, end = 2.dp)
                        .background(
                            color = if (pagerState.currentPage == index) Color.White else Color.LightGray,
                            RoundedCornerShape(4.dp)
                        )
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun PaymentContentModule(
    contents: List<PaymentItem>,
    rememberScrollState: PagerState,
    selectedPage: Int
) {
    VerticalPager(
        state = rememberScrollState,
        modifier = Modifier.fillMaxHeight()
    ) { page ->
        Column(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                .align(Alignment.Center)
        ) {
            contents[page].screen.invoke(
                modifier = Modifier
                    .height(70.dp)
                    .width(if (page == selectedPage) 120.dp else 100.dp)
                    .background(
                        color = if (page == selectedPage) Color.White else Color.LightGray,
                        RoundedCornerShape(8.dp)
                    ),
                isShowContent = page == selectedPage
            )
        }
    }
}


typealias ComposableFun = @Composable (modifier: Modifier, isShowContent: Boolean) -> Unit

sealed class PaymentItem(
    var icon: Int = 0,
    var title: String,
    var index: Int,
    var screen: ComposableFun
) {
    object Coins : PaymentItem(
        title = "Coins",
        index = 0,
        screen = { modifier, isShowContent -> Coins(modifier, isShowContent) })

    object Paylater :
        PaymentItem(
            title = "Paylater",
            index = 1,
            screen = { modifier, isShowContent -> Paylater(modifier, isShowContent) })

    object Balance :
        PaymentItem(
            title = "Balance",
            index = 2,
            screen = { modifier, isShowContent -> Balance(modifier, isShowContent) })
}

@Composable
fun Coins(modifier: Modifier, isShowContent: Boolean) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            if (isShowContent) {
                Text(
                    text = "Coins",
                    style = text_12_bold,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.padding( top = 2.dp),
                    text = "0",
                    style = text_14_bold,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.padding( top = 2.dp),
                    text = "Tap for details",
                    style = text_12_normal,
                    color = Green
                )
            }
        }
    }
}


@Composable
fun Paylater(modifier: Modifier, isShowContent: Boolean) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            if (isShowContent) {
                Text(
                    text = "Paylater",
                    style = text_12_bold,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.padding( top = 2.dp),
                    text = "Order now, pay by the end of month",
                    style = text_12_light,
                    color = Color.Black
                )
            }
        }
    }
}


@Composable
fun Balance(modifier: Modifier, isShowContent: Boolean) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            if (isShowContent) {
                Text(
                    text = "Balance",
                    style = text_12_bold,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.padding( top = 2.dp),
                    text = "Here is your E-wallet balance",
                    style = text_12_light,
                    color = Color.Black
                )
            }
        }
    }

}