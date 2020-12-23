package com.kardusinfo.katalogfilm.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kardusinfo.katalogfilm.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {


        private static Retrofit retrofit;
        private static Gson gson;

        public static Retrofit getRetrofit() {
            gson=new GsonBuilder()
                    .create();

            if (retrofit==null){
                retrofit=new Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

}
