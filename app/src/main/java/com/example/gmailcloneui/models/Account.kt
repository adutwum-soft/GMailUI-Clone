package com.example.gmailcloneui.models

/**
 * Created by Patrick Adutwum on 15/10/2022.
 */
data class Account(
    val icon: Int? = null,
    val username: String,
    val email: String,
    val unReadMails: Int
)
