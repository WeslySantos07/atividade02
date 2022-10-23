package com.ufc.quixada.atividade02.dao;

import android.content.Context;
import android.content.SharedPreferences;


import java.lang.reflect.Type;
import java.util.ArrayList;

import com.ufc.quixada.atividade02.controller.Codes;
import com.ufc.quixada.atividade02.model.Carro;

public class CarrosDAOSharedPreferences extends CarrosDAOInterface {

    private static ArrayList<Carro> lista;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static Context context;
    private static boolean initialized = false;

    private static CarrosDAOSharedPreferences carrosDAOSharedPreferences = null;

    private CarrosDAOSharedPreferences( Context c ){
        CarrosDAOSharedPreferences.context = c;
    }

    public static CarrosDAOInterface getInstance(Context context) {

        if( carrosDAOSharedPreferences == null ){
            carrosDAOSharedPreferences = new CarrosDAOSharedPreferences( context );
        }
        return carrosDAOSharedPreferences;
    }

    @Override
    public boolean addCarro(Carro c) {
        lista.add( c );
        return true;
    }

    @Override
    public boolean editCarro( Carro c ) {

        boolean edited = false;

        for( Carro carro : lista ){

            if( carro.getId() == c.getId() ){
                carro.setMarca( c.getMarca() );
                carro.setModelo( c.getModelo() );
                carro.setCor( c.getCor() );

                edited = true;
                break;

            }
        }
        return edited;
    }

    @Override
    public boolean deleteCarro(int carroId) {

        boolean deleted = false;
        Carro carroDeletar = null;

        for( Carro carro : lista ){
            if( carro.getId() == carroId ){

                carroDeletar = carro;
                deleted = true;
                break;

            }
        }

        if( carroDeletar != null ) lista.remove( carroDeletar );
        return deleted;

    }

    @Override
    public Carro getCarro( int carroId ) {

        Carro carroBuscar = null;
        for( Carro carro : lista ){
            if( carro.getId() == carroId ){
                carroBuscar = carro;
                break;
            }
        }

        return carroBuscar;
    }

    @Override
    public boolean init() {

        sharedPreferences = context.getSharedPreferences(Codes.SHAREDPREFERENCES_FILE,
                Context.MODE_PRIVATE );
        editor = sharedPreferences.edit();

        String listaCarrosString = sharedPreferences.getString( Codes.SHAREDPREFERENCES_FILE_KEY, "" );

        if( listaCarrosString.equals( "" ) ) lista = new ArrayList<Carro>();
        else{

            Type listType = TypeToken.getParameterized(ArrayList.class, Contato.class).getType();
            Gson gson = new Gson();
            lista = gson.fromJson( listaContatosString, listType );

        }

        initialized = true;

        return true;
    }

    public ArrayList<Contato> getListaContatos(){
        return lista;
    }

    public boolean deleteAll(){
        lista.clear();
        return true;
    }

    public boolean isStarted(){
        return initialized;
    }

    @Override
    public boolean close() {

        Gson gson = new Gson();
        String listaContatosString = gson.toJson( lista );
        editor.putString( Codes.SHAREDPREFERENCES_FILE_KEY, listaContatosString );
        editor.apply();

        return true;
    }

}
