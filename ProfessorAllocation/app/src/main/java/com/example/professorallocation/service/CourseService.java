package com.example.professorallocation.service;

import com.example.professorallocation.model.CourseDTO;
import com.example.professorallocation.model.CourseRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CourseService {
    @GET("/courses")
    Call<List<CourseRes>> getAll();

    @POST("/courses/")
    Call<CourseRes> createCourse(@Body CourseDTO dto);

    @GET("/courses/{course_id}")
    Call<CourseRes> getCourseByID(@Path("course_id") Long id);

    @PUT("courses/{course_id}")
    Call<CourseRes> updateCourse(
            @Path("course_id") Long id,
            @Body CourseDTO dto
    );
    @DELETE("courses/{course_id}")
    Call<Void> deleteCourseById(
            @Path("course_id") Long id
    );
}
