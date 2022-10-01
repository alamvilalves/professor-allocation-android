package com.example.professorallocation.service;

import com.example.professorallocation.model.DepartmentDTO;
import com.example.professorallocation.model.DepartmentRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartmentService {
    @GET("/departments")
    Call<List<DepartmentRes>> getAll();

    @POST("/departments/")
    Call<DepartmentRes> createDepartment(@Body DepartmentDTO dto);

    @GET("/departments/{department_id}")
    Call<DepartmentRes> getDepartmentByID(@Path("department_id") Long id);

    @PUT("departments/{department_id}")
    Call<DepartmentRes> updateDepartment(
            @Path("department_id") Long id,
            @Body DepartmentDTO dto
    );
    @DELETE("departments/{department_id}")
    Call<Void> deleteDepartmentById(
            @Path("department_id") Long id
    );
}
