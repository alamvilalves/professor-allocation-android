package com.example.professorallocation.service;

import com.example.professorallocation.model.Department;
import com.example.professorallocation.model.DepartmentDTO;
import com.example.professorallocation.model.DepartmentRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DepartmentService {
    @GET("/departments")
    Call<List<DepartmentRes>> getAll();

    @POST("/departments/")
    Call<Department> createDepartment(@Body DepartmentDTO dto);

    @GET("/departments/{department_id}")
    Call<Department> getElementByID(@Path("department_id") Long id);

    @PUT("departments/{department_id}")
    Call<Department> alterar(
            @Path("department_id") Long id,
            @Body DepartmentDTO dto
    );
}
