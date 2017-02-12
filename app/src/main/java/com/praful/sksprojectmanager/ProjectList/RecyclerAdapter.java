package com.praful.sksprojectmanager.ProjectList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.praful.sksprojectmanager.R;

/**
 * Created by prafu on 12-02-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String[] job_id,created_by;
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout,parent,false);
        RecyclerViewHolder rec_holder = new RecyclerViewHolder(view);
        return rec_holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.Tx_jobid.setText(job_id[position]);
        holder.Tx_createdby.setText(created_by[position]);
    }


    @Override
    public int getItemCount() {
        return job_id.length;
    }
    public RecyclerAdapter(String[] job_id,String[] created_by)
    {
        this.job_id = job_id;
        this.created_by = created_by;
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView Tx_jobid,Tx_createdby;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            Tx_jobid = (TextView)itemView.findViewById(R.id.txtJobId);
            Tx_createdby = (TextView)itemView.findViewById(R.id.txtCreatedBy);
        }
    }
}
