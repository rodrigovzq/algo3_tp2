package edu.fiuba.algo3.modelo.Direccion;

public enum Direccion {     
        NORTE { @Override public Direccion opuesto() { return SUR; }},
        ESTE  { @Override public Direccion opuesto() { return OESTE;  }},
        SUR { @Override public Direccion opuesto() { return NORTE; }},
        OESTE  { @Override public Direccion opuesto() { return ESTE;  }},
        ;
        abstract public Direccion opuesto();
}

