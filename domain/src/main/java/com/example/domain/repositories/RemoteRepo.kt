package com.example.domain.repositories

import com.example.domain.models.ShareDetailsModel
import com.example.domain.usecases.GetShareDetailsUseCase
import dagger.Binds
import dagger.Module
import io.reactivex.rxjava3.core.Single

interface RemoteRepo {
@Binds
    fun getShareDetails(): Single<ShareDetailsModel>
}