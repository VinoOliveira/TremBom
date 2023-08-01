package pi.com.daos;

import pi.com.Manager;
import pi.com.pessoa.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDao {

    //pega todos os clientes cadastrados e os coloca em uma lista
    public static List getClientes() {
        try{
            EntityManager entityManager = Manager.getManager();
            TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM cliente c", Cliente.class);
            return query.getResultList();
        }catch (Exception e){
            System.out.println("erro ao pegar clientes."+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    // pega um cliente do banco de dados através do id
    public static Cliente getCliente(int id){
        try{
            EntityManager entityManager = Manager.getManager();
            Cliente cliente = entityManager.find(Cliente.class,id);
            entityManager.close();
            return cliente;
        }catch (Exception e){
            System.out.println("erro ao pegar cliente."+e.getMessage());
            return null;
        }

    }
    //cria e cadastra um cliente no banco de dados
    public static void cadastrarCliente(String nome, int idade, String cpf) {
        try {
            Cliente cliente = new Cliente(nome, idade, cpf);
            EntityManager entityManager = Manager.getManager();
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar o cliente: " + e.getMessage());
        }
    }
    //atualiza os dados de um cliente, nome, idade ou cpf
    public static void atualizarCliente(int id, String campo, String novoValor) {
        try {
            EntityManager entityManager = Manager.getManager();
            Cliente cliente = entityManager.find(Cliente.class, id);

            if (cliente != null) {
                entityManager.getTransaction().begin();
                switch (campo.toLowerCase()) {
                    case "nome":
                        cliente.setNome(novoValor);
                        break;
                    case "idade":
                        int novaIdade = Integer.parseInt(novoValor);
                        cliente.setIdade(novaIdade);
                        break;
                    case "cpf":
                        cliente.setCpf(novoValor);
                        break;
                    default:
                        entityManager.getTransaction().rollback();
                        return;
                }
                entityManager.getTransaction().commit();
                entityManager.close();
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //deleta um usuario pelo id
    public static void deletarCliente(int Id) {
        EntityManager entityManager = Manager.getManager();
        try {
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, Id);

            if (cliente != null) {
                entityManager.remove(cliente);
                entityManager.getTransaction().commit();
                entityManager.close();
                System.out.println("Cliente com ID " + Id + " foi excluído com sucesso!");
            } else {
                System.out.println("Cliente com ID " + Id + " não foi encontrado. Nenhum cliente foi excluído.");
            }
        } catch (Exception e) {
            if (entityManager.getTransaction() != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }
}

