package com.saavatech.composableblogui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.saavatech.composableblogui.R
import com.saavatech.composableblogui.enums.MainRoute
import com.saavatech.composableblogui.ui.theme.LightPrimaryContainer
import com.saavatech.composableblogui.ui.theme.PrimaryTextColor

@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 20.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(painterResource: Painter, lableValue: String){
 val text = remember {
     mutableStateOf("")
 }

    OutlinedTextField(
        modifier= Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(2.dp)),
        label = { Text(text =lableValue) } ,
        value = text.value,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = PrimaryTextColor,
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = LightPrimaryContainer,
        ),

        keyboardOptions = KeyboardOptions.Default,
        onValueChange ={
            text.value=it
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource, contentDescription = "profile icon")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedPasswordTextField(lableValue: String){
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier= Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(2.dp)),
        label = { Text(text =lableValue) } ,
        value = password.value,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            //        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = PrimaryTextColor,
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = LightPrimaryContainer,
        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange ={
            password.value=it
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.lock), contentDescription = "profile icon")
        },
        trailingIcon = {
            val iconImage = if (passwordVisibility.value)
                Icons.Filled.Visibility
            else
                Icons.Filled.VisibilityOff

            val description = if (passwordVisibility.value)
                    "Hide Password"
                        else "Show password"

            IconButton(onClick = {
                passwordVisibility.value = !passwordVisibility.value
            }) {

                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}

@Composable
fun CheckboxComponent(value:String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp)
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkState.value, onCheckedChange = { checkState.value != checkState.value })
        NormalTextComponent(value)

    }
}

@Composable
fun ButtonComponent(value: String){
   val navController = rememberNavController()
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(LightPrimaryContainer),
        onClick = { navController.navigate(MainRoute.Profile.name) }
    ) {
        Text(text = value)
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultInputPreview()
{
    Column {
        CustomOutlinedTextField(painterResource(id = R.drawable.profile), "saghsadg")
        CustomOutlinedPasswordTextField("sample label")
        CheckboxComponent("test checkbox")
        ButtonComponent("Sample Login Button")
    }
}