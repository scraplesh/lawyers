package me.scraplesh.lawyers.features.authorization

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import me.scraplesh.lawyers.ui.theme.BackgroundGrey
import me.scraplesh.lawyers.ui.theme.LawyersTheme
import me.scraplesh.lawyers.ui.theme.PrimaryDarkBlue
import me.scraplesh.lawyers.ui.theme.TextGrey
import me.scraplesh.lawyers.ui.theme.ButtonBackgroundFb
import me.scraplesh.lawyers.ui.theme.ButtonBackgroundVk
import me.scraplesh.lawyers.ui.theme.ButtonBorderGoogle
import me.scraplesh.lawyers.ui.theme.PrimaryLightBlue
import me.scraplesh.lawyers.ui.theme.Shapes
import me.scraplesh.lawyers.ui.theme.TextBlack
import me.scraplesh.lawyers.ui.theme.TextWhite

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
                stringResource(R.string.authorization_sign_in_label),
                stringResource(R.string.authorization_sign_up_label)
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

@Composable
fun SignIn() {
    val contentScrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(contentScrollState)
    ) {
        Text(
            text = stringResource(R.string.authorization_sign_in_label),
            modifier = Modifier.padding(start = 16.dp, top = 30.dp, end = 16.dp),
            style = MaterialTheme.typography.h1
        )
        Text(
            text = stringResource(R.string.authorization_subtitle),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = stringResource(R.string.authorization_email_label),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
            style = MaterialTheme.typography.body1
        )
        val emailTextState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = emailTextState.value,
            onValueChange = { emailTextState.value = it },
            modifier = Modifier
                .padding(start = 16.dp, top = 10.dp, end = 16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(R.string.authorization_enter_your_email_hint),
                    color = TextGrey,
                    style = MaterialTheme.typography.body1
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            maxLines = 1,
            textStyle = MaterialTheme.typography.body1,
            shape = Shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BackgroundGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Text(
            text = stringResource(R.string.authorization_password_label),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
            style = MaterialTheme.typography.body1
        )
        val passwordTextState = remember { mutableStateOf(TextFieldValue()) }
        val passwordVisibilityState = remember { mutableStateOf(false) }
        TextField(
            value = passwordTextState.value,
            onValueChange = { passwordTextState.value = it },
            modifier = Modifier
                .padding(start = 16.dp, top = 10.dp, end = 16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(R.string.authorization_enter_your_password_hint),
                    color = TextGrey,
                    style = MaterialTheme.typography.body1
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibilityState.value = !passwordVisibilityState.value
                }) {
                    Icon(
                        painter = painterResource(
                            id = if (passwordVisibilityState.value) R.drawable.ic_eye else R.drawable.ic_eye_slash
                        ),
                        contentDescription = "",
                        tint = Color.Unspecified
                    )
                }
            },
            visualTransformation = if (passwordVisibilityState.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            maxLines = 1,
            textStyle = MaterialTheme.typography.body1,
            shape = Shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BackgroundGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Text(
            text = stringResource(R.string.authorization_forgot_your_password_message),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            style = MaterialTheme.typography.body1,
            color = PrimaryLightBlue
        )
        Button(
            onClick = {},
            modifier = Modifier
                .padding(start = 16.dp, top = 24.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = Shapes.large,
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryDarkBlue)
        ) {
            Text(
                text = stringResource(R.string.authorization_sign_in_label),
                style = MaterialTheme.typography.button,
                color = TextWhite
            )
        }
        Row(
            modifier = Modifier
                .padding(start = 16.dp, top = 32.dp, end = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .wrapContentWidth()
                    .weight(1f),
                color = BackgroundGrey
            )
            Text(
                text = stringResource(R.string.authorization_or_sign_in_via),
                modifier = Modifier
                    .wrapContentWidth()
                    .weight(1f),
                style = MaterialTheme.typography.body1,
                color = TextGrey
            )
            Divider(
                modifier = Modifier
                    .wrapContentWidth()
                    .weight(1f),
                color = BackgroundGrey
            )
        }
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(48.dp)
                    .background(color = Color.White, shape = CircleShape)
                    .border(width = 1.dp, color = ButtonBorderGoogle, shape = CircleShape)

            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .size(48.dp)
                    .background(color = ButtonBackgroundFb, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_facebook),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(48.dp)
                    .background(color = ButtonBackgroundVk, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_vk),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Composable
fun SignUp() {
    val contentScrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(contentScrollState)
    ) {
        Text(
            text = stringResource(R.string.authorization_sign_up_label),
            modifier = Modifier.padding(start = 16.dp, top = 30.dp, end = 16.dp),
            style = MaterialTheme.typography.h1
        )
        Text(
            text = stringResource(R.string.authorization_subtitle),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = stringResource(R.string.authorization_you_label),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
            style = MaterialTheme.typography.body1
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 10.dp, end = 16.dp)
                .background(color = BackgroundGrey, shape = Shapes.large)
                .clickable {},
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.height(60.dp)) {
                Text(
                    text = stringResource(R.string.authorization_client_label),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .align(Alignment.CenterStart),
                    color = TextBlack,
                    style = MaterialTheme.typography.body1
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                tint = Color.Unspecified
            )
        }
        Text(
            text = stringResource(R.string.authorization_email_label),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
            style = MaterialTheme.typography.body1
        )
        val emailTextState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = emailTextState.value,
            onValueChange = { emailTextState.value = it },
            modifier = Modifier
                .padding(start = 16.dp, top = 10.dp, end = 16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(R.string.authorization_enter_your_email_hint),
                    color = TextGrey,
                    style = MaterialTheme.typography.body1
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            maxLines = 1,
            textStyle = MaterialTheme.typography.body1,
            shape = Shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BackgroundGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Text(
            text = stringResource(R.string.authorization_phone_number_label),
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
            style = MaterialTheme.typography.body1
        )
        val phoneNumberTextState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = phoneNumberTextState.value,
            onValueChange = { phoneNumberTextState.value = it },
            modifier = Modifier
                .padding(start = 16.dp, top = 10.dp, end = 16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(R.string.authorization_enter_your_phone_number_hint),
                    color = TextGrey,
                    style = MaterialTheme.typography.body1
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            maxLines = 1,
            textStyle = MaterialTheme.typography.body1,
            shape = Shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = BackgroundGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Button(
            onClick = {},
            modifier = Modifier
                .padding(start = 16.dp, top = 24.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = Shapes.large,
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryDarkBlue)
        ) {
            Text(
                text = stringResource(R.string.authorization_sign_up_label),
                style = MaterialTheme.typography.button,
                color = TextWhite
            )
        }
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun AuthorizationPreview() {
    LawyersTheme {
        Authorization()
    }
}