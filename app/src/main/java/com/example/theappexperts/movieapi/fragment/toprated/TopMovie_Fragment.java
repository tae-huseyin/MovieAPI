package com.example.theappexperts.movieapi.fragment.toprated;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.theappexperts.movieapi.MessageEvent;
import com.example.theappexperts.movieapi.MovieApplication;
import com.example.theappexperts.movieapi.R;
import com.example.theappexperts.movieapi.model.topratedmovie.MovieList;
import com.example.theappexperts.movieapi.model.topratedmovie.Result;
import com.example.theappexperts.movieapi.services.RequestInterface;
import com.example.theappexperts.movieapi.util.constant.API_LIST;
import com.example.theappexperts.movieapi.util.constant.RecyclerItemClickListener;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.theappexperts.movieapi.services.ConnectionService.BackendService;

public class TopMovie_Fragment extends Fragment{

    RecyclerView rvMovieList;
    RequestInterface requestInterface;
    //List<MovieList> movieLists;

    public TopMovie_Fragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        requestInterface = BackendService();

        requestInterface.getMovies(API_LIST.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())//Scheduler.newThread()
//
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {

                        Log.i("tag",  "got list");
                        rvMovieList.setAdapter(new TopRatedAdapter( result.getResults(), R.layout.top_rated_list, getContext()));
                    }
                });

        return inflater.inflate(R.layout.fragment_top_movie_, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        rvMovieList = (RecyclerView)view.findViewById(R.id.rvList);
        rvMovieList.setLayoutManager(new LinearLayoutManager(getContext()));

        //https://stackoverflow.com/a/26196831
        rvMovieList.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), rvMovieList ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        Log.i("tag",  "item " + position);

                        EventBus.getDefault().post(new MessageEvent("Hello everyone!"));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

    }
}

//CompositeDisposable compositeDisposable;
// Inflate the layout for this fragment
//compositeDisposable = new CompositeDisposable();
//compositeDisposable.add(); where you get data

//in destroy
//        if(compositeDisposable != null || compositeDisposable.isDisposed())
//        {
//            compositeDisposable.dispose();
//            compositeDisposable.clear();
//        }

