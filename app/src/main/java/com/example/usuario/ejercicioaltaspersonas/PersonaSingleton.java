package com.example.usuario.ejercicioaltaspersonas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 27/03/2018.
 */

class PersonaSingleton {
    private static final PersonaSingleton ourInstance = new PersonaSingleton();

    private List<Persona> listaPersonas = new ArrayList<>();




    static PersonaSingleton getInstance() {

        return ourInstance;

    }

    private PersonaSingleton() {
    }

    public boolean add(Persona persona) {

        return listaPersonas.add(persona);
    }

    public boolean remove(Object o) {
        return listaPersonas.remove(o);
    }

    public Persona get(int index) {
        return listaPersonas.get(index);
    }

    public Persona set(int index, Persona element) {
        return listaPersonas.set(index, element);
    }

    public void add(int index, Persona element) {
        listaPersonas.add(index, element);
    }

    public Persona remove(int index) {
        return listaPersonas.remove(index);
    }

    public int indexOf(Object o) {
        return listaPersonas.indexOf(o);
    }

    public List<Persona> getListaPersonas () {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}

