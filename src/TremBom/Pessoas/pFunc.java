package TremBom.Pessoas;

import TremBom.Cargo.Cargo;
import TremBom.Ferroviaria.Ferroviaria;
import TremBom.Salarios.Salario;




public class pFunc extends Pessoas {

    Cargo cargo;
    Salario salario;
    Ferroviaria ferroviaria;
   
    

    public pFunc(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    @Override
    public String retornarDados() {
        return "nome: " + getNome()
                + "\nidade: " + getIdade()
                + "\ncpf: " + getCpf()
                + "\nestação ferroviaria: " + ferroviaria.getNome()
                + "\ncidade:" + ferroviaria.getCidade()
                + "\nestado: " + ferroviaria.getEstado()
                + "\ncargo: " + cargo.getNomeCargo()
                + "\nsalario: " + salario.getValor() + "\n";
    }
    
   

    public void setCargo(Cargo Cargo) {
        this.cargo = Cargo;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public void setFerroviaria(Ferroviaria ferroviaria) {
        this.ferroviaria = ferroviaria;
    }
    
   
}
