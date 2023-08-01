package pi.com.endereco;

import pi.com.pessoa.Cliente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="endereco_cliente")
public class EnderecoCliente extends Endereco {
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    public EnderecoCliente(Cliente cliente,String cep, String rua, String cidade, String estado) {
        super(cep, rua, cidade, estado);
        this.cliente = cliente;
    }
    public EnderecoCliente(){
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String toString(){
        return "\nid: "+this.getId()+" |id cliente: "+this.cliente.getId()+" |cep: "+this.getCep()
                +" |rua: "+this.getRua()+ " |cidade: "+this.getCidade()+" |estado: "+this.getEstado();
    }
}
