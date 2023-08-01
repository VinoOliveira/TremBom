package pi.com.telefone;

import pi.com.pessoa.Cliente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "telefone_cliente")
public class TelefoneCliente extends Telefone {
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public TelefoneCliente(String telefone,Cliente cliente) {
        super(telefone);
        this.cliente = cliente;
    }

    public TelefoneCliente() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String toString() {
        return "\nid: " + super.getId() + "| id cliente: " + cliente.getId() + "| numero: " + super.getTelefone()+"\n";
    }
}
