package pi.com.daos;

import pi.com.Manager;
import pi.com.endereco.EnderecoCliente;
import pi.com.pessoa.Cliente;
import pi.com.telefone.TelefoneCliente;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class Endereco_ClienteDAO {
    //pega todos os enderecos associados a um cliente por id
    public static List getEnderecoCliente(int cliente) {
        try {
            EntityManager entityManager = Manager.getManager();
            String jpql = "SELECT ec FROM endereco_cliente ec WHERE ec.cliente.id = :cliente";
            List<EnderecoCliente> enderecoCliente = entityManager.createQuery(jpql, EnderecoCliente.class)
                    .setParameter("cliente", cliente)
                    .getResultList();
            entityManager.close();
            return enderecoCliente;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //cadastra o endereço de um cliente
    public static void cadastrarEndereco(EnderecoCliente endereco) {
        try {
            EntityManager entityManager = Manager.getManager();
            entityManager.getTransaction().begin();
            entityManager.persist(endereco);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("endereco cadastrado!!");
        } catch (Exception e) {
            System.out.println("erro." + e.getMessage());
        }
    }

    //atualiza os dados cadastrais do endereço
    public static void atualizarEndereco(int idEndreco, String campo, String novoValor, Cliente cliente) {
        EntityManager entityManager = Manager.getManager();
        EnderecoCliente endereco = entityManager.find(EnderecoCliente.class, idEndreco);
        try {
            if (endereco == null) {
                throw new Exception("endereço não encontrado, verifique o id");
            }
            if (endereco.getCliente().getId() != cliente.getId()) {
                throw new Exception("endereço não encontrado, verifique o id");
            }
            entityManager.getTransaction().begin();
            switch (campo.toLowerCase()) {
                case "cep":
                    endereco.setCep(novoValor);
                    break;
                case "rua":
                    endereco.setRua(novoValor);
                    break;
                case "cidade":
                    endereco.setCidade(novoValor);
                    break;
                case "estado:":
                    endereco.setEstado(novoValor);
                    break;
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("endereço atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("erro." + e.getMessage());
        }
    }

    //deleta um endereço
    public static void deletarEndereco(int idEndereco, Cliente cliente) {
        EntityManager entityManager = Manager.getManager();
        entityManager.getTransaction().begin();
        EnderecoCliente enderecoCliente = entityManager.find(EnderecoCliente.class, idEndereco);
        try {
            if (enderecoCliente == null) {
                throw new Exception("endereço não encontrado, verifique o id");
            }
            if (enderecoCliente.getCliente().getId() != cliente.getId()) {
                throw new Exception("id invalido");
            }
            entityManager.remove(enderecoCliente);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println("erro." + e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
}
