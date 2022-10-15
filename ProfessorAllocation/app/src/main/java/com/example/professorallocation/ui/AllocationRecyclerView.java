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
import com.example.professorallocation.model.AllocationRes;
import com.example.professorallocation.service.AllocationService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationRecyclerView extends AppCompatActivity {

    //DepartmentService retrofit = RetrofitConfig.newInstance().departmentService();
    private RecyclerView rvList;
    private AllocationAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation_recycler_view);

        AllocationService service = RetrofitConfig
                .newInstance()
                .allocationService();

        adapter = new AllocationAdapter(new ArrayList<>());
        getAllAllocations(service);

        rvList = findViewById(R.id.rvAllocationList);
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvList.setAdapter(adapter);
    }
    protected void getAllAllocations(AllocationService service) {
        final LoaddingDialog dialog = new LoaddingDialog(this);
        dialog.startDialog();
        service.getAll().enqueue(
                new Callback<List<AllocationRes>>() {
                    @Override
                    public void onResponse(Call<List<AllocationRes>> call, Response<List<AllocationRes>> response) {
                        List<AllocationRes> lista = response.body();
                        adapter.configureAllocations(lista);
                        dialog.dismissDialog();
                        //for (DepartmentRes item : list) {
                            //Log.i(">>>", item.getId() + "->" + item.getName());
                            /*
                            for (AllocationRes prof : item.getAllocations()) {
                                Log.i(">>>", prof.getName());
                            }
                            */
                        //}
                    }

                    @Override
                    public void onFailure(Call<List<AllocationRes>> call, Throwable t) {
                        dialog.dismissDialog();
                        Toast.makeText(getApplicationContext(), "Erro de Requisição", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
