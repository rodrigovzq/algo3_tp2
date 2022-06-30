package edu.fiuba.algo3.modelo.Direccion;

public enum Direccion {     
        NORTE { @Override public Direccion opuesto() { return SUR; }},
        ESTE  { @Override public Direccion opuesto() { return OESTE;  }},
        SUR { @Override public Direccion opuesto() { return NORTE; }},
        OESTE  { @Override public Direccion opuesto() { return ESTE;  }},
        NORESTE { @Override public Direccion opuesto() { return SUDOESTE; }},
        NOROESTE  { @Override public Direccion opuesto() { return SUDESTE;  }},
        SUDESTE { @Override public Direccion opuesto() { return NOROESTE; }},
        SUDOESTE  { @Override public Direccion opuesto() { return NORESTE;  }},
        ;
        abstract public Direccion opuesto();
}

