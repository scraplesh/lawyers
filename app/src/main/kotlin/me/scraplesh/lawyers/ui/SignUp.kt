package me.scraplesh.lawyers.ui

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.scraplesh.lawyers.R
import me.scraplesh.lawyers.ui.theme.BackgroundGrey
import me.scraplesh.lawyers.ui.theme.LawyersTheme
import me.scraplesh.lawyers.ui.theme.PrimaryDarkBlue
import me.scraplesh.lawyers.ui.theme.Shapes
import me.scraplesh.lawyers.ui.theme.TextBlack
import me.scraplesh.lawyers.ui.theme.TextGrey
import me.scraplesh.lawyers.ui.theme.TextWhite

@Composable
fun SignUp() {
  val contentScrollState = rememberScrollState()
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(contentScrollState)
  ) {
    Text(
      text = stringResource(R.string.sign_up_label),
      modifier = Modifier.padding(start = 16.dp, top = 30.dp, end = 16.dp),
      style = MaterialTheme.typography.h1
    )
    Text(
      text = stringResource(R.string.greeting_subtitle),
      modifier = Modifier.padding(start = 16.dp, end = 16.dp),
      style = MaterialTheme.typography.body1
    )
    Text(
      text = stringResource(R.string.you_label),
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
          text = stringResource(R.string.client_label),
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
      text = stringResource(R.string.phone_number_label),
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
          text = stringResource(R.string.enter_your_phone_number_hint),
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
        text = stringResource(R.string.sign_up_label),
        style = MaterialTheme.typography.button,
        color = TextWhite
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
  LawyersTheme {
    SignUp()
  }
}