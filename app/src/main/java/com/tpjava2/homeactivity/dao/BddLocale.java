package com.tpjava2.homeactivity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.tpjava2.homeactivity.models.Accessoire;
import com.tpjava2.homeactivity.models.AlesageCarter;
import com.tpjava2.homeactivity.models.Carter;
import com.tpjava2.homeactivity.models.Controle;
import com.tpjava2.homeactivity.models.Mobile;
import com.tpjava2.homeactivity.models.PetitesFournitures;
import com.tpjava2.homeactivity.models.Portee;
import com.tpjava2.homeactivity.models.Reducteur;
import com.tpjava2.homeactivity.models.Tache;

import java.util.ArrayList;
import java.util.List;


public class BddLocale extends SQLiteOpenHelper {

    SQLiteOpenHelper sql ;
    private static final String DATA_BASE_NAME ="BasedeDonneesSegor1";
    private  static  final  int DATA_BASE_VERSION =3;


    public BddLocale(@Nullable Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }


    public static String getDataBaseName() {
        return DATA_BASE_NAME;
    }

    public static int getDataBaseVersion() {
        return DATA_BASE_VERSION;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 ="CREATE TABLE Reducteur(id INTEGER PRIMARY KEY ,constructeur TEXT, type_reducteur TEXT, N_Serie TEXT, annee_fab TEXT," +
                "rapport_i TEXT , type_moteur TEXT  , client TEXT, date_recu TEXT, cde_expertise TEXT, code_expertise TEXT, cde_segor TEXT," +
                "nom_demonteur TEXT, poid TEXT, encombrement TEXT, chassis TEXT, reducteur_livre TEXT, type_lubrification TEXT, quantite TEXT," +
                "viscosite TEXT,  quantite_graisse TEXT,num_offre TEXT)";

        String table2 = "CREATE TABLE Accessoire(id INTEGER  PRIMARY KEY AUTOINCREMENT, caracteristique TEXT,autre_caracteristique TEXT,marque TEXT ,type TEXT  , etat TEXT, nom_accessoire TEXT, commentaire TEXT )";


        String table7 =" CREATE TABLE Fourniture(id INTEGER PRIMARY KEY  AUTOINCREMENT , nom_fourniture TEXT , quantite TEXT , reference TEXT , portee_id Text, FOREIGN KEY (portee_id)  REFERENCES portee(id) )";

        String table8 = "CREATE TABLE portee(id  INTEGER PRIMARY KEY  AUTOINCREMENT, nom_portee TEXT, diametre_portee TEXT, norme TEXT , type_portee  TEXT ,mobile_id Text , FOREIGN KEY (mobile_id)  REFERENCES Mobile(id))";

        String table10 =  "CREATE  TABLE AlesageCarter(id INTEGER  PRIMARY KEY  AUTOINCREMENT, nom_alesageCarter TEXT, type TEXT, diametre_alesage_carter TEXT,norme TEXT) ";

        String table11 = "CREATE  TABLE Mobile(id INTEGER  PRIMARY KEY  AUTOINCREMENT, nom TEXTE , durete TEXT, type TEXT,nombreDentRoue TEXT, nombreDentPignon TEXT ,  moduleRoue TEXT," +
                "  modulePignon TEXT ,inclinaison TEXT)";

        String table12 ="CREATE TABLE PetitesFournitures( id INTEGER  PRIMARY KEY  AUTOINCREMENT, nom_petite_fourniture TEXT, matiere TEXT,quantite Text, reference TEXT)";

        String table13 ="CREATE TABLE Tache( id INTEGER  PRIMARY KEY  , designation TEXT, temps TEXT )";

        String table14 ="CREATE TABLE Controle( id INTEGER  PRIMARY KEY  , denomination TEXT , realise TEXT, aRealise TEXT)";

        String table15 =  "CREATE TABLE Carter(id INTEGER  PRIMARY KEY,longueur TEXT, largeur TEXT, hauteur TEXT ,masse TEXT)";

        db.execSQL(table1) ; db.execSQL(table2);
        db.execSQL(table14);
        db.execSQL(table7); db.execSQL(table8);
        db.execSQL(table10); db.execSQL(table15);
        db.execSQL(table12);
        db.execSQL(table11);
        db.execSQL(table13);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sqlRequete =  "DROP TABLE IF EXISTS Accessoire";
        String sqlRequete1 =  "DROP TABLE IF EXISTS Reducteur";

        String sqlRequete3 =  "DROP TABLE IF EXISTS Controle";


        String sqlRequete6 =  "DROP TABLE IF EXISTS Portee";
        String sqlRequete7 =  "DROP TABLE IF EXISTS Fourniture";
        String sqlRequete8 =  "DROP TABLE IF EXISTS AlesageArbre";

        String sqlRequete10 =  "DROP TABLE IF EXISTS AlesageCarter";
        String sqlRequete11 =  "DROP TABLE IF EXISTS Mobile";
        String sqlRequete12 =  "DROP TABLE IF EXISTS PetitesFournitures";
        String sqlRequete13 =  "DROP TABLE IF EXISTS Tache";
        String sqlRequete14 =  "DROP TABLE IF EXISTS Carter";

        db.execSQL(sqlRequete);
        db.execSQL(sqlRequete1);
        db.execSQL(sqlRequete3);
        db.execSQL(sqlRequete6);
        db.execSQL(sqlRequete7);
        db.execSQL(sqlRequete8);
        db.execSQL(sqlRequete10);
        db.execSQL(sqlRequete11);
        db.execSQL(sqlRequete12);
        db.execSQL(sqlRequete13);
        db.execSQL(sqlRequete14);



        this.onCreate(db);

    }




