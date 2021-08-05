package com.tpjava2.homeactivity.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.homeactivity.R;
import com.tpjava2.homeactivity.controller.ConnexionLocalController;
import com.tpjava2.homeactivity.dao.BddLocale;
import com.tpjava2.homeactivity.models.Controle;

import java.util.ArrayList;
import java.util.List;

public class ControleFragment extends Fragment {


    private BottomAppBar bottomAppBarControle;
    List<Controle> controleList = new ArrayList<>();
    //BddLocale bddLocale;
    private CheckBox checkBoxMagnetoRealise , checkBoxAlesageCarterRealise , checkBoxGeometrieCarterRealise , checkBoxEtanchiteRealise ,
            checkBoxCarterSablerRealise ,checkBoxMagnetoArealise , checkBoxAlesageCarterArealise , checkBoxGeometrieCarterArealise , checkBoxEtanchiteArealise ,
            checkBoxCarterSablerArealise ;


    public ControleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_controle, container, false);
        init(view);

        bottomAppBarControle.setOnMenuItemClickListener(itemMenu -> {
            if (itemMenu.getItemId() == R.id.item_camera) {

                BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
                if (bddLocale.getAllControle().size() == 0) {
                    String realise =checkBoxMagnetoRealise.isChecked()  ? "true" : "false";
                    String aRealise =checkBoxMagnetoArealise.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(1, "Magnéto",realise  , aRealise));


                    realise =checkBoxAlesageCarterRealise.isChecked()  ? "true" : "false";
                    aRealise =checkBoxAlesageCarterArealise.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(2, "Alésages carter",realise , aRealise));


                    realise =checkBoxGeometrieCarterRealise.isChecked()  ? "true" : "false";
                    aRealise =checkBoxGeometrieCarterArealise.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(3, "Géométrie carter", realise , aRealise));




                    realise =checkBoxEtanchiteRealise.isChecked()  ? "true" : "false";
                    aRealise =checkBoxEtanchiteArealise.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(4, "Etanchéité circuit", realise , aRealise));




                    realise =checkBoxCarterSablerRealise.isChecked()  ? "true" : "false";
                    aRealise =checkBoxCarterSablerArealise.isChecked()  ? "true" : "false";
                    bddLocale.insertionControle(ajouterControle(5, "Carter à sabler",realise , aRealise));




                } else {
                    String aRealise =checkBoxMagnetoArealise.isChecked()  ? "true" : "false";
                    String realise =checkBoxMagnetoRealise.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(1, "Magnéto",realise , aRealise));


                    aRealise =checkBoxAlesageCarterArealise.isChecked()  ? "true" : "false";
                    realise =checkBoxAlesageCarterRealise.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(2, "Alésages carter",realise , aRealise));


                    aRealise =checkBoxGeometrieCarterArealise.isChecked()  ? "true" : "false";
                    realise =checkBoxGeometrieCarterRealise.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(3, "Géométrie carter", realise , aRealise));


                    aRealise =checkBoxEtanchiteArealise.isChecked()  ? "true" : "false";
                    realise =checkBoxEtanchiteRealise.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(4, "Etanchéité circuit", realise , aRealise));



                    aRealise =checkBoxCarterSablerArealise.isChecked()  ? "true" : "false";
                    realise =checkBoxCarterSablerRealise.isChecked()  ? "true" : "false";
                    bddLocale.updateControle(ajouterControle(5, "Carter à sabler",realise , aRealise));



                }
                bddLocale.close();
                return true;
            }
            return false;
        });
        return view;
    }

    private Controle ajouterControle(Integer id, String denomination , String realise ,String aRealis) {
        Controle controle =  new Controle();
        controle.setId(id);
        controle.setDenomination(denomination);
        controle.setRealise(realise);
        controle.setaRealise(aRealis);

        return controle;

    }

    private void init(View view) {

        BddLocale bddLocale = ConnexionLocalController.getInstance(this.getContext());
        bottomAppBarControle = view.findViewById(R.id.bottomAppBar_edition_controle);
        checkBoxMagnetoRealise = view.findViewById(R.id.checkBox_magneto_realise);
        checkBoxAlesageCarterRealise = view.findViewById(R.id.checkBox_alesage_carter_realise);
        checkBoxGeometrieCarterRealise = view.findViewById(R.id.checkBox_geometrie_carter_realise);
        checkBoxEtanchiteRealise = view.findViewById(R.id.checkBox_etancheite_realise);
        checkBoxCarterSablerRealise = view.findViewById(R.id.checkBox_carter_sabler_realise);
        checkBoxMagnetoArealise = view.findViewById(R.id.checkBox_magneto_a_realise);
        checkBoxAlesageCarterArealise = view.findViewById(R.id.checkBox_alesage_carter_a_realise);
        checkBoxGeometrieCarterArealise = view.findViewById(R.id.checkBox_geometrie_carter_a_realise);
        checkBoxEtanchiteArealise = view.findViewById(R.id.checkBox_etancheite_a_realise);
        checkBoxCarterSablerArealise = view.findViewById(R.id.checkBox_carter_sabler_a_realise);

        controleList = bddLocale.getAllControle();

        if (controleList.size() != 0) {
            if(controleList.get(0).getRealise().equals("true") )
                checkBoxMagnetoRealise.setChecked(true);
            if(controleList.get(0).getaRealise().equals("true") )
                checkBoxMagnetoArealise.setChecked(true);

            if(controleList.get(1).getRealise().equals("true"))
                checkBoxAlesageCarterRealise.setChecked(true);
            if(controleList.get(1).getaRealise().equals("true") )
                checkBoxAlesageCarterArealise.setChecked(true);

            if(controleList.get(2).getRealise().equals("true") )
                checkBoxGeometrieCarterRealise.setChecked(true);
            if(controleList.get(2).getaRealise().equals("true") )
                checkBoxGeometrieCarterArealise.setChecked(true);


            if(controleList.get(3).getRealise().equals("true"))
                checkBoxEtanchiteRealise.setChecked(true);
            if(controleList.get(3).getaRealise().equals("true") )
                checkBoxEtanchiteArealise.setChecked(true);


            if(controleList.get(4).getRealise().equals("true"))
                checkBoxCarterSablerRealise.setChecked(true);
            if(controleList.get(4).getaRealise().equals("true") )
                checkBoxCarterSablerArealise.setChecked(true);

        }
        bddLocale.close();

    }
}