package com.don.linkedin_test.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by gideon on 25,March,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
public interface ApiInterface {
    //get PERSON
    //https://api.linkedin.com/v1/people/~:(id,first-name,picture-url,email-address)?format=json
    @GET("v1/people/~:(id,first-name,picture-url,email-address)")
    Call<Person> getLinkedInPerson(@Header("Authorization") String authorization,
                               @Query("format") String format);






}
