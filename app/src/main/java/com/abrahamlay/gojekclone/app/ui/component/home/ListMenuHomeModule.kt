package com.abrahamlay.gojekclone.app.ui.component.home

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abrahamlay.gojekclone.app.R
import com.abrahamlay.gojekclone.app.ui.theme.Black
import com.abrahamlay.gojekclone.app.ui.theme.text_14_normal
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun ListMenuHomeModule(bottomState: ModalBottomSheetState) {
    val listMenu = listOf<MenuItem>(
        MenuItem("GoRide", R.drawable.ic_menu_goride),
        MenuItem("GoCar", R.drawable.ic_menu_gocar),
        MenuItem("GoFood", R.drawable.ic_menu_gofood),
        MenuItem("GoSend", R.drawable.ic_menu_gosend),
        MenuItem("GoMart", R.drawable.ic_menu_gomart),
        MenuItem("GoPulsa", R.drawable.ic_menu_gopulsa),
        MenuItem("GoPlay", R.drawable.ic_menu_goplay),
        MenuItem("More", R.drawable.ic_menu_more),
    )

    Box(
        modifier = Modifier
            .height(200.dp)
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(cells = GridCells.Fixed(4)) {
            items(listMenu) {
                ItemMenu(it, bottomState)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun ItemMenu(menuItem: MenuItem, bottomState: ModalBottomSheetState) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .clickable(role = Role.Button) {
                if (menuItem.name == "More")
                    runBlocking {
                        coroutineScope {
                            launch {
                                bottomState.show()
                            }
                        }
                    } else Toast
                    .makeText(context, menuItem.name, Toast.LENGTH_SHORT)
                    .show()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(56.dp)
                .padding(8.dp),
            painter = painterResource(id = menuItem.resIcon),
            contentDescription = "icon"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = menuItem.name,
            style = text_14_normal,
            color = if (isSystemInDarkTheme()) Color.White else Black,
            textAlign = TextAlign.Center
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun BottomSheetListMenu() {
    val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetContent = {
            ListMenuHomeModule(bottomState)
        }
    ) {
        ListMenuHomeModule(bottomState)
    }
}

class MenuItem(val name: String, @DrawableRes val resIcon: Int)