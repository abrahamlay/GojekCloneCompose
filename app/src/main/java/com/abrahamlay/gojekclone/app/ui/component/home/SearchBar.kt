package com.abrahamlay.gojekclone.app.ui.component.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.abrahamlay.gojekclone.app.R
import com.abrahamlay.gojekclone.app.ui.theme.Black
import com.abrahamlay.gojekclone.app.ui.theme.Grey
import com.abrahamlay.gojekclone.app.ui.theme.text_14_bold


@Preview
@Composable
fun SearchBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .height(32.dp)
                .padding(end = 16.dp)
                .widthIn(310.dp, Dp.Infinity)
                .background(Grey, RoundedCornerShape(40.dp))
                .border(1.dp, Black, RoundedCornerShape(40.dp))
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search_icon"
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp),
                text = "Find services, food, or places",
                style = text_14_bold,
                color = Black
            )
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp)
                .width(36.dp),
            painter = painterResource(id = R.drawable.ic_account_circle),
            contentDescription = "account_circle"
        )
    }
}