package com.ufc.quixada.atividade02.model;

public class Carro {
    static int geradorIds = -1;

    int id;
    String marca;
    String modelo;
    String cor;

    public int getId() {
        return id;
    }

    public void setId( int id ){
        this.id = id;
    }

    public Carro(String marca, String modelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;

        geradorIds++;
        this.id = geradorIds;

    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString(){

        return "Marca: " + marca;
    }

}
