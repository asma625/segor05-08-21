package com.tpjava2.homeactivity.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.dao.AlesagesCarterManager;
import com.tpjava2.homeactivity.models.AlesageCarter;
import com.tpjava2.homeactivity.view.adapter.ListeAlesageCarterAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpertiseCarterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpertiseCarterFragment extends Fragment {

    RecyclerView recyclerView;
    AlesageCarter alesageCarter = new AlesageCarter();
    List<AlesageCarter> alesageCarterList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExpertiseCarterFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expertise_carter, container, false);


        recyclerView = rootView.findViewById(R.id.recyclerView_alesage_carter);
        AlesagesCarterManager alesagesCarterManager =  new AlesagesCarterManager(this.getContext());
        alesageCarterList = alesagesCarterManager.getAllAlesageCarters();
        System.out.println(alesageCarterList.size());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListeAlesageCarterAdapter(alesageCarterList,this.getContext()));

        return rootView;
    }
}