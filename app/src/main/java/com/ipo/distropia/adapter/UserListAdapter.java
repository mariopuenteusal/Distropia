package com.ipo.distropia.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ipo.distropia.R;
import com.ipo.distropia.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 21/06/2018.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder>{

    private List<User> mDataset;
    private Activity activity;
    private OnImageClickListener listener;

    public UserListAdapter(Activity context, List<User> myDataset, OnImageClickListener listener) {
        mDataset = myDataset;
        this.activity=context;
        this.listener=listener;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(v);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element


        final User mUser = mDataset.get(position);
        holder.mTextViewName.setText(mUser.getNombre());
        holder.mImage.setImageResource(R.mipmap.ic_launcher);



        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.omImageClick(mUser);
                }
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextViewName;
        public TextView mTextViewSurName;
        public TextView mTextViewAge;
        public ImageView mImage;
        public MyViewHolder(View v) {
            super(v);
            mTextViewName =(TextView)v.findViewById(R.id.person_name);
            mImage = v.findViewById(R.id.person_image);
        }
    }



    public interface OnImageClickListener{
        void omImageClick(User u);
    }
}
