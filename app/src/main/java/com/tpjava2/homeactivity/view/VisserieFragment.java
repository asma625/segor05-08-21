package com.tpjava2.homeactivity.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.dao.VisserieManager;
import com.tpjava2.homeactivity.models.AlesageCarter;
import com.tpjava2.homeactivity.models.PetitesFournitures;
import com.tpjava2.homeactivity.models.Reducteur;
import com.tpjava2.homeactivity.view.adapter.ListeMobilesAdapter;
import com.tpjava2.homeactivity.view.adapter.VisserieAdapter;

import java.util.ArrayList;
import java.util.List;

public class VisserieFragment extends Fragment {

    List<PetitesFournitures> petitesFournituresList =new ArrayList<>() ;
    private RecyclerView recyclerView;
    PetitesFournitures petitesFournitures = new PetitesFournitures();

    BottomAppBar bottomAppBar;
    FloatingActionButton buttonAjouterVisserie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_visserie, container, false);

        recyclerView = root.findViewById(R.id.recyclerView_liste_petites_fournitures);
        buttonAjouterVisserie = root.findViewById(R.id.floatingActionButton_ajouter_visserie);
        VisserieManager visserieManager =  new VisserieManager(this.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        petitesFournituresList = visserieManager.getAllPetitesFournitures();
        VisserieAdapter visserieAdapter = new VisserieAdapter(petitesFournituresList, this.getContext());
        recyclerView.setAdapter(visserieAdapter);

        buttonAjouterVisserie.setOnClickListener(v->{
            Dialog dialog = new Dialog(this.getContext());
            dialog.setContentView(R.layout.item_visserie);
            EditText editTextNomVisserie =dialog.findViewById(R.id.editText_nom_petite_fourniture);
            EditText editTextQuantite =dialog.findViewById(R.id.editText_quantite_visserie);
            EditText editTextReference = dialog.findViewById(R.id.editTextText_reference_petite_fourniture);
            RadioGroup radioGroupMatier = dialog.findViewById(R.id.RadioGroup_matiere);

            Button button  =  dialog.findViewById(R.id.button_alerte_ajoutre_visserie);
            button.setOnClickListener(v1 -> {
                petitesFournitures.setNomPetiteFourniture(editTextNomVisserie.getText().toString());
                petitesFournitures.setQuantite(editTextQuantite.getText().toString());
                petitesFournitures.setReference(editTextReference.getText().toString());
                visserieManager.insertionPetitesFourniture(petitesFournitures);
                petitesFournituresList = visserieManager.getAllPetitesFournitures();
                recyclerView.setAdapter(new VisserieAdapter(petitesFournituresList,this.getContext()));
                visserieAdapter.notifyDataSetChanged();
                dialog.dismiss();

            });

            radioGroupMatier.setOnCheckedChangeListener((radio, id) ->
            {
                switch (id) {

                    case R.id.radioButton_acier8 :
                        petitesFournitures.setMatiere("acier 8.8");
                        break;
                    case R.id.radioButton_acier12:
                        petitesFournitures.setMatiere("acier 12.9");
                        break;

                    case R.id.radioButton_inox:
                        petitesFournitures.setMatiere("inox");
                        break;
                }});

            dialog.show();


        });




        return root;

    }





}