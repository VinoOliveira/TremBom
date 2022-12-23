package TremBom.Endereco;

import TremBom.Pessoas.Pessoas;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Endereco {

    private Pessoas pessoa;
    private String cep;
    private String rua;
    private String cidade;
    private String estado;

    public ArrayList<Endereco> endereco = new ArrayList<>();

    public void cadastrarEndereco(Pessoas pessoa, String cep, String rua, String cidade, String estado) {
        endereco.add(new Endereco(pessoa, cep, rua, cidade, estado));
    }

    public void pesquisarEndereco(String cpf) {
        List<Endereco> pesquisaEndereco;
        pesquisaEndereco = (List<Endereco>) endereco.stream()
                .filter(e -> e.getPessoa().getCpf().equals(cpf))
                .collect(Collectors.toList());
        System.out.println(pesquisaEndereco.toString());
    }

  
    @Override
    public String toString() {
        return "ENDEREÇO:\n"
                + "Cep: " + getCep() + "\n"
                + "Cidade: " + getCidade() + "\n"
                + "Estado: " + getEstado() + "\n"
                + "Rua: " + getRua() + "\n"         
                + "";
    }

    public Endereco(Pessoas pessoa, String cep, String rua, String cidade, String estado) {
        this.pessoa = pessoa;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
