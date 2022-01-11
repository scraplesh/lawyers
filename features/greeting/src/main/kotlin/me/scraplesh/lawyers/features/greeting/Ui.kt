package me.scraplesh.lawyers.features.greeting

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.scraplesh.lawyers.ui.theme.BackgroundGrey
import me.scraplesh.lawyers.ui.theme.LawyersTheme
import me.scraplesh.lawyers.ui.theme.PrimaryDarkBlue
import me.scraplesh.lawyers.ui.theme.Shapes
import me.scraplesh.lawyers.ui.theme.TextWhite

@Composable
fun Greeting() {
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
                                .padding(end = 16.dp)
                                .height(48.dp)
                                .width(48.dp),
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
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(R.string.greeting_title),
                    modifier = Modifier.padding(start = 16.dp, top = 64.dp, end = 16.dp),
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = stringResource(R.string.greeting_subtitle),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.body1
                )
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = Shapes.large,
                    colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryDarkBlue)
                ) {
                    Text(
                        text = stringResource(R.string.greeting_sign_in_label),
                        style = MaterialTheme.typography.button,
                        color = TextWhite
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {}) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .background(color = BackgroundGrey, shape = Shapes.large)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_global),
                            modifier = Modifier.align(Alignment.Center),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                    }
                    Text(
                        text = stringResource(R.string.greeting_choose_language_label),
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.body1
                    )
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            modifier = Modifier.align(Alignment.CenterEnd),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LawyersTheme {
        Greeting()
    }
}