package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.ShareDetailsModel
import com.example.domain.usecases.GetShareDetailsUseCase
import com.example.myapplication.rx.SchedulersProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val shareUseCase: GetShareDetailsUseCase,
    val schedulers: SchedulersProvider
) : ViewModel() {

    val shareLiveData = MutableLiveData<ShareDetailsModel>()
    protected val compositeDisposable = CompositeDisposable()

    fun getShareData() {
        shareUseCase.execute()
            .subscribeOn(schedulers.io())
            .subscribe({
                it?.let {
                    shareLiveData.postValue(it)
                }
            },{

            }).let {
                compositeDisposable.add(it)
            }
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}