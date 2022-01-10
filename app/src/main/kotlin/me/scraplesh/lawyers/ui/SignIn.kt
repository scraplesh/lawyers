package me.scraplesh.lawyers.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import me.scraplesh.lawyers.R
import me.scraplesh.lawyers.ui.theme.BackgroundGrey
import me.scraplesh.lawyers.ui.theme.ButtonBackgroundFb
import me.scraplesh.lawyers.ui.theme.ButtonBackgroundVk
import me.scraplesh.lawyers.ui.theme.ButtonBorderGoogle
import me.scraplesh.lawyers.ui.theme.LawyersTheme
import me.scraplesh.lawyers.ui.theme.PrimaryDarkBlue
import me.scraplesh.lawyers.ui.theme.PrimaryLightBlue
import me.scraplesh.lawyers.ui.theme.Shapes
import me.scraplesh.lawyers.ui.theme.TextGrey
import me.scraplesh.lawyers.ui.theme.TextWhite

@Composable
fun SignIn() {
  val contentScrollState = rememberScrollState()
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(contentScrollState)
  ) {
    Text(
      text = stringResource(R.string.sign_in_label),
      modifier = Modifier.padding(start = 16.dp, top = 30.dp, end = 16.dp),
      style = MaterialTheme.typography.h1
    )
    Text(
      text = stringResource(R.string.greeting_subtitle),
      modifier = Modifier.padding(start = 16.dp, end = 16.dp),
      style = MaterialTheme.typography.body1
    )
    Text(
      text = stringResource(R.string.email_label),
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
          text = stringResource(R.string.enter_your_email_hint),
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
      text = stringResource(R.string.password_label),
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
          text = stringResource(R.string.enter_your_password_hint),
          color = TextGrey,
          style = MaterialTheme.typography.body1
        )
      },
      trailingIcon = {
        IconButton(onClick = { passwordVisibilityState.value = !passwordVisibilityState.value }) {
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
      text = stringResource(R.string.forgot_your_password_message),
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
        text = stringResource(R.string.sign_in_label),
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
        text = stringResource(R.string.or_sign_in_via),
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

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
  LawyersTheme {
    SignIn()
  }
}