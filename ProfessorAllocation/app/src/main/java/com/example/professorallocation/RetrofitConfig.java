package com.example.professorallocation;

import com.example.professorallocation.service.DepartmentService;
import com.example.professorallocation.service.ProfessorService;

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

    public DepartmentService departmentService(){
        return retrofit.create(DepartmentService.class);
    }
    public ProfessorService professorService(){
        return retrofit.create(ProfessorService.class);
    }
}
