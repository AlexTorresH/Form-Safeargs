package com.example.communication_2_fragments.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val name: String,
    val lastName: String,
    val age: Int

): Parcelable