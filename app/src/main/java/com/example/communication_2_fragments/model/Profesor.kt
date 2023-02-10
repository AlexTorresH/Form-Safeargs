package com.example.communication_2_fragments.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profesor(
    val name : String
) : Parcelable
