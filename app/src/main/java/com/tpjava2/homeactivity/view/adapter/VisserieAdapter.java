package com.tpjava2.homeactivity.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.dao.VisserieManager;
import com.tpjava2.homeactivity.models.Accessoire;
import com.tpjava2.homeactivity.models.PetitesFournitures;

import java.util.ArrayList;
import java.util.List;

public class VisserieAdapter extends    RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private PetitesFournitures petitesFournitures = new PetitesFournitures();
    private List<PetitesFournitures> petitesFournituresList = new ArrayList<>();
    private Context context;
    private ImageButton imageButton;



    public VisserieAdapter(List<PetitesFournitures> petitesFournituresList, Context context) {
        this.petitesFournituresList = petitesFournituresList;
        this.context = context;
    }


    static class VisserieViewHolder extends RecyclerView.ViewHolder{

        ImageButton buttonSupprimerPetiteFourniture;

        EditText editTextNomVisserie,editTextQuantite,editTextReference;
        TextView textViewNomVisserie , textViewQuantite, textViewMatiere, textViewReference;


        BottomAppBar bottomAppBarTeste;

        public VisserieViewHolder(@NonNull View itemView) {
            super(itemView);
            buttonSupprimerPetiteFourniture = itemView.findViewById(R.id.imageButton_supprimer_visserie);
            editTextNomVisserie =itemView.findViewById(R.id.editText_nom_petite_fourniture);
            editTextQuantite =itemView.findViewById(R.id.editText_quantite_visserie);
            editTextReference = itemView.findViewById(R.id.editTextText_reference_petite_fourniture);
            textViewQuantite = itemView.findViewById(R.id.textView_quantite_visserie);
            textViewNomVisserie = itemView.findViewById(R.id.TextView_nom_visserie);
            textViewMatiere = itemView.findViewById(R.id.textView_matiere_visserie);
            textViewReference = itemView.findViewById(R.id.textView_reference_visserie);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_visserie, parent,false);
        return new VisserieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VisserieManager  visserieManager =  new VisserieManager(context);
        PetitesFournitures petitesFournitures = petitesFournituresList.get(position);
       VisserieViewHolder visserieViewHolder = (VisserieViewHolder) holder;

        visserieViewHolder.textViewNomVisserie.setText(petitesFournitures.getNomPetiteFourniture());
        visserieViewHolder.textViewQuantite.setText(petitesFournitures.getQuantite()+" X ");
        visserieViewHolder.textViewReference.setText(petitesFournitures.getReference());
        visserieViewHolder.textViewMatiere.setText(petitesFournitures.getMatiere());


        visserieViewHolder.buttonSupprimerPetiteFourniture.setOnClickListener(v -> {

            Integer id = petitesFournituresList.get(position).getId();
            visserieManager.deletePetitesFournitures(id);
            petitesFournituresList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());

        });

    }


    @Override
    public int getItemCount() {
        return petitesFournituresList.size();
    }

        }


