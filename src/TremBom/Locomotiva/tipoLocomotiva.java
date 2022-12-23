
package TremBom.Locomotiva;


public abstract class tipoLocomotiva {
    
    private String modelo;
    private String tipo;
    private int anoFabric;

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAnoFabric() {
        return anoFabric;
    }

    public tipoLocomotiva(String modelo, String tipo, int anoFabric) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.anoFabric = anoFabric;
    }
    
    
    
}
