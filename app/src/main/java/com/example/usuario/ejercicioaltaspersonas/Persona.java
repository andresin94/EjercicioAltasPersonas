package com.example.usuario.ejercicioaltaspersonas;

import java.io.Serializable;

/**
 * Created by Usuario on 27/03/2018.
 */

public class Persona implements Serializable{

    private String name;
    private String surname;
    private String surname2;

    public Persona(String name, String surname, String surname2) {
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;

        Persona persona = (Persona) o;

        if (getName() != null ? !getName().equals(persona.getName()) : persona.getName() != null)
            return false;
        if (getSurname() != null ? !getSurname().equals(persona.getSurname()) : persona.getSurname() != null)
            return false;
        return getSurname2() != null ? getSurname2().equals(persona.getSurname2()) : persona.getSurname2() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getSurname2() != null ? getSurname2().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", surname2='" + surname2 + '\'' +
                '}';
    }
}
