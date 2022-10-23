package com.ufc.quixada.atividade02.dao;

import android.content.Context;

import java.util.ArrayList;

import com.ufc.quixada.atividade02.model.Carro;

public class CarrosDAOInterface {
    static CarrosDAOInterface getInstance(Context context){
        return null;
    }

    boolean addCarro (Carro c);
    boolean editCarro (Carro c);
    boolean deleteCarro (int carroId);
    Carro getCarro (int carroId);
    ArrayList<Carro> getListaCarros();
    boolean deleteAll();

    boolean init();
    boolean close();
    boolean isStarted();

}
