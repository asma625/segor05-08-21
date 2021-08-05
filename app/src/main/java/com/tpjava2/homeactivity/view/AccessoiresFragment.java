package com.tpjava2.homeactivity.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.AccessoireManager;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Accessoire;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.view.adapter.ListeAccessoiresAdapter;


import java.util.ArrayList;
import java.util.List;

public class AccessoiresFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButtonMoteur;
    private ImageButton imageButtonFrein;
    private ImageButton imageButtonAccouplementPV;
    private ImageButton imageButtonPompe;
    private ImageButton imageButtonLub;
    private ImageButton imageButtonRef;
    private ImageButton imageButtonAccouplementGV;
    private ImageButton imageButtonDeriveur;
    private ImageButton imageButtonAutreAccessoire;
    private List<Accessoire> listeAccessoires;
    private AccessoireManager accessoireManager;
    private RecyclerView recyclerView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_accessoires, container, false);

        accessoireManager =  new AccessoireManager(this.getContext());
        imageButtonFrein = root.findViewById(R.id.imageButton_frein);
        imageButtonMoteur = root.findViewById(R.id.imageButton_moteur);
        imageButtonAccouplementPV = root.findViewById(R.id.imageButton_accouplement_gv);
        imageButtonAutreAccessoire = root.findViewById(R.id.imageButton_autre_accessoire);

        imageButtonAccouplementGV = root.findViewById(R.id.imageButton_accouplement_pv);
        imageButtonDeriveur = root.findViewById(R.id.imageButton_deriveur);
        imageButtonPompe = root.findViewById(R.id.imageButton_pompe);
        imageButtonLub = root.findViewById(R.id.imageButton_lub);
        imageButtonRef = root.findViewById(R.id.imageButton_refroidissement);

        listeAccessoires =  accessoireManager.getAllAccessoires();

        recyclerView = root.findViewById(R.id.recyclerView_accessoires);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));

        imageButtonFrein.setOnClickListener(this::onClick);
        imageButtonMoteur.setOnClickListener(this::onClick);
        imageButtonAccouplementPV.setOnClickListener(this::onClick);
        imageButtonAccouplementGV.setOnClickListener(this::onClick);
        imageButtonDeriveur.setOnClickListener(this::onClick);
        imageButtonPompe.setOnClickListener(this::onClick);
        imageButtonAutreAccessoire.setOnClickListener(this::onClick);
        imageButtonLub.setOnClickListener(this::onClick);
        imageButtonRef.setOnClickListener(this::onClick);

        return root;
    }

    @Override
    public void onClick(View v) {


        //BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
        accessoireManager = new AccessoireManager(this.getContext());
        Accessoire accessoireChoisi = new Accessoire();


        switch (v.getId()) {
            case R.id.imageButton_frein:

                accessoireChoisi.setNom_accessoire("FREIN");
                accessoireManager.insertionAccessoire(accessoireChoisi);
                listeAccessoires = accessoireManager.getAllAccessoires();
                recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                break;

            case R.id.imageButton_moteur:

                accessoireChoisi.setNom_accessoire("MOTEUR");
                accessoireManager.insertionAccessoire(accessoireChoisi);
                listeAccessoires = accessoireManager.getAllAccessoires();
                recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                break;

            case R.id.imageButton_accouplement_gv:

                accessoireChoisi.setNom_accessoire("ACCOUPLEMENT GV");
                accessoireManager.insertionAccessoire(accessoireChoisi);
                listeAccessoires = accessoireManager.getAllAccessoires();
                recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                break;

            case R.id.imageButton_accouplement_pv:

                accessoireChoisi.setNom_accessoire("ACCOUPLEMENT PV");
                accessoireManager.insertionAccessoire(accessoireChoisi);
                listeAccessoires = accessoireManager.getAllAccessoires();
                recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                break;

            case R.id.imageButton_pompe:

                accessoireChoisi.setNom_accessoire("POMPE");
                accessoireManager.insertionAccessoire(accessoireChoisi);
                listeAccessoires = accessoireManager.getAllAccessoires();
                recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                break;

            case R.id.imageButton_deriveur:

                Dialog dialog = new Dialog(this.getContext());
                dialog.setContentView(R.layout.alerte_sens_deriveur);
                dialog.show();
                RadioGroup radioGroupeHoraire = dialog.findViewById(R.id.radioGroup_horaire);
                Button btnAjouter =  dialog.findViewById(R.id.button_ajouter_sens_deriveur);
                radioGroupeHoraire.setOnCheckedChangeListener((v1, v2)->
                {
                    switch (v2){
                        case R.id.radioButton_horaire :
                            accessoireChoisi.setNom_accessoire("ANTI DERIVEUR HORAIRE" );
                            break;
                            case R.id.radioButton_antihoraire :
                         accessoireChoisi.setNom_accessoire("ANTI DERIVEUR ANTI HORAIRE" );
                        break;
                }

                });

                btnAjouter.setOnClickListener(v1 -> {
                    accessoireManager.insertionAccessoire(accessoireChoisi);
                    listeAccessoires = accessoireManager.getAllAccessoires();
                    recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                    dialog.dismiss();
                });



                break;

            case R.id.imageButton_lub:

                accessoireChoisi.setNom_accessoire("CIRCUIT DE LUBRIFICATION");
                accessoireManager.insertionAccessoire(accessoireChoisi);
                listeAccessoires = accessoireManager.getAllAccessoires();
                recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                break;

            case R.id.imageButton_refroidissement:

                accessoireChoisi.setNom_accessoire("CIRCUIT DE REFROIDISSEMENT");
                accessoireManager.insertionAccessoire(accessoireChoisi);
                listeAccessoires = accessoireManager.getAllAccessoires();
                recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));
                break;

            case R.id.imageButton_autre_accessoire:

                Dialog alerteAutreAccessoire = new Dialog(this.getContext());
                alerteAutreAccessoire.setContentView(R.layout.alerte_autre_accessoire);

                Button buttonAjouterAccessoire = alerteAutreAccessoire.findViewById(R.id.button_ajouter_accessoire);
                EditText editTextAjouterAccessoire = alerteAutreAccessoire.findViewById(R.id.editText_ajouter_accessoire);

                buttonAjouterAccessoire.setOnClickListener(v1 -> {
                    if(!editTextAjouterAccessoire.getText().toString().equals("")) {

                        accessoireChoisi.setNom_accessoire(editTextAjouterAccessoire.getText().toString());
                        accessoireManager.insertionAccessoire(accessoireChoisi);
                        listeAccessoires = accessoireManager.getAllAccessoires();
                        recyclerView.setAdapter(new ListeAccessoiresAdapter(listeAccessoires,this.getContext()));

                        alerteAutreAccessoire.dismiss();
                    }
                });
                alerteAutreAccessoire.show();
                break;

            default:
                break;
        }



    }

}