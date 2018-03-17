package io.github.slomkarafa.coupleme.location

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * Created by slomkarafa on 17.03.18.
 */
interface LocationService {

    @GET("location/{username}")
    fun getUserLocation(@Path("username") username: String): Flowable<LocationDto>

    @PUT("location/{username}/{latitude}/{longitude}")
    fun putUserLocation(@Path("username") username: String,
                        @Path("latitude") latitude: String,
                        @Path("longitude") longitude: String
                        ): Completable
}