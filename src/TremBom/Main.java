package TremBom.Factory;

import TremBom.Endereco.Endereco;
import static TremBom.Factory.cargoFactory.cFactory;
import static TremBom.Factory.ferroviariaFactory.fFactory;
import static TremBom.Factory.salarioFactory.sFactory;
import TremBom.Pessoas.pCliente;
import TremBom.Pessoas.pFunc;
import TremBom.Telefone.Telefone;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "ISO-8859-1");

        ArrayList<pCliente> clientes = new ArrayList<>();
        ArrayList<pFunc> funcionarios = new ArrayList<>();
        Telefone t = new Telefone();
        Endereco e = new Endereco();
        String continuar = "sim";
        String tipo;
        String cpf;
        int opcao = 0;
        int indice = 0;

        do {
            System.out.println("""
                               1- cadastro
                               2- pesquisa
                               0- sair""");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("""
                                       CADASTROS:
                                       1- cadastro de pessoas
                                       2- cadastro de telfones
                                       3- cadastro de endereços
                                       4- retornar""");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("CADASTRO DE PESSOAS:");
                            continuar = "sim";
                            while (!"nao".equals(continuar)) {

                                System.out.println("tipo de pessoa, funcionario ou cliente");
                                tipo = sc.next();
                                sc.nextLine();
                                System.out.println("nome");
                                String nome = sc.nextLine();
                                System.out.println("idade");
                                int idade = sc.nextInt();
                                System.out.println("cpf");
                                cpf = sc.next();
                                sc.nextLine();

                                if ("cliente".equals(tipo)) {
                                    pCliente cliente = (pCliente) PessoasFactory.pFactory(tipo, nome, idade, cpf);
                                    clientes.add(cliente);
                                    System.out.println("funcionario cadastrado");
                                    System.out.println("deseja continuar?");
                                    continuar = sc.next();
                                } else if ("funcionario".equals(tipo)) {
                                    pFunc funcionario = (pFunc) PessoasFactory.pFactory(tipo, nome, idade, cpf);
                                    System.out.println("informe o local de trabalho");
                                    System.out.println("nome da estação:");
                                    String estacao = sc.nextLine();
                                    System.out.println("cidade:");
                                    String cidade = sc.nextLine();
                                    System.out.println("estado: MG ou SP");
                                    String estado = sc.nextLine();
                                    funcionario.setFerroviaria(fFactory(estacao, cidade, estado));
                                    System.out.println("informe o cargo: adm, gerente ou atendente");
                                    String cargo = sc.nextLine();
                                    funcionario.setCargo(cFactory(cargo));
                                    funcionario.setSalario(sFactory(cargo));
                                    funcionarios.add(funcionario);
                                    System.out.println("funcionario cadastrado");
                                    System.out.println("deseja continuar?");
                                    continuar = sc.next();
                                } else {
                                    System.out.println("tipo invalido");
                                    System.out.println("deseja continuar?");
                                    continuar = sc.next();
                                }
                            }
                            break;
                        case 2:
                            System.out.println("CADASTRO DE TELEFONES");
                            sc.nextLine();
                            System.out.println("F- funcionario  C- cliente");
                            tipo = sc.nextLine().toUpperCase();
                            System.out.println("informe o indice");
                            indice = sc.nextInt();

                            switch (tipo) {
                                case "C" -> {
                                    if (indice > clientes.size()) {
                                        System.out.println("cliente não encontrado");
                                    } else {
                                        System.out.println("informe o numero");
                                        int num = sc.nextInt();
                                        t.cadastrarTelefone(num,clientes.get(indice));
                                        System.out.println("telefone cadastrado");
                                    }
                                }
                                case "F" -> {
                                    if (indice > funcionarios.size()) {
                                        System.out.println("funcionario nao encontrado");
                                    } else {
                                        System.out.println("informe o numero");
                                        int num = sc.nextInt();
                                        t.cadastrarTelefone(num, funcionarios.get(indice));
                                        System.out.println("celular cadastrado");
                                    }
                                }
                            }
                            break;

                        case 3:
                            sc.nextLine();
                            System.out.println("CADASTRO DE ENDEREÇOS");
                            System.out.println("funcionario ou cliente");
                            tipo = sc.nextLine();
                            System.out.println("informe o indice");
                            indice = sc.nextInt();
                            sc.nextLine();
                            System.out.println("RUA");
                            String rua = sc.nextLine();
                            System.out.println("CIDADE");
                            String cidade = sc.nextLine();
                            System.out.println("ESTADO");
                            String estado = sc.nextLine();
                            System.out.println("CEP");
                            String cep = sc.nextLine();

                            switch (tipo) {
                                case "cliente":
                                    if (clientes.size() < indice) {
                                        System.out.println("cliente nao encontrado");
                                    } else {
                                        e.cadastrarEndereco(clientes.get(indice), cep, rua, cidade, estado);
                                        System.out.println("endereço cadastrado");
                                    }
                                    break;
                                case "funcionario":
                                    if (funcionarios.size() < indice) {
                                        System.out.println("funcionario nao encontrado");
                                    } else {
                                        e.cadastrarEndereco(funcionarios.get(indice), cep, rua, cidade,estado);
                                        System.out.println("endereço cadastrado");
                                    }
                            }
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("PESQUISAS");
                    System.out.println("1- pesquisa de pessoas\n"
                            + "2- pesquisa de telefons\n"
                            + "3- pesquisar endereços\n"
                            + "4- retornar");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("PESQUISA DE PESSOAS");
                            System.out.println("tipo de pessoa para pesquisar");
                            System.out.println("funcionario ou cliente");
                            tipo = sc.next();
                            System.out.println("informe o indece");
                            indice = sc.nextInt();

                            if ("funcionario".equals(tipo)) {
                                if (funcionarios.size() < indice) {
                                    System.out.println("nem um funcionario no indice " + indice);
                                } else {
                                    System.out.println(funcionarios.get(indice).retornarDados());
                                }
                            } else if ("cliente".equals(tipo)) {
                                if (clientes.size() < indice) {
                                    System.out.println("nem um cliente no indice " + indice);
                                } else {
                                    System.out.println(clientes.get(indice).retornarDados());
                                }
                            } else {
                                System.out.println("tipo invalido");
                            }
                            break;
                        case 2:
                            System.out.println("PESQUISA DE TELEFONES");
                            System.out.println("informe o cpf");
                            sc.nextLine();
                            cpf = sc.nextLine();
                            t.pesquisarTelefones(cpf);
                            break;

                        case 3:
                            System.out.println("PESQUISA ENDEREÇOS");
                            System.out.println("informe o cpf");
                            sc.nextLine();
                            cpf = sc.nextLine();
                            e.pesquisarEndereco(cpf);
                            break;
                        case 4:
                            break;
                    }
                    break;
            }
        } while (opcao != 0);

    }

}
