package com.tpjava2.homeactivity.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.models.AlesageCarter;
import com.tpjava2.homeactivity.models.AlesageCarter;
import com.tpjava2.homeactivity.models.PetitesFournitures;

import java.util.ArrayList;
import java.util.List;

public class AnnotationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<AlesageCarter> annotations;
    int  compteur = 1;

    public AnnotationAdapter(List<AlesageCarter> annotations) {
        this.annotations = annotations;

    }

    static class AnnotationViewHolder extends RecyclerView.ViewHolder{

        EditText editTextNumeroAlesageCarter;
        EditText editTextNomAlesageCarter;
        EditText editTextTypeAlesageCarter;
        EditText editTextDiametreAlesageCarter;

        LinearLayout layout;

        public AnnotationViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextNumeroAlesageCarter = itemView.findViewById(R.id.editText_numero_AlesageCarter);
            editTextNomAlesageCarter = itemView.findViewById(R.id.editText_nom_AlesageCarter);
            editTextTypeAlesageCarter = itemView.findViewById(R.id.editText_type_AlesageCarter);
            editTextDiametreAlesageCarter = itemView.findViewById(R.id.editText_diametre_AlesageCarter);
            layout = itemView.findViewById(R.id.layout_item);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_annotation, parent, false);
        return new AnnotationViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            AlesageCarter alesageCarter = annotations.get(position);

            AnnotationViewHolder annotationViewHolder = (AnnotationViewHolder) holder;
            annotationViewHolder.editTextNumeroAlesageCarter.setText(""+compteur++);
            annotationViewHolder.editTextNomAlesageCarter.setText(alesageCarter.getNomAlesageCarter());
           annotationViewHolder.editTextTypeAlesageCarter.setText(alesageCarter.getType());
           annotationViewHolder.editTextDiametreAlesageCarter.setText(alesageCarter.getDiametreAlesageCarter());


    }

    @Override
    public int getItemCount() {
        return annotations.size();
    }
}
