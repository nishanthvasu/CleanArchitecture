package com.example.myapplication.di

import android.app.Application
import android.content.Context
import com.example.myapplication.rx.SchedulersFacade
import com.example.myapplication.rx.SchedulersProvider
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @Binds
    abstract fun providerScheduler(schedulersFacade: SchedulersFacade): SchedulersProvider
}