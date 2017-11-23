package com.example.theappexperts.movieapi.services;

import com.example.theappexperts.movieapi.model.topratedmovie.Result;
import com.example.theappexperts.movieapi.util.constant.API_LIST;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by TheAppExperts on 23/11/2017.
 */

public interface RequestInterface {

    @GET(API_LIST.API_TOP_RATED_MOVIE_LIST)
    Observable<Result> getMovies(@Query("api_key") String apiKey);

    //@GET(API_LIST.API_TOP_RATED_MOVIE_DETAIL)
    //Observable<Result> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
