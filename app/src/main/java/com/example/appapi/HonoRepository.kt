package com.example.appapi

class HonoRepository (
    private val api : HonoApi) : SafeApiRequest()
{
    suspend fun getItems() = apiRequest {api.getItems()}
}