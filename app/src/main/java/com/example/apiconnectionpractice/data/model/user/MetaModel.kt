package com.example.apiconnectionpractice.data.model.user


import com.google.gson.annotations.SerializedName

data class MetaModel(
    @SerializedName("docs_url")
    val docsUrl: String? = "",
    @SerializedName("features")
    val features: List<String?>? = listOf(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("powered_by")
    val poweredBy: String? = "",
    @SerializedName("template_gallery")
    val templateGallery: String? = "",
    @SerializedName("upgrade_cta")
    val upgradeCta: String? = "",
    @SerializedName("upgrade_url")
    val upgradeUrl: String? = ""
)