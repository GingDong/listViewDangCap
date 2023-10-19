package com.example.listviewdangcap.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewdangcap.R;
import com.example.listviewdangcap.module.tool;

import java.util.ArrayList;

public class ToolAdapters extends ArrayAdapter  {
    Activity context ;
    int resource;
    ArrayList<tool> listTool ,listToolBackup,listToolFilter;

    public ToolAdapters(Activity context, int resource ,ArrayList<tool> listT) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.listTool=this.listToolBackup=listT;
    }

    @Override
    public int getCount() {
        return listTool.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View customView =inflater.inflate(this.resource,null);

        ImageView imgLogo =customView.findViewById(R.id.imgLogo);

        Button btnView =customView.findViewById(R.id.btnView);

        tool tl =this.listTool.get(position);
        imgLogo.setImageResource(tl.getLogoChucNang());
        btnView.setText(tl.getTenChucNang());

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kq = tl.getTenChucNang();
                Toast.makeText(context, kq,Toast.LENGTH_SHORT).show();
            }
        });
        return customView;
    }


    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query =charSequence.toString().toLowerCase().trim();
                if (query.length()<1){
                    listToolFilter=listToolBackup;
                }else {
                    listToolFilter=new ArrayList<>();
                    for (tool tl:listToolBackup) {

                        if (tl.getTenChucNang().toLowerCase().contains(query)){
                            listToolFilter.add(tl);
                        }

                    }
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=listToolFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listTool= (ArrayList<tool>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
