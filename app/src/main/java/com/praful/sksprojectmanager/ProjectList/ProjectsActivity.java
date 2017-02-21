package com.praful.sksprojectmanager.ProjectList;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.praful.sksprojectmanager.R;

public class ProjectsActivity extends AppCompatActivity {

    private Context ct;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String[] job_id={"101","102","103","104","105","106","107","108","109","110","111","112"};
    private static final String[] created_by={"Paarshtouch","Praful","AneshKumar","Paarshtouch","Dharmesh","Sharyu","Paarshtouch","Praful","AneshKumar","Paarshtouch","Dharmesh","Sharyu"};
    TextView txtJobId,txtCreatedBy;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        GestureDetector mGestureDetector;
        AdapterView.OnItemClickListener mListener;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(job_id,created_by);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        txtJobId = (TextView)findViewById(R.id.TxJobid);
        txtCreatedBy = (TextView)findViewById(R.id.TxCreatedBy);



    }

}
