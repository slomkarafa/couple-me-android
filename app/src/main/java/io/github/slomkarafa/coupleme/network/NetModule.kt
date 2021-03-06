package io.github.slomkarafa.coupleme.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import dagger.Module
import dagger.Provides
import io.github.slomkarafa.coupleme.BuildConfig
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.Converter
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by slomkarafa on 17.03.18.
 */

@Module
class NetModule {

    @Singleton
    @Provides
    internal fun provideConverterFactory(): Converter.Factory {
        val module = SimpleModule()

        val objectMapper = ObjectMapper()
                .registerModule(module)

        return JacksonConverterFactory.create(objectMapper)
    }

    @Singleton
    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    internal fun provideHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(logging)
                .build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}

