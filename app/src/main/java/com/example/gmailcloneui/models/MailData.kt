package com.example.gmailcloneui.models

/**
 * Created by Patrick Adutwum on 14/10/2022.
 */
data class MailData(
    val mailId : Int,
    val username: String,
    val subject: String,
    val body: String,
    val timeStamp: String = "",
)
