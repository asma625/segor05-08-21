package com.tpjava2.homeactivity.models;

import org.json.JSONException;
import org.json.JSONObject;

public class AlesageMobiles {
    private  Integer id;
    private float diametre_alesage_arbre;
    private String type;
    Mobile arbre = new Mobile();

    public JSONObject toJson() throws JSONException {

        JSONObject JsonAlesageArbre = new JSONObject();

        JsonAlesageArbre.put("id", this.getId());
        JsonAlesageArbre.put("diametre_alesage_arbre", this.getDiametre_alesage_arbre());
        JsonAlesageArbre.put("type", this.getType());
        JsonAlesageArbre.put("arbre",arbre.toJson());
        return JsonAlesageArbre;
    }

    public float getDiametre_alesage_arbre() {
        return diametre_alesage_arbre;
    }

    public void setDiametre_alesage_arbre(float diametre_alesage_arbre) {
        this.diametre_alesage_arbre = diametre_alesage_arbre;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
