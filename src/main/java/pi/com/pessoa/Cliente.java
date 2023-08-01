package pi.com.pessoa;

import javax.persistence.*;

@Entity(name = "cliente")
public class Cliente extends Pessoa {

    public Cliente(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    public Cliente() {
        super();
    }

    public String toString() {
        return "\n|id: " + super.getId() + "|nome: " + super.getNome() + "|idade: " + super.getIdade() + "|cpf: " + super.getIdade() + "|\n";

    }
}
