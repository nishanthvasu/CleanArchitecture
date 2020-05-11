package com.example.domain.usecases

import com.example.domain.models.ShareDetailsModel
import com.example.domain.repositories.RemoteRepo
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetShareDetailsUseCase @Inject constructor(val apiRepo: RemoteRepo):
    SingleUseCase<ShareDetailsModel> {

    override fun execute(): Single<ShareDetailsModel> {
        return apiRepo.getShareDetails()

    }
}