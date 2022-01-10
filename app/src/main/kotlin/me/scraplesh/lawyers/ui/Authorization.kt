package me.scraplesh.lawyers.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import me.scraplesh.lawyers.R
import me.scraplesh.lawyers.ui.theme.BackgroundGrey
import me.scraplesh.lawyers.ui.theme.LawyersTheme
import me.scraplesh.lawyers.ui.theme.PrimaryDarkBlue
import me.scraplesh.lawyers.ui.theme.TextGrey

@ExperimentalPagerApi
@Composable
fun Authorization() {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
          ) {
            Icon(
              painter = painterResource(R.drawable.ic_logo),
              modifier = Modifier
                .padding(end = 64.dp)
                .height(48.dp)
                .width(48.dp),
              contentDescription = "",
              tint = Color.Unspecified
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = {}) {
            Icon(
              painter = painterResource(id = R.drawable.ic_arrow_left),
              contentDescription = "",
              tint = Color.Unspecified
            )
          }
        },
        actions = {},
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
      )
    },
    content = {
      val pages = listOf(
        stringResource(R.string.sign_in_label),
        stringResource(R.string.sign_up_label)
      )
      val pagerState = rememberPagerState()
      val coroutineScope = rememberCoroutineScope()
      Column(
        modifier = Modifier.fillMaxSize()
      ) {
        ScrollableTabRow(
          selectedTabIndex = pagerState.currentPage,
          backgroundColor = Color.White,
          edgePadding = 16.dp,
          modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
          divider = {
            TabRowDefaults.Divider(
              modifier = Modifier.fillMaxWidth(),
              thickness = 1.dp,
              color = BackgroundGrey
            )
          },
          indicator = { tabPositions ->
            TabRowDefaults.Indicator(
              modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
              height = 2.dp,
              color = PrimaryDarkBlue
            )
          }
        ) {
          pages.forEachIndexed { index, title ->
            val isSelected = pagerState.currentPage == index
            Tab(
              text = {
                Text(
                  text = title,
                  style = MaterialTheme.typography.button,
                  color = if (isSelected) PrimaryDarkBlue else TextGrey
                )
              },
              selected = isSelected,
              onClick = {
                coroutineScope.launch {
                  pagerState.animateScrollToPage(index)
                }
              }
            )
          }
        }
        HorizontalPager(count = pages.size, state = pagerState) { index ->
          when (index) {
            0 -> SignIn()
            1 -> SignUp()
          }
        }
      }
    }
  )
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun AuthorizationPreview() {
  LawyersTheme {
    Authorization()
  }
}