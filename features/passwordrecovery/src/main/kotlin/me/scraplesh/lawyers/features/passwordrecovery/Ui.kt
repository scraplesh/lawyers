package me.scraplesh.lawyers.features.passwordrecovery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
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
import me.scraplesh.lawyers.ui.theme.BackgroundGrey
import me.scraplesh.lawyers.ui.theme.LawyersTheme
import me.scraplesh.lawyers.ui.theme.PrimaryDarkBlue
import me.scraplesh.lawyers.ui.theme.Shapes
import me.scraplesh.lawyers.ui.theme.TextGrey
import me.scraplesh.lawyers.ui.theme.TextWhite

@Composable
fun PasswordRecovery(navigateBack: (() -> Unit)? = null) {
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
                    IconButton(onClick = { navigateBack?.invoke() }) {
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