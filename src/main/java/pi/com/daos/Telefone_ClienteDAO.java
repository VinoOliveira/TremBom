package pi.com.daos;

import pi.com.Manager;
import pi.com.pessoa.Cliente;
import pi.com.telefone.TelefoneCliente;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class Telefone_ClienteDAO {

    //pega todos os numeros de telefone associados a um cliente
    public static List getTelefoneCliente(int cliente) {
        try {
            EntityManager entityManager = Manager.getManager();
            String jpql = "SELECT tc FROM telefone_cliente tc WHERE tc.cliente.id = :cliente";
            List<TelefoneCliente> telefoneClienteList = entityManager.createQuery(jpql, TelefoneCliente.class)
                    .setParameter("cliente", cliente)
                    .getResultList();
            entityManager.close();
            return telefoneClienteList;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //cadastra um telefone de um cliente
    public static void cadastrarTelefone(TelefoneCliente tel) {
        try {
            EntityManager entityManager = Manager.getManager();
            entityManager.getTransaction().begin();
            entityManager.persist(tel);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("telefone cadastrado!!");
        } catch (Exception e) {
            System.out.println("erro." + e.getMessage());
        }

    }

    //atualiza o numero de telefone
    public static void atualizarNumero(String novoNumero, int id, Cliente cliente) {
        try {
            EntityManager entityManager = Manager.getManager();
            TelefoneCliente telefoneCliente = entityManager.find(TelefoneCliente.class, id);
            if (telefoneCliente == null) {
                throw new Exception("telefone não encontrado");
            }
            if (telefoneCliente.getCliente().getId() != cliente.getId()) {
                throw new Exception("ID incorreto, por favor verifique");
            }
            entityManager.getTransaction().begin();
            telefoneCliente.setTelefone(novoNumero);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("telefone atualizado");
        } catch (Exception e) {
            System.out.println("erro." + e.getMessage());
        }
    }

    //deleta o numero de telefone
    public static void deletarNumero(int id, Cliente cliente) {
        EntityManager entityManager = Manager.getManager();
        try {
            entityManager.getTransaction().begin();
            TelefoneCliente telefoneCliente = entityManager.find(TelefoneCliente.class, id);
            if (telefoneCliente == null) {
                throw new Exception("telefone não encontrado");
            }
            if (telefoneCliente.getCliente().getId() != cliente.getId()) {
                throw new Exception("o ID está incorreto, verifique");
            }
            entityManager.remove(telefoneCliente);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("numero deletado com sucesso");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("erro." + e.getMessage());
        }
    }

}



