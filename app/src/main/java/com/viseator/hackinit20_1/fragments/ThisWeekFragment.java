package com.viseator.hackinit20_1.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viseator.hackinit20_1.R;
import com.viseator.hackinit20_1.adapters.ExcelAdapter;


public class ThisWeekFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private RecyclerView weekday_list,game_list;
    private ExcelAdapter weekday_adapter;
    private View rootView;


    public ThisWeekFragment() {
        // Required empty public constructor
    }


    public static ThisWeekFragment newInstance(String param1, String param2) {
        ThisWeekFragment fragment = new ThisWeekFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_this_week, container, false);
        // Inflate the layout for this fragment
        initView();
        return rootView;
    }

    private void initView() {
        weekday_list = (RecyclerView) rootView.findViewById(R.id.hour_list_week);
        weekday_adapter = new ExcelAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        weekday_list.setLayoutManager(linearLayoutManager);
        weekday_list.setAdapter(weekday_adapter);

    }





}
