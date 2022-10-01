package com.example.professorallocation.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.example.professorallocation.R;
import com.example.professorallocation.RetrofitConfig;
import com.example.professorallocation.model.DepartmentRes;
import com.example.professorallocation.service.DepartmentService;
import com.example.professorallocation.ui.DepartmentAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentRecyclerView extends AppCompatActivity {

    //DepartmentService retrofit = RetrofitConfig.newInstance().departmentService();
    private RecyclerView rvList;
    private DepartmentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_recycler_view);

        DepartmentService service = RetrofitConfig
                .newInstance()
                .departmentService();

        adapter = new DepartmentAdapter(new ArrayList<>());
        getAllDepartments(service);

        rvList = findViewById(R.id.rvDepList);
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvList.setAdapter(adapter);
    }
    protected void getAllDepartments(DepartmentService service) {
        service.getAll().enqueue(
                new Callback<List<DepartmentRes>>() {
                    @Override
                    public void onResponse(Call<List<DepartmentRes>> call, Response<List<DepartmentRes>> response) {
                        List<DepartmentRes> lista = response.body();
                        adapter.configureDepartments(lista);

                        //for (DepartmentRes item : list) {
                            //Log.i(">>>", item.getId() + "->" + item.getName());
                            /*
                            for (ProfessorRes prof : item.getProfessors()) {
                                Log.i(">>>", prof.getName());
                            }
                            */
                        //}
                    }

                    @Override
                    public void onFailure(Call<List<DepartmentRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro de Requisição", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
