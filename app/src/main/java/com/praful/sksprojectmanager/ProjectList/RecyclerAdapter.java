package com.praful.sksprojectmanager.ProjectList;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.praful.sksprojectmanager.R;

/* Created by prafu on 12-02-2017.
 */

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private String[] job_id,created_by;
    private String txtJobID,txtCreatedBy;


    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout,parent,false);

        return new RecyclerViewHolder(view);
}


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.Tx_jobid.setText(job_id[position]);
        holder.Tx_createdby.setText(created_by[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DashBoardActivity.class);
                v.getContext().startActivity(intent);
            }
        });
            }


    @Override
    public int getItemCount() {
        return job_id.length;
    }

    //contructor
    RecyclerAdapter(String[] job_id, String[] created_by)
    {
        this.job_id = job_id;
        this.created_by = created_by;
    }



    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView Tx_jobid,Tx_createdby;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            Tx_jobid = (TextView)itemView.findViewById(R.id.TxJobid);
            Tx_createdby = (TextView)itemView.findViewById(R.id.TxCreatedBy);



        }

    }

}
