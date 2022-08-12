package com.example.android_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Person> personList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.findViewById(R.id.recyclerview);

        Person person1 = new Person("张三", "17371554705", R.drawable.head);
        Person person2 = new Person("李四", "18897979272",R.drawable.head);
        personList.add(person1);
        personList.add(person2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(personList);

        recyclerView.setAdapter(myAdapter);//适配数据和item
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private List<Person> personlist;

        public MyAdapter(List<Person> personlist) {
            this.personlist = personlist;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            //将layout打平成view对象
            MyViewHolder myViewHolder = new MyViewHolder(itemView); //将拿到的View和viewholder里的类对应起来
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            //在item一条条显示的时候要使用此方法
            Person person = personlist.get(position);
            holder.nameText.setText(person.getName());
            holder.phoneText.setText(person.getPhone());
            holder.head.setImageResource(person.getHeadID());

        }

        @Override
        public int getItemCount() {
            return personlist.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder { //这个类是用来装控件的，即item里的各个控件
            TextView nameText;
            TextView phoneText;
            ImageView head;

            public MyViewHolder(View itemView) {    //传入itemView
                super(itemView);
                this.nameText = itemView.findViewById(R.id.textView);
                this.phoneText = itemView.findViewById(R.id.textView2);
                this.head = itemView.findViewById(R.id.imageView);
            }

        }
    }
}

