package com.ipo.distropia.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ipo.distropia.R;
import com.ipo.distropia.adapter.UserListAdapter;
import com.ipo.distropia.data.Data;
import com.ipo.distropia.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 21/06/2018.
 */


public class HomeFragment extends Fragment implements UserListAdapter.OnImageClickListener{

    FloatingActionButton myAddButton;
    TextView tvHome;
    private Fragment fragment;
    HomeFragment.MyActivityListener listener;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<User> users;
    private Data mData;


    public static HomeFragment newInstance(HomeFragment.MyActivityListener listener){
        HomeFragment f = new HomeFragment();
        f.listener = listener;
        f.users = new ArrayList<>();
        return f;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.user_list);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mData = Data.getInstance();



        mAdapter = new UserListAdapter(getActivity(), mData.getUsers(), this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }
    @Override
    public void omImageClick(User u) {
        listener.goUserDetail(u);
    }

    public interface MyActivityListener{
        void goUserDetail(User u);
    }
}
