package com.example.apiconnectionpractice.data.model.user


import com.google.gson.annotations.SerializedName

data class UsersModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("_meta")
    val meta: MetaModel? = MetaModel(),
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("per_page")
    val perPage: Int? = 0,
    @SerializedName("support")
    val support: SupportModel? = SupportModel(),
    @SerializedName("total")
    val total: Int? = 0,
    @SerializedName("total_pages")
    val totalPages: Int? = 0
)