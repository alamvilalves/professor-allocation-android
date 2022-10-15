package com.example.professorallocation;

import com.example.professorallocation.service.DepartmentService;
import com.example.professorallocation.service.ProfessorService;
import com.example.professorallocation.service.CourseService;
import com.example.professorallocation.service.AllocationService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://professor-allocation.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RetrofitConfig newInstance(){
        return new RetrofitConfig();
    }
    public Retrofit getRetrofit(){

        return retrofit;
    }

    public DepartmentService departmentService() {
        return retrofit.create(DepartmentService.class);
    }
    public ProfessorService professorService(){
        return retrofit.create(ProfessorService.class);
    }
    public CourseService courseService(){
        return retrofit.create(CourseService.class);
    }
    public AllocationService allocationService(){
        return retrofit.create(AllocationService.class);
    }
}
