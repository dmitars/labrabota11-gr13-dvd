package com.task.fbresult.retrofit;

import com.task.fbresult.db.dao.PeopleOnDutyDao;
import com.task.fbresult.model.GraphicResult;
import com.task.fbresult.model.HourlyGraphicResult;
import com.task.fbresult.model.PeopleOnDuty;
import com.task.fbresult.model.PostModel;

import java.util.List;
import java.util.Observable;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebService {


    @POST("stripes")
    io.reactivex.Observable<GraphicResult> getFullGraphic(
            @Body PostModel model
    );

    @POST("stripesHourly")
    io.reactivex.Observable<HourlyGraphicResult> getHourlyGraphics(
            @Body PostModel list
            );


    static WebService create() {
        //"http://app-server.hopto.org:8081"
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.0.199:8081")
                .build();

        return retrofit.create(WebService.class);
    }

}
