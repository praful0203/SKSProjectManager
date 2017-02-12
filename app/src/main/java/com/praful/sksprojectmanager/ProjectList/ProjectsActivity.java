package com.praful.sksprojectmanager.ProjectList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.praful.sksprojectmanager.R;

public class ProjectsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static final String[] job_id={"Job ID :101","Job ID:\t102","Job ID:\t103","Job ID:\t104","JobID:105","Job ID:106","Job ID:107","Job ID:108","Job ID:109","Job ID:110","Job ID:111","Job ID:112"};
    private static final String[] created_by={"Created By:Paarshtouch","Created By:Praful","Created By:AneshKumar","Created By:Paarshtouch","Created By:Dharmesh","Created By:Sharyu","Created By:Paarshtouch","Created By:Praful","Created By:AneshKumar","Created By:Paarshtouch","Created By:Dharmesh","Created By:Sharyu"};
    TextView txtJobId,txtCreatedBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(job_id,created_by);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        txtJobId = (TextView)findViewById(R.id.txtJobId);
        txtCreatedBy = (TextView)findViewById(R.id.txtCreatedBy);

    }

}
