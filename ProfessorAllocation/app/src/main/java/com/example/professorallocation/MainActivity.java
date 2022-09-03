package com.example.professorallocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.professorallocation.model.DepartmentRes;
import com.example.professorallocation.service.DepartmentService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    DepartmentService retrofit = RetrofitConfig.newInstance().departmentService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getAllDepartments();
    }
    protected void getAllDepartments() {
        retrofit.getAll().enqueue(
                new Callback<List<DepartmentRes>>() {
                    @Override
                    public void onResponse(Call<List<DepartmentRes>> call, Response<List<DepartmentRes>> response) {
                        List<DepartmentRes> list = response.body();
                        for (DepartmentRes item : list) {
                            Log.i(">>>", item.getName());
                            /*
                            for (ProfessorRes prof : item.getProfessors()) {
                                Log.i(">>>", prof.getName());
                            }
                            */
                        }
                    }

                    @Override
                    public void onFailure(Call<List<DepartmentRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro de Requisição", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}