package com.example.gmailcloneui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmailcloneui.R
import com.example.gmailcloneui.accounts
import com.example.gmailcloneui.models.Account

/**
 * Created by Patrick Adutwum on 15/10/2022.
 */

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>){
    Dialog(onDismissRequest = { openDialog.value = false},
        properties = DialogProperties(dismissOnClickOutside = false)
    ) {
        AccountsDialogUi(openDialog = openDialog)
    }
}

@Composable
fun AccountsDialogUi(modifier: Modifier = Modifier, openDialog: MutableState<Boolean>){
    Card() {
        Column(
            modifier
                .background(color = Color.White)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) {
            Row(modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { openDialog.value = false }
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "")
                }
                Image(painter = painterResource(R.drawable.google), contentDescription = "",
                    modifier
                        .size(30.dp)
                        .weight(2.0f))
            }
            AccountItem(account = accounts[0])
            Row(modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)
                ) {
                    Text(text = "Google Account",
                        modifier.padding(8.dp),
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier.width(10.dp))
            }
            Divider(modifier.padding(16.dp))
            Column() {
                AccountItem(account = accounts[1])
                AccountItem(account = accounts[2])
            }
            AddAccount(icon = Icons.Outlined.PersonAddAlt, title = "Add Another Account")
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Accounts on this device")
            Divider(modifier.padding(bottom = 16.dp, top = 16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(5.dp),
                    shape = CircleShape,
                    backgroundColor = Color.Blue
                ) {

                }
                Text(text = "Terms of Service")
            }
        }
    }
}

@Composable
fun AccountItem(account: Account){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)) {
        if (account.icon != null){
            Image(painter = painterResource(id = account.icon), contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
            )
        }else{
            Card(modifier = Modifier
                .padding(end = 8.dp)
                .size(30.dp)
                .clip(CircleShape),
                backgroundColor = Color.Gray,
                elevation = 8.dp,
            ) {
                Text(text = account.username[0].toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2.0f)
                .padding(start = 16.dp, bottom = 16.dp)) {
            Text(text = account.username, fontWeight = FontWeight.SemiBold)
            Text(text = account.email )
        }
        Text(text = when{ account.unReadMails > 99 ->  "${account.unReadMails}+" else -> "${account.unReadMails}"} , modifier = Modifier.padding(end = 16.dp))
    }
}

@Composable
fun AddAccount(icon: ImageVector, title: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp)
    ) {
        IconButton(onClick = { /*TODO*/ },
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp, start = 8.dp),
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountsDialogUiPreview(){
    AccountsDialogUi(openDialog = mutableStateOf(false))
}