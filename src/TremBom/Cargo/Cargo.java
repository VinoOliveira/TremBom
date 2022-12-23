package TremBom.Cargo;

public abstract class Cargo {

    private String nomeCargo;

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Cargo(String nomeCargo) {

        this.nomeCargo = nomeCargo;
    }

}
