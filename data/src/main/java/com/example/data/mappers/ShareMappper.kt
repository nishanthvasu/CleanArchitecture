package com.example.data.mappers

import com.example.data.models.ShareDataModel
import com.example.domain.models.ShareDetailsModel

import javax.inject.Inject

/**
 * A mapper to map the ShareDataModel from server to ShareDetailsModel in a presentable form.
 */
class ShareMappper @Inject constructor() {

    fun toShareDetails(shareModelServer: ShareDataModel): ShareDetailsModel {
        return ShareDetailsModel(
            shareModelServer.shareMessage ?: "",
            shareModelServer.shareUrl ?: "",
            shareModelServer.source ?: ""
        )
    }
}