

package TremBom.Factory;

import TremBom.Pessoas.Pessoas;
import java.util.Scanner;


public class TremBom {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("tipo de pessoa, funcionario ou cliente");
        String tipo = sc.next();
        System.out.println("nome");
        String nome = sc.next();
        System.out.println("idade");
        int idade = sc.nextInt();
        System.out.println("cpf");
        String cpf = sc.next();

        switch (tipo) {
            case "cliente":
                Pessoas cliente = PessoasFactory.pFactory(tipo, nome, idade, cpf);
                System.out.println("cliente salvo no banco de dados");
                break;

            case "funcionario":
                Pessoas funcionario = (Pessoas) PessoasFactory.pFactory(tipo, nome, idade, cpf);
                System.out.println("funcionario salvo no banco de dados");
                break;
        }

    }

}
