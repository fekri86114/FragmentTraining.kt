package com.app.fragments.ux

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (

    val name: String,
    val lastname: String,
    val age: String,
    val gender: Boolean

        ): Parcelable