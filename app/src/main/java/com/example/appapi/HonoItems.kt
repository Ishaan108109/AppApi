package com.example.appapi

data class HonoItems(
    val data: List<Data>,
    val result: String


)
{
    data class Data(
        val Default: Int,
        val Id: Int,
        val Language_Code: String,
        val Name: String,
        val Order: Int,
        val Short_Form: String,
        val Status: Int
    )
}