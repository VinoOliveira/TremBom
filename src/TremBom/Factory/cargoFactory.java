package TremBom.Factory;

import TremBom.Cargo.Adm;
import TremBom.Cargo.Atendente;
import TremBom.Cargo.Cargo;
import TremBom.Cargo.Gerente;


public abstract class cargoFactory {

    public static Cargo cFactory(String nomeCargo) {

        switch (nomeCargo) {
            case "adm":
                return new Adm("adiministrador");

            case "gerente":
                return new Gerente("gerente");

            case "atendente":
                return new Atendente("atendente");

            default:
                return null;
        }

    }

}
