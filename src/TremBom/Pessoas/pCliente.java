package TremBom.Pessoas;


import TremBom.Viagem.Viagem;



public class pCliente extends Pessoas {

    Viagem viagem;


    public pCliente(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    @Override
    public String retornarDados() {
        return "nome: " + getNome() + "\n"
                + "idade: " + getIdade() + "\n"
                + "cpf: " + getCpf();
                
    }

 

}
