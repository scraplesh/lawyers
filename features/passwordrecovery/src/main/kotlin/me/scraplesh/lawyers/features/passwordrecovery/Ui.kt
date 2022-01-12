package me.scraplesh.lawyers.features.passwordrecovery

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.scraplesh.lawyers.ui.theme.*

@Composable
fun PasswordRecovery() {
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
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(R.string.password_recovery_title),
                    modifier = Modifier.padding(start = 16.dp, top = 64.dp, end = 16.dp),
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = stringResource(R.string.password_recovery_subtitle),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = stringResource(R.string.password_recovery_email_label),
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
                            text = stringResource(R.string.password_recovery_enter_your_email_hint),
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
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 16.dp, top = 24.dp, end = 16.dp)
                        .fillMaxWidth(),
                    shape = Shapes.large,
                    colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryDarkBlue)
                ) {
                    Text(
                        text = stringResource(R.string.password_recovery_recover_label),
                        style = MaterialTheme.typography.button,
                        color = TextWhite
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordRecoveryPreview() {
    LawyersTheme {
        PasswordRecovery()
    }
}