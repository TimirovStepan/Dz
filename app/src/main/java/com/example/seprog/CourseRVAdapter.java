package com.example.seprog;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {


    private final ArrayList<CourseModal> courseModalArrayList;
    private final Context context;


    public CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CourseModal modal = courseModalArrayList.get(position);
        holder.courseTitleTV.setText(modal.getCourseTitle());
        holder.courseNumberTV.setText(modal.getCourseNumber());



        holder.itemView.setOnClickListener(v -> {


            Intent i = new Intent(context, UpdateCourseActivity.class);


            i.putExtra("Pozicia", modal.getCourseTitle());
            i.putExtra("Kolicestvo", modal.getCourseNumber());



            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {

        return courseModalArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView courseTitleTV;
        private final TextView courseNumberTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseTitleTV = itemView.findViewById(R.id.idTVCourseName);
            courseNumberTV = itemView.findViewById(R.id.idTVCourseDescription);

        }
    }
}
