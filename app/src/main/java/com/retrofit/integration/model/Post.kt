package com.retrofit.integration.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("message" ) var message : Message? = Message(),
    @SerializedName("status"  ) var status  : String?  = null
)
