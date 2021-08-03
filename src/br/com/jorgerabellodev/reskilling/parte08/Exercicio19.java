package br.com.jorgerabellodev.reskilling.parte08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Uma empresa de eletrodomésticos está realizando um sorteio de uma Ferrari F-50, do qual participarão
 * todos os que comprarem pelo menos cinco produtos de uma só vez nas lojas autorizadas. Faça um pro-
 * grama que:
 * <p>
 * a) leia os dados de todos os clientes, como nome, data de nascimento, CPF, RG, cidade em que mora, endereço e
 * quantidade de eletrodomésticos adquiridos pelo cliente. Deve-se incluir um campo para o número do registro,
 * que vai de 1 até 9999;
 * <p>
 * b) faça o sorteio entre os clientes participantes. Somente os clientes que compraram mais que cinco equipamentos
 * deverão participar. Será sorteado um número, e o cliente que tiver o registro com esse número será o ganhador.
 */
public class Exercicio19 {

    static Scanner ler = new Scanner(System.in);
    static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
    static boolean continuar;

    public static void main(String[] args) {

        boolean continuar = true;
        int opcaoMenu;
        boolean continuarMenu = true;
        int opcaoMenuContinuar;

        Cliente cliente = new Cliente();
        Sorteio sorteio = new Sorteio();

        while (continuar) {

            try {
                System.out.println("\nEscolha uma opçaõ: \n1 - Cadastrar  cliente; \n2 - Sortear prêmio;");
                opcaoMenu = ler.nextInt();


                switch (opcaoMenu) {

                    case 1:
                        cliente.cadastrarCliente();
                        sorteio.quantidadeDeProdutoCompradoPorCliente();
                        break;
                    case 2:
                        sorteio.imprimir();
                        break;
                }


                while (continuarMenu) {
                    System.out.println("\n\nDeseja continuar 1 - SIM / 2 - NÃO");
                    opcaoMenuContinuar = ler.nextInt();
                    if (opcaoMenuContinuar == 1) {
                        continuar = true;
                        break;
                    } else if (opcaoMenuContinuar == 2) {
                        System.out.println("Obrigado por usar o programa");
                        continuar = false;
                        return;
                    } else {
                        System.out.println("Opção inválida");
                    }
                }

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Programa não contém letra ou simbolo.");
                break;
            }

        }
    }

    static class Cliente {
        String nome;
        String dataNascimento;
        Date dataNascimentoConvertida;
        long cpf;
        int rg;
        String nomeCidade;
        String endereco;
        int qtdProduto;
        int numuroDoRegistro;
        static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        public Cliente(String nome, String dataNascimento, long cpf, int rg, String nomeCidade, String endereco,
                       int qtdProduto, int numuroDoRegistro) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.cpf = cpf;
            this.rg = rg;
            this.nomeCidade = nomeCidade;
            this.endereco = endereco;
            this.qtdProduto = qtdProduto;
            this.numuroDoRegistro = numuroDoRegistro;
        }

        public Cliente() {
        }

        public void cadastrarCliente() {
            try {
                System.out.println("Informe o nome do cliente");
                nome = ler.next();
                if (!existeCliente(nome)) {

                    System.out.println("Informe a data de nascimento");
                    dataNascimento = ler.next();
                    continuar = validarData(dataNascimento);

                    while (continuar) {
                        System.out.println("Informe a data de nascimento");
                        dataNascimento = ler.next();
                        continuar = validarData(dataNascimento);
                    }

                    System.out.println("Informe o número do CPF:");
                    cpf = ler.nextLong();

                    System.out.println("Informe o número do RG:");
                    rg = ler.nextInt();

                    System.out.println("Informe o nome da cidade do cliente:");
                    nomeCidade = ler.next().concat(ler.nextLine());

                    System.out.println("Informe o endereço do cliente");
                    endereco = ler.next().concat(ler.nextLine());
                    System.out.println("Informe a quantidade do produto adquirido");
                    qtdProduto = ler.nextInt();

                    System.out.println("Informe o número de registro do produto:");
                    numuroDoRegistro = ler.nextInt();
                    continuar = existeNumeroRegistro(numuroDoRegistro);

                    while (continuar) {
                        System.out.println("Número de registro já existe, informe o número de registro válido:");
                        numuroDoRegistro = ler.nextInt();
                        continuar = existeNumeroRegistro(numuroDoRegistro);

                    }

                    Cliente cliente = new Cliente(nome, dataNascimento, cpf, rg, nomeCidade, endereco, qtdProduto,
                            numuroDoRegistro);
                    listaClientes.add(cliente);

                } else {
                    System.out.println("Cliente já existe no cadastro!");
                }
            } catch (InputMismatchException inputMismatchException) {
            }
        }

        public boolean existeCliente(String cliente) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).nome.equalsIgnoreCase(cliente)) {
                    return true;
                }
            }
            return false;
        }

        public boolean validarData(String dataVencimentoInserida) {
            try {
                formatoData.setLenient(false);
                dataNascimentoConvertida = formatoData.parse(dataVencimentoInserida);
            } catch (ParseException parseException) {
                System.out.println("Data foi digitada no formato errado, digite a da neste formato dd/MM/yy");
                return true;
            }
            return false;
        }

        public int verificarCliente() {
            return listaClientes.size();
        }

        public boolean existeNumeroRegistro(int numuroDoRegistro) {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).numuroDoRegistro == numuroDoRegistro) {
                    return true;
                }

            }
            return false;
        }
    }

    static class Sorteio {
        long cpf;
        Cliente cliente = new Cliente();
        static ArrayList<Sorteio> listaParaSorteio = new ArrayList<Sorteio>();

        public Sorteio(long cpf) {
            this.cpf = cpf;
        }

        public Sorteio() {
        }

        public Sorteio quantidadeDeProdutoCompradoPorCliente() {
            long tempCpf;

            if (cliente.verificarCliente() > 0) {
                for (int i = 0; i < cliente.verificarCliente(); i++) {
                    if (cliente.listaClientes.get(i).qtdProduto > 5) {
                        if (verificarSeExisteClienteParaSorteio(cliente.listaClientes.get(i).cpf) == false) {
                            tempCpf = cliente.listaClientes.get(i).cpf;
                            Sorteio sorteio = new Sorteio(tempCpf);
                            listaParaSorteio.add(sorteio);


                        }
                    }
                }
            } else {
                System.out.println("Lista vazia não pode realizar sorteio");
            }
            Collections.shuffle(listaParaSorteio);
            return listaParaSorteio.get((int) Math.random() * listaParaSorteio.size());
        }

        public boolean verificarSeExisteClienteParaSorteio(long cpf) {
            for (int i = 0; i < listaParaSorteio.size(); i++) {
                if (listaParaSorteio.get(i).cpf == cpf) {
                    return true;
                }
            }
            return false;
        }

        public void imprimir() {

            for (int i = 0; i < listaParaSorteio.size(); i++) {
                System.out.println("Cliente: " + cliente.listaClientes.get(i).nome + " comprou mais de 5 eletrodomésticos com o CPF >>>>> " + listaParaSorteio.get(i).cpf);
            }

            for (int i = 0; i < 1; i++) {
                System.out.println("Sorteado foi o CPF >>>> " + quantidadeDeProdutoCompradoPorCliente().cpf);

            }
        }
    }
}

