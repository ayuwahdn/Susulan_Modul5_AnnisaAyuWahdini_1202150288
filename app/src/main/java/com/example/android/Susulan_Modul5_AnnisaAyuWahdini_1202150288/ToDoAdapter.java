package com.example.android.Susulan_Modul5_AnnisaAyuWahdini_1202150288;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;


public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {
    //inisialisasi variabel
    private LayoutInflater mInflater;
    private List<ListToDo> todoLists;
    int id;
    String warna;

    public ToDoAdapter(Context context, List<ListToDo> todoList) {
        mInflater = LayoutInflater.from(context); //inisiasi inflater
        this.todoLists = todoList;
    }

    //method untuk menginflate dengan class lainnya
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_to_do, parent, false);
        return new MyViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //variasi background color
        ListToDo todoList = this.todoLists.get(position);
        id = todoList.getId();
        holder.deskripsi.setText(todoList.getDekripsi()); //get value ke textView
        holder.nama.setText(todoList.getNama());
        holder.prioritas.setText(todoList.getPrioritas());
        switch (warna) {
            case "Pink":
                holder.bgColor.setBackgroundResource(R.color.colorAccent);
                break;
            case "Yellow":
                holder.bgColor.setBackgroundColor(Color.YELLOW);
                break;
            case "Gray":
                holder.bgColor.setBackgroundColor(Color.GRAY);
                break;
            case "Blue":
                holder.bgColor.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    @Override
    public int getItemCount() {

        return todoLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // class MyCiewHolder
        public TextView nama, deskripsi, prioritas;
        ConstraintLayout bgColor;


        public MyViewHolder(View view) {
            super(view);
            //menginisiasi variabel
            nama = (TextView) view.findViewById(R.id.nama);
            deskripsi = (TextView) view.findViewById(R.id.deskripsi);
            prioritas = (TextView) view.findViewById(R.id.prioritas);
            bgColor = (ConstraintLayout) view.findViewById(R.id.layout_background);
            SharedPreferences Preference = PreferenceManager.getDefaultSharedPreferences(view.getContext());
            warna = Preference.getString("chosenColor", "-1");
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // ketika di klik salah satu menu
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = todoLists.get(mPosition).toString();
            Toast.makeText(view.getContext(), nama.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}