package TremBom.Factory;

import TremBom.Ferroviaria.Ferroviaria;
import TremBom.Ferroviaria.estacoesMg;
import TremBom.Ferroviaria.estacoesSp;

public abstract class ferroviariaFactory {

    public static Ferroviaria fFactory(String nome, String cidade, String estado) {

        switch (estado.toUpperCase()) {
            case "MG":
                return new estacoesMg(nome, cidade, estado);
            case "SP":
                return new estacoesSp(nome, cidade, estado);
            default:
                return null;
        }

    }

}
