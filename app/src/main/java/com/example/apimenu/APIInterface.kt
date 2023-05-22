package com.example.apimenu

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("products")
    fun getProductData() : Call<MyData>
}