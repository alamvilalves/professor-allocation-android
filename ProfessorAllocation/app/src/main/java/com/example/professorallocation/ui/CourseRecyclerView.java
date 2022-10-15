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
import com.example.professorallocation.model.CourseRes;
import com.example.professorallocation.service.CourseService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRecyclerView extends AppCompatActivity {

    //DepartmentService retrofit = RetrofitConfig.newInstance().departmentService();
    private RecyclerView rvList;
    private CourseAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_recycler_view);

        CourseService service = RetrofitConfig
                .newInstance()
                .courseService();

        adapter = new CourseAdapter(new ArrayList<>());
        getAllCourses(service);

        rvList = findViewById(R.id.rvCourseList);
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvList.setAdapter(adapter);
    }
    protected void getAllCourses(CourseService service) {
        final LoaddingDialog dialog = new LoaddingDialog(this);
        dialog.startDialog();
        service.getAll().enqueue(
                new Callback<List<CourseRes>>() {
                    @Override
                    public void onResponse(Call<List<CourseRes>> call, Response<List<CourseRes>> response) {
                        List<CourseRes> lista = response.body();
                        adapter.configureCourses(lista);
                        dialog.dismissDialog();
                        //for (DepartmentRes item : list) {
                            //Log.i(">>>", item.getId() + "->" + item.getName());
                            /*
                            for (CourseRes prof : item.getCourses()) {
                                Log.i(">>>", prof.getName());
                            }
                            */
                        //}
                    }

                    @Override
                    public void onFailure(Call<List<CourseRes>> call, Throwable t) {
                        dialog.dismissDialog();
                        Toast.makeText(getApplicationContext(), "Erro de Requisição", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
