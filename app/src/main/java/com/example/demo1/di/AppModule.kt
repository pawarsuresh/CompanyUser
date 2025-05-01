package com.example.demo1.di

import com.example.demo1.data.remote.ApiInterface
import com.example.demo1.data.remote.CatInterface
import com.example.demo1.data.repository.CatRepositoryImpl
import com.example.demo1.data.repository.UserDetailRepositoryImp
import com.example.demo1.data.repository.UserRepositoryImp
import com.example.demo1.domian.repository.CatRepository
import com.example.demo1.domian.repository.UserDetailRepository
import com.example.demo1.domian.repository.UserRepository
import com.example.demo1.domian.usecase.CatUseCase
import com.example.demo1.domian.usecase.GetUserDetailUseCase
import com.example.demo1.domian.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

@Provides
fun provideApiService(): ApiInterface{
    val baseurl = "https:///jsonplaceholder.typicode.com/"
    return Retrofit.Builder().baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiInterface::class.java)
    }

    @Provides
    fun provideDogApiService(): CatInterface{
        val baseurl = "https://catfact.ninja/"
        return Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CatInterface::class.java)
    }

    @Provides
    fun provaideUserRepository(apiInterface: ApiInterface): UserRepository{
        return UserRepositoryImp(apiInterface)
    }

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository) : GetUserUseCase{
        return GetUserUseCase(userRepository)
    }

    @Provides
    fun providerUserDetailRepository(apiInterface: ApiInterface) : UserDetailRepository{
        return UserDetailRepositoryImp(apiInterface)
    }

    @Provides
    fun providerGetUserDetailUseCase(userDetailRepository: UserDetailRepository) : GetUserDetailUseCase{
        return GetUserDetailUseCase(userDetailRepository)
    }

    @Provides
    fun providerGetDogResponse(dogInterface: CatInterface)  : CatRepository{
        return CatRepositoryImpl(dogInterface)
    }

    @Provides
    fun providerGetDogUseCase(dogRepository: CatRepository) : CatUseCase{
        return CatUseCase(dogRepository)
    }
}