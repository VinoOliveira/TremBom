
package TremBom.Factory;

import TremBom.Locomotiva.Metro;
import TremBom.Locomotiva.Trem;
import TremBom.Locomotiva.tipoLocomotiva;


public abstract class locomotivaFactory {
    
    public static tipoLocomotiva lFactory(String tipo, String modelo, int anoFabric){
        switch(tipo){
            case "trem":
                return new Trem(modelo, tipo, anoFabric);
            case"metro":
                return new Metro(modelo, tipo, anoFabric);
            default:
                return null;
        }
    }
    
}
