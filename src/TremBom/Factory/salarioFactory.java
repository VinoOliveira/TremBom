
package TremBom.Factory;

import TremBom.Salarios.Salario;
import TremBom.Salarios.Salario1;
import TremBom.Salarios.Salario2;
import TremBom.Salarios.Salario3;


public abstract class salarioFactory {
    
    public static Salario sFactory(String cargo){
        switch(cargo){
            case "adm":
                return new Salario1(3000);
            case "gerente":
                return new Salario2(2500);
            case "atendente":
                return new Salario3(1500);
            default:
                return null;
        }
        
    };
}
