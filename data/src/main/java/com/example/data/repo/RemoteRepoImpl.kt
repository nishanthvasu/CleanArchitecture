package com.example.data.repo

import com.example.data.apiservice.ApiService
import com.example.data.mappers.ShareMappper
import com.example.domain.models.ShareDetailsModel
import com.example.domain.repositories.RemoteRepo
import dagger.Provides
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val shareMapper: dagger.Lazy<ShareMappper>) : RemoteRepo {

    override fun getShareDetails(): Single<ShareDetailsModel> {
        return  apiService.getSharingDetails()
            .map {
                shareMapper.get().toShareDetails(it)
            }
    }
}