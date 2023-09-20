package com.catnip.mymenufood.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(
    val food : String,
    val country: String,
    val foodDesc : String,
    val profilePictUrl : String
) : Parcelable