  public boolean insertInformationReducteur(Reducteur reducteur) {
      SQLiteDatabase sql = this.getWritableDatabase();
      ContentValues cv = new ContentValues();
      cv.put("id", reducteur.getId());
      cv.put("num_offre", reducteur.getNumOffre());
      cv.put("constructeur", reducteur.getConstructeur());
      cv.put("type_reducteur", reducteur.getType_reducteur());
      cv.put("N_Serie", reducteur.getN_Serie());
      cv.put("annee_fab", reducteur.getAnnee_fab());
      cv.put("rapport_i", reducteur.getRapport_i());
      cv.put("type_moteur", reducteur.getType_moteur());
      cv.put("client", reducteur.getClient());
      cv.put("date_recu", reducteur.getDate_recu());
      cv.put("cde_expertise", reducteur.getCde_expertise());
      cv.put("code_expertise", reducteur.getCode_expertise());
      cv.put("cde_segor", reducteur.getCde_segor());
      cv.put("nom_demonteur", reducteur.getNom_demonteur());
      cv.put("poid", reducteur.getPoids());
      cv.put("encombrement", reducteur.getEncombrement());
      cv.put("chassis", reducteur.getChassis());
      cv.put("reducteur_livre", reducteur.getReducteur_livre());
      cv.put("type_lubrification", reducteur.getType_lubrification());
      cv.put("quantite", reducteur.getQuantite());
      cv.put("viscosite", reducteur.getViscosite());
      cv.put("quantite_graisse", reducteur.getQuantite_graisse());
      long result = sql.insert("Reducteur", null, cv);
      //sql.close();
      if (result == -1) {
          return false;
      } else {
          return true;
      }


  }

  public  Reducteur getReducteurById(int id) {
      Reducteur reducteur = new Reducteur();
      String sqlReq = "SELECT * FROM Reducteur where id = " + id;
      Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);


