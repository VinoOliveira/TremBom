package TremBom.Telefone;

import TremBom.Pessoas.Pessoas;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Telefone {

    int numero;
    Pessoas pessoa;
    public ArrayList<Telefone> tel = new ArrayList<>();

    public void cadastrarTelefone(int num, Pessoas pessoa) {

        tel.add(new Telefone(num, pessoa));
    }

    public void pesquisarTelefones(String cpf) {
        List<Telefone> pesquisa;
        pesquisa = (List<Telefone>) tel.stream()
                .filter(t -> t.getPessoa().getCpf().equals(cpf))
                .collect(Collectors.toList());
        System.out.println(pesquisa.toString());

    }

    public String toString() {
        return "" + getNumero();
    }

    public Telefone(int numero, Pessoas pessoa) {
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public Telefone() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public ArrayList<Telefone> getTel() {
        return tel;
    }

    public void setTel(ArrayList<Telefone> tel) {
        this.tel = tel;
    }

}
