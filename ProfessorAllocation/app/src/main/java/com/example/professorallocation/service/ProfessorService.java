package com.example.professorallocation.service;

import com.example.professorallocation.model.ProfessorDTO;
import com.example.professorallocation.model.ProfessorRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfessorService {
    @GET("/professors")
    Call<List<ProfessorRes>> getAll();

    @POST("/professors/")
    Call<ProfessorRes> createProfessor(@Body ProfessorDTO dto);

    @GET("/professors/{professor_id}")
    Call<ProfessorRes> getProfessorByID(@Path("professor_id") Long id);

    @PUT("professors/{professor_id}")
    Call<ProfessorRes> updateProfessor(
            @Path("professor_id") Long id,
            @Body ProfessorDTO dto
    );
    @DELETE("professors/{professor_id}")
    Call<Void> deleteProfessorById(
            @Path("professor_id") Long id
    );
}
