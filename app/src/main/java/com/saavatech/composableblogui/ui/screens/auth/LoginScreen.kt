package com.saavatech.composableblogui.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saavatech.composableblogui.R
import com.saavatech.composableblogui.components.ButtonComponent
import com.saavatech.composableblogui.components.CustomOutlinedPasswordTextField
import com.saavatech.composableblogui.components.CustomOutlinedTextField
import com.saavatech.composableblogui.components.HeadingTextComponent
import com.saavatech.composableblogui.components.NormalTextComponent

@Composable
fun LoginScreen(){
    Surface(
        color= Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ){
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(20.dp))
            CustomOutlinedTextField(
                painterResource(id = R.drawable.email),
                stringResource(id = R.string.email)
            )
            CustomOutlinedPasswordTextField(stringResource(id = R.string.password))

            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value = "Login")
        }
    }
}


@Preview
@Composable
fun DefaultPreviewLoginScreen(){
    LoginScreen()
}