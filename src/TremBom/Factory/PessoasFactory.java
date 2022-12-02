package TremBom.Factory;

import TremBom.Pessoas.Pessoas;
import TremBom.Pessoas.pCliente;
import TremBom.Pessoas.pFunc;



public abstract class PessoasFactory {

    public static Pessoas pFactory(String tipo, String nome, int idade, String cpf) {

        switch (tipo) {
            case "funcionario":
                return new pFunc(nome, idade, cpf);

            case "cliente":
                return new pCliente(nome, idade, cpf);

            default:
                return null;
        }

    }

}