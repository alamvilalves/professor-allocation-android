package com.example.professorallocation.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.professorallocation.R;
import com.example.professorallocation.RetrofitConfig;
import com.example.professorallocation.model.ProfessorRes;
import com.example.professorallocation.service.ProfessorService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorRecyclerView extends AppCompatActivity {

    //DepartmentService retrofit = RetrofitConfig.newInstance().departmentService();
    private RecyclerView rvList;
    private ProfessorAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_recycler_view);

        ProfessorService service = RetrofitConfig
                .newInstance()
                .professorService();

        adapter = new ProfessorAdapter(new ArrayList<>());
        getAllProfessors(service);

        rvList = findViewById(R.id.rvProfList);
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvList.setAdapter(adapter);
    }
    protected void getAllProfessors(ProfessorService service) {
        service.getAll().enqueue(
                new Callback<List<ProfessorRes>>() {
                    @Override
                    public void onResponse(Call<List<ProfessorRes>> call, Response<List<ProfessorRes>> response) {
                        List<ProfessorRes> lista = response.body();
                        adapter.configureProfessors(lista);

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
                    public void onFailure(Call<List<ProfessorRes>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro de Requisição", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
