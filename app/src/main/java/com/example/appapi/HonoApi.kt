package com.example.appapi

import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HonoApi {
    @GET("sapi/LabelConfiguration/getLanguageList?encryption_key=7c25b4573bf3d1d45f7a131fd4a5007aa8b339f5b84a41340ff9807747f9e22abbf565bd7478d85ef28c9020306971f212588b7871817b5944288d296a6a179a866c8808ffa6dd124d8ad2da6bd9d5442fe8977457e2e06b51d8b00fb02581e1&type=android")
   suspend fun getItems(): Response<HonoItems>

    companion object{
        operator fun invoke() : HonoApi {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.honohr.com/")
                .build()
                .create(HonoApi::class.java)

        }
    }
}