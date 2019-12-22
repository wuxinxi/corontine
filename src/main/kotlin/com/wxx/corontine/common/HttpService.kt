package com.wxx.corontine.common;

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * @author TangRen
 * @create 2019-12-22 20:01
 * @TODO:  http
 */

object HttpService{
    val service by lazy {
        val retrofit= Retrofit.Builder()
                .baseUrl("http://www.imooc.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(Service::class.java)
    }
}

interface Service{
    @GET
    fun getLogo(@Url fileUrl:String):Call<ResponseBody>
}