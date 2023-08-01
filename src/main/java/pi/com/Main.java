package pi.com;

import pi.com.daos.ClienteDao;
import pi.com.daos.Endereco_ClienteDAO;
import pi.com.daos.Telefone_ClienteDAO;
import pi.com.endereco.EnderecoCliente;
import pi.com.pessoa.Cliente;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //testes CRUD cliente
       /* ClienteDao.cadastrarCliente("vinicius",20,"184.159.256-03");
        System.out.println(ClienteDao.getClientes().toString());
        System.out.println(ClienteDao.getCliente(3));
        ClienteDao.atualizarCliente(3,"idade", String.valueOf(30));
        ClienteDao.deletarCliente(3);*/

        //testes CRUD telefone_clientes
        /*Telefone_ClienteDAO.cadastrarTelefone("980252603", ClienteDao.getCliente(3));
        Telefone_ClienteDAO.atualizarNumero("987542556",1,ClienteDao.getCliente(3));
        System.out.println(Telefone_ClienteDAO.getTelefoneCliente(3));
        Telefone_ClienteDAO.deletarNumero(7,ClienteDao.getCliente(3));*/

        //testes CRUD endereco_clientes
        /*Cliente c = ClienteDao.getCliente(3);
        EnderecoCliente endereco = new EnderecoCliente(c, "31670000", "Céu Azul C", "Belo Horizonte", "MG");
        Endereco_ClienteDAO.cadastrarEndereco(endereco);
        Endereco_ClienteDAO.atualizarEndereco(3, "rua", "antonio josé dos santos", c);
        Endereco_ClienteDAO.deletarEndereco(9, c);
        System.out.println(Endereco_ClienteDAO.getEnderecoCliente(3));*/
    }
}