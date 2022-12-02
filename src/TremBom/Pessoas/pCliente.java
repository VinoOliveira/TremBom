
package TremBom.Pessoas;


public class pCliente extends Pessoas {
    
    public pCliente(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    @Override
    public void retornarDados() {
        System.out.println("nome: "+getNome());
        System.out.println("idade: "+getIdade());
        System.out.println("cpf: "+getCpf());
    }
   
    
}