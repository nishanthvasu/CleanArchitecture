package com.example.data.apiservice

import com.example.data.models.ShareDataModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/share/")
    fun getSharingDetails(): Single<ShareDataModel>
}