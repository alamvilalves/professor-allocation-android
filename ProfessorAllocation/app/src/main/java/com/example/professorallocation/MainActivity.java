package com.example.professorallocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.professorallocation.model.DepartmentDTO;
import com.example.professorallocation.model.DepartmentRes;
import com.example.professorallocation.service.DepartmentService;
import com.example.professorallocation.ui.AllocationRecyclerView;
import com.example.professorallocation.ui.DepartmentRecyclerView;

import com.example.professorallocation.model.ProfessorDTO;
import com.example.professorallocation.model.ProfessorRes;
import com.example.professorallocation.service.ProfessorService;
import com.example.professorallocation.ui.ProfessorRecyclerView;

import com.example.professorallocation.model.CourseDTO;
import com.example.professorallocation.model.CourseRes;
import com.example.professorallocation.service.CourseService;
import com.example.professorallocation.ui.CourseRecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    DepartmentService retrofit = RetrofitConfig.newInstance().departmentService();
    Button btProfessor,btDepartment,btCourse,btAllocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.getAllDepartments();

        //this.getDepartmentByID(1505L);

        /*DepartmentDTO department = new DepartmentDTO();
        department.setName("xxqXTESTE");
        this.updateDepartment(1505L,department);*/

        //this.deleteDepartmentById(1515L);

        //DepartmentDTO department = new DepartmentDTO();
        //department.setName("NovoDepartamento20220917");
        //this.createDepartment(department);
        btDepartment = findViewById(R.id.btDepartment);
        btDepartment.setOnClickListener(view -> {
            Intent telaDepartamento = new Intent(getApplicationContext(), DepartmentRecyclerView.class);
            startActivity(telaDepartamento);
        });
        btProfessor = findViewById(R.id.btProfessor);
        btProfessor.setOnClickListener(view -> {
            Intent telaProfessor = new Intent(getApplicationContext(), ProfessorRecyclerView.class);
            startActivity(telaProfessor);
        });
        btCourse = findViewById(R.id.btCourse);
        btCourse.setOnClickListener(view -> {
            Intent telaCourse = new Intent(getApplicationContext(), CourseRecyclerView.class);
            startActivity(telaCourse);
        });
        btAllocation = findViewById(R.id.btAllocation);
        btAllocation.setOnClickListener(view -> {
            Intent telaAllocation = new Intent(getApplicationContext(), AllocationRecyclerView.class);
            startActivity(telaAllocation);
        });

    }


    protected void createDepartment(DepartmentDTO department){
        retrofit.createDepartment(department).enqueue(new Callback<DepartmentRes>() {
            @Override
            public void onResponse(Call<DepartmentRes> call, Response<DepartmentRes> response) {
                DepartmentRes department = response.body();
                Log.i(">>>", department.getId() + "->" + department.getName());
            }

            @Override
            public void onFailure(Call<DepartmentRes> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro de Requisição",Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void getDepartmentByID(Long id){
        retrofit.getDepartmentByID(id).enqueue(new Callback<DepartmentRes>() {
            @Override
            public void onResponse(Call<DepartmentRes> call, Response<DepartmentRes> response) {
                DepartmentRes department =  response.body();
                Log.i(">>>", department.getId() + "->" + department.getName());
            }

            @Override
            public void onFailure(Call<DepartmentRes> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro de Requisição",Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void updateDepartment(Long id, DepartmentDTO department){
        retrofit.updateDepartment(id,department).enqueue(new Callback<DepartmentRes>() {
            @Override
            public void onResponse(Call<DepartmentRes> call, Response<DepartmentRes> response) {
                DepartmentRes department = response.body();
                Log.i(">>>", department.getId() + "->" + department.getName());
                Toast.makeText(getApplicationContext(),"Departamento Salvo",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<DepartmentRes> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro de Requisição",Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void deleteDepartmentById(Long id){
        retrofit.deleteDepartmentById(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getApplicationContext(),"Departamento Excluído",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro na Exclusão",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