      if (cursor.moveToFirst()) {
          reducteur.setId(cursor.getInt(0));
          reducteur.setConstructeur(cursor.getString(1));
          reducteur.setType_reducteur(cursor.getString(2));
          reducteur.setN_Serie(cursor.getString(3));
          reducteur.setAnnee_fab(cursor.getString(4));
          reducteur.setRapport_i(cursor.getString(5));
          reducteur.setType_moteur(cursor.getString(6));
          reducteur.setClient(cursor.getString(7));
          reducteur.setDate_recu(cursor.getString(8));
          reducteur.setCde_expertise(cursor.getString(9));
          reducteur.setCode_expertise(cursor.getString(10));
          reducteur.setCde_segor(cursor.getString(11));
          reducteur.setNom_demonteur(cursor.getString(12));
          reducteur.setPoids(cursor.getString(13));
          reducteur.setEncombrement(cursor.getString(14));
          reducteur.setChassis(cursor.getString(15));
          reducteur.setReducteur_livre(cursor.getString(16));
          reducteur.setType_lubrification(cursor.getString(17));
          reducteur.setQuantite(cursor.getString(18));
          reducteur.setViscosite(cursor.getString(19));
          reducteur.setQuantite_graisse(cursor.getString(20));
          reducteur.setNumOffre(cursor.getString(21));
          return reducteur;
      }
      return null;
  }




    public boolean updateInformationReducteur(Reducteur reducteur) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", reducteur.getId());
        cv.put("num_offre", reducteur.getNumOffre());
        cv.put("constructeur", reducteur.getConstructeur());
        cv.put("type_reducteur", reducteur.getType_reducteur());
        cv.put("N_Serie", reducteur.getN_Serie());
        cv.put("annee_fab", reducteur.getAnnee_fab());
        cv.put("rapport_i", reducteur.getRapport_i());
        cv.put("type_moteur", reducteur.getType_moteur());
        cv.put("client", reducteur.getClient());
        cv.put("date_recu", reducteur.getDate_recu());
        cv.put("cde_expertise", reducteur.getCde_expertise());
        cv.put("code_expertise", reducteur.getCode_expertise());
        cv.put("cde_segor", reducteur.getCde_segor());
        cv.put("nom_demonteur", reducteur.getNom_demonteur());
        cv.put("poid", reducteur.getPoids());
        cv.put("encombrement", reducteur.getEncombrement());
        cv.put("chassis", reducteur.getChassis());
        cv.put("reducteur_livre", reducteur.getReducteur_livre());
        cv.put("type_lubrification", reducteur.getType_lubrification());
        cv.put("quantite", reducteur.getQuantite());
        cv.put("viscosite", reducteur.getViscosite());
        cv.put("quantite_graisse", reducteur.getQuantite_graisse());
        int result = sql.update("Reducteur", cv, "id = ?", new String[]{String.valueOf(reducteur.getId())});
        sql.close();
        return  (result != -1) ;
    }



    public Reducteur getReducteur(){
        Reducteur reducteur = new Reducteur();
        String sqlReq = "SELECT * FROM Reducteur";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        if(cursor.moveToFirst()) {
            reducteur.setId(cursor.getInt(0));
            reducteur.setConstructeur(cursor.getString(1));
            reducteur.setType_reducteur(cursor.getString(2));
            reducteur.setN_Serie(cursor.getString(3));
            reducteur.setAnnee_fab(cursor.getString(4));
            reducteur.setRapport_i(cursor.getString(5));
            reducteur.setType_moteur(cursor.getString(6));
            reducteur.setClient(cursor.getString(7));
            reducteur.setDate_recu(cursor.getString(8));
            reducteur.setCde_expertise(cursor.getString(9));
            reducteur.setCode_expertise(cursor.getString(10));
            reducteur.setCde_segor(cursor.getString(11));
            reducteur.setNom_demonteur(cursor.getString(12));
            reducteur.setPoids(cursor.getString(13));
            reducteur.setEncombrement(cursor.getString(14));
            reducteur.setChassis(cursor.getString(15));
            reducteur.setReducteur_livre(cursor.getString(16));
            reducteur.setType_lubrification(cursor.getString(17));
            reducteur.setQuantite(cursor.getString(18));
            reducteur.setViscosite(cursor.getString(19));
            reducteur.setQuantite_graisse(cursor.getString(20));
            reducteur.setNumOffre(cursor.getString(21));
            return reducteur;
        }
        return null;
    }

    public boolean deletInformationReducteur(int id){
        SQLiteDatabase sql = this.getWritableDatabase();
        sql.delete("Reducteur", "id = "+id, null);
        return true;
    }




    public  boolean insertionAccessoire(Accessoire accessoire){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",accessoire.getId());
        cv.put("nom_accessoire", accessoire.getNom_accessoire());
        cv.put("commentaire" , accessoire.getCommentaire());
        cv.put("caracteristique", accessoire.getCaracteristique());
        cv.put("autre_caracteristique" , accessoire.getAutreCaracteristique());
        cv.put("marque", accessoire.getMarque());
        cv.put("type" , accessoire.getType());
        cv.put("etat" , accessoire.getEtat());
        long result = sql.insert("Accessoire", null, cv);
        //sql.close();
        if( result == -1){
            return false;
        }else{
            return true;
        }

    }



    public  boolean insertionMobile(Mobile mobile){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",mobile.getId());
        cv.put("nom", mobile.getNom());
        cv.put("type" , mobile.getType());
        cv.put("durete", mobile.getDurete());
        long result = sql.insert("Mobile", null, cv);
        //sql.close();
        if( result == -1){
            return false;
        }else{
            return true;
        }

    }


    public  void insertionPortee(Portee portee){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("diametre_portee",portee.getDiametrePortee());
        cv.put("type_portee",portee.getTypePortee());
        sql.insert("Portee", null, cv);
        sql.close();
    }

    public  boolean insertionAlesageCarter(AlesageCarter alesageCarter){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom_alesageCarter", alesageCarter.getNomAlesageCarter());
        cv.put("diametre_alesage_carter", alesageCarter.getDiametreAlesageCarter());
        cv.put("type", alesageCarter.getType());
        cv.put("norme", alesageCarter.getNorme());

        long result = sql.insert("AlesageCarter", null, cv);
        if( result == -1){
            return false;
        }else{
            return true;
        }

    }

    /*public  void insertionAlesage_arbre(AlesageArbre alesageArbre){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("diametre",alesageArbre.getDiametre_alesage_arbre());
        sql.insert("AlesageArbre", null, cv);
        sql.close();
    }*/



    public  boolean insertionTache(Tache tache){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",tache.getId());
        cv.put("temps",tache.getTemps());
        cv.put("designation",tache.getDesignation());
        long result = sql.insert("Tache", null, cv);
        if( result == -1){
            return false;
        }else{
            return true;
        }
    }
    public  boolean updateTache(Tache tache){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",tache.getId());
        cv.put("temps",tache.getTemps());
        cv.put("designation",tache.getDesignation());
        int result = sql.update("Tache", cv, "id = ?", new String[]{String.valueOf(tache.getId())});
        if( result == -1){
            return false;
        }else{
            return true;
        }
    }


    public Tache getTache(){
        Tache tache = new Tache();
        String sqlReq = "SELECT * FROM Tache";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        if(cursor.moveToFirst()) {
            tache.setId(cursor.getInt(0));
            tache.setDesignation(cursor.getString(1));
            tache.setTemps(cursor.getString(2));
            return tache;
        }
        return null;
    }

    public List<Tache> getAllTache(){
        List<Tache> tacheliste = new ArrayList<>();
        String sqlReq = "SELECT * FROM Tache";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Tache tache = new Tache();
            tache.setId(cursor.getInt(0));
            tache.setDesignation(cursor.getString(1));
            tache.setTemps(cursor.getString(2));

            tacheliste.add(tache);
            System.out.println(tache.getDesignation());
            cursor.moveToNext();
        }
        return tacheliste;
    }


    public  void insertionControle(Controle controle){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",controle.getId());
        cv.put("denomination",controle.getDenomination());
        cv.put("realise",controle.getRealise());
        cv.put("aRealise",controle.getaRealise());
        sql.insert("Controle", null, cv);
        sql.close();
    }


    public  boolean updateControle(Controle controle){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",controle.getId());
        cv.put("denomination",controle.getDenomination());
        cv.put("realise",controle.getRealise());
        cv.put("aRealise",controle.getaRealise());
        int result = sql.update("Controle", cv, "id = ?", new String[]{String.valueOf(controle.getId())});
        if( result == -1){
            return false;
        }else{
            return true;
        }
    }


    public Controle getControle(){
        Controle controle = new Controle();
        String sqlReq = "SELECT * FROM Controle";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        if(cursor.moveToFirst()) {
            controle.setId(cursor.getInt(0));
            controle.setDenomination(cursor.getString(1));
            controle.setRealise(cursor.getString(2));
            controle.setaRealise(cursor.getString(3));
            return controle;
        }
        return null;
    }

    public List<Controle> getAllControle(){
        List<Controle> controleListliste = new ArrayList<>();
        String sqlReq = "SELECT * FROM Controle";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Controle controle = new Controle();
            controle.setId(cursor.getInt(0));
            controle.setDenomination(cursor.getString(1));
            controle.setRealise(cursor.getString(2));
            controle.setaRealise(cursor.getString(3));

            controleListliste.add(controle);

            cursor.moveToNext();
        }
        return controleListliste;
    }




    public  boolean insertionCarter(Carter carter){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("longueur",carter.getLongueur());
        cv.put("largeur",carter.getLargeur());
        cv.put("hauteur",carter.getHauteur());
        cv.put("masse",carter.getMasse());
        long result = sql.insert("Carter", null, cv);
        if( result == -1){
            return false;
        }else{
            return true;
        }
    }

    ///// iformations accessoire
    public void updateAccessoire(Accessoire accessoire){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id",accessoire.getId());
        cv.put("nom_accessoire", accessoire.getNom_accessoire());
        cv.put("commentaire" , accessoire.getCommentaire());
        cv.put("caracteristique", accessoire.getCaracteristique());
        cv.put("autre_caracteristique" , accessoire.getAutreCaracteristique());
        cv.put("marque", accessoire.getMarque());
        cv.put("type" , accessoire.getType());
        cv.put("etat" , accessoire.getEtat());
        sql.update("Accessoire", cv, "id = ?", new String[]{String.valueOf(accessoire.getId())});
    }

    public List<Accessoire> getAllAccessoires(){
        List<Accessoire> accessoireList = new ArrayList<>();

        String sqlReq = "SELECT * FROM Accessoire";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Accessoire accessoire = new Accessoire();

            accessoire.setId(cursor.getInt(0));
            accessoire.setCaracteristique(cursor.getString(1));
            accessoire.setAutreCaracteristique(cursor.getString(2));
            accessoire.setMarque(cursor.getString(3));
            accessoire.setType(cursor.getString(4));
            accessoire.setEtat(cursor.getString(5));
            accessoire.setNom_accessoire(cursor.getString(6));
            accessoire.setCommentaire(cursor.getString(7));

            accessoireList.add(accessoire);
            cursor.moveToNext();
        }

        return accessoireList;
    }

    public boolean deleteAccessoire(int id){
        // String sqlReq = "DELETE FROM Accessoire WHERE id = "+id;
        SQLiteDatabase sql = this.getWritableDatabase();
        sql.delete("Accessoire", "id = "+id, null);
        return true;
    }




    public Carter getCarter() {
        Carter carter = new Carter();
        String sqlReq = "SELECT * FROM Carter";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        if(cursor.moveToFirst()) {
            carter.setId(cursor.getInt(0));
            carter.setHauteur(cursor.getString(3));
            carter.setLargeur(cursor.getString(2));
            carter.setLongueur(cursor.getString(1));
            carter.setMasse(cursor.getString(4));
            return carter;
        }
        return null;


    }

    public boolean deleteMobile(Integer id) {
        SQLiteDatabase sql = this.getWritableDatabase();
        sql.delete("Mobile", "id = "+id, null);
        return true;
    }
}
