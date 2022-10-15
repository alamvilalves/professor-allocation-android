package com.example.professorallocation.service;

import com.example.professorallocation.model.AllocationDTO;
import com.example.professorallocation.model.AllocationRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AllocationService {
    @GET("/allocations")
    Call<List<AllocationRes>> getAll();

    @POST("/allocations/")
    Call<AllocationRes> createAllocation(@Body AllocationDTO dto);

    @GET("/allocations/{allocation_id}")
    Call<AllocationRes> getAllocationByID(@Path("allocation_id") Long id);

    @PUT("allocations/{allocation_id}")
    Call<AllocationRes> updateAllocation(
            @Path("allocation_id") Long id,
            @Body AllocationDTO dto
    );
    @DELETE("allocations/{allocation_id}")
    Call<Void> deleteAllocationById(
            @Path("allocation_id") Long id
    );
}
