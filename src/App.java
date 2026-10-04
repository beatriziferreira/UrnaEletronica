import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int opcao = 0;
        Scanner scan = new Scanner(System.in);
        Sistema sistema = new Sistema();
        App.popularExemplos(sistema);
        boolean finalizarVotacao = false;

        do {
        System.out.println("= URNA ELETRÔNICA - JUSTIÇA ELEITORAL =");
        System.out.println("---------------------------------------");
        System.out.println("Escolha uma opção: ");
        System.out.println("[1] - Cadastrar candidato");
        System.out.println("[2] - Iniciar votação");
        System.out.println("[0] - Desligar urna");

        try {
            opcao = Integer.parseInt(scan.next());
        } catch (NumberFormatException e) {
            System.out.print("Valor inválido. Digite um número. ");
            opcao = Integer.parseInt(scan.next());
        }

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do candidato: ");
                String nome = scan.next();
                System.out.println("Digite o cargo do candidato: ");
                String cargo = scan.next();
                System.out.println("Digite o partido do candidato: ");
                String partido = scan.next();
                System.out.println("Digite o número do candidato: ");
                try {
                    int numero = Integer.parseInt(scan.next());
                    sistema.cadastrarCandidato(nome, cargo, partido, numero);
                    System.out.println("Candidato cadastrado com sucesso!");
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao cadastrar candidato: " + e.getMessage());
                } finally {
                    System.out.println("FIM");
                }
                break;
            case 2:
                int i = 0;
                int num = 0;
                Candidato cand = null;
                boolean confirma = false;
                int confirmar = 0;
                do {
                    while (i < 5) {
                        do {
                            System.out.println("DEPUTADO FEDERAL");
                            System.out.println("[0] - Voto nulo");
                            System.out.println("[1] - Voto em branco");
                            System.out.println("Digite o número do candidato [][][][]: ");
                            num = scan.nextInt();
                            if (num != 0 && num != 1) {
                                if (sistema.buscarCandidato(num) != null) {
                                    cand = sistema.buscarCandidato(num);
                                    System.out.println("---------------------------------------");
                                    System.out.println(cand.toString());
                                    System.out.println("---------------------------------------");
                                    System.out.println("[1] - Confirmar");
                                    System.out.println("[2] - Limpar");
                                    confirmar = scan.nextInt();
                                    if (confirmar == 1) {
                                        confirma = cand.adicionarVoto();
                                        System.out.println("PLIM!");
                                        i++;
                                    } else if (confirmar == 2) {
                                        System.out.println("Voto limpo. Digite novamente.");
                                        confirma = false;
                                    } else {
                                        System.out.println("Opção inválida.");
                                        confirma = false;
                                    }

                                }
                            } else if (num == 1) {
                                sistema.votarBranco();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;

                            } else if (num == 0) {
                                sistema.votarNulo();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;
                            }
                        } while (!confirma);

                        do {
                            System.out.println("DEPUTADO ESTADUAL");
                            System.out.println("[0] - Voto nulo");
                            System.out.println("[1] - Voto em branco");
                            System.out.println("Digite o número do candidato [][][][][]: ");
                            num = scan.nextInt();
                            if (num != 0 && num != 1) {
                                if (sistema.buscarCandidato(num) != null) {
                                    cand = sistema.buscarCandidato(num);
                                    System.out.println("---------------------------------------");
                                    System.out.println(cand.toString());
                                    System.out.println("---------------------------------------");
                                    System.out.println("[1] - Confirmar");
                                    System.out.println("[2] - Limpar");
                                    confirmar = scan.nextInt();
                                    if (confirmar == 1) {
                                        confirma = cand.adicionarVoto();
                                        System.out.println("PLIM!");
                                        i++;
                                    } else if (confirmar == 2) {
                                        System.out.println("Voto limpo. Digite novamente.");
                                        confirma = false;
                                    } else {
                                        System.out.println("Opção inválida.");
                                        confirma = false;
                                    }
                                }
                            } else if (num == 1) {
                                sistema.votarBranco();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;

                            } else if (num == 0) {
                                sistema.votarNulo();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;
                            }
                        } while (!confirma);

                        do {
                            System.out.println("SENADOR");
                            System.out.println("[0] - Voto nulo");
                            System.out.println("[1] - Voto em branco");
                            System.out.println("Digite o número do candidato [][][]: ");
                            num = scan.nextInt();
                            if (num != 0 && num != 1) {
                                if (sistema.buscarCandidato(num) != null) {
                                    cand = sistema.buscarCandidato(num);
                                    System.out.println("---------------------------------------");
                                    System.out.println(cand.toString());
                                    System.out.println("---------------------------------------");
                                    System.out.println("[1] - Confirmar");
                                    System.out.println("[2] - Limpar");
                                    confirmar = scan.nextInt();
                                    if (confirmar == 1) {
                                        confirma = cand.adicionarVoto();
                                        System.out.println("PLIM!");
                                        i++;
                                    } else if (confirmar == 2) {
                                        System.out.println("Voto limpo. Digite novamente.");
                                        confirma = false;
                                    } else {
                                        System.out.println("Opção inválida.");
                                        confirma = false;
                                    }
                                }
                            } else if (num == 1) {
                                sistema.votarBranco();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;

                            } else if (num == 0) {
                                sistema.votarNulo();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;
                            }
                        } while (!confirma);

                        do {
                            System.out.println("GOVERNADOR");
                            System.out.println("[0] - Voto nulo");
                            System.out.println("[1] - Voto em branco");
                            System.out.println("Digite o número do candidato [][]: ");
                            num = scan.nextInt();
                            if (num != 0 && num != 1) {
                                if (sistema.buscarCandidato(num) != null) {
                                    cand = sistema.buscarCandidato(num);
                                    System.out.println("---------------------------------------");
                                    System.out.println(cand.toString());
                                    System.out.println("---------------------------------------");
                                    System.out.println("[1] - Confirmar");
                                    System.out.println("[2] - Limpar");
                                    confirmar = scan.nextInt();
                                    if (confirmar == 1) {
                                        confirma = cand.adicionarVoto();
                                        System.out.println("PLIM!");
                                        i++;
                                    } else if (confirmar == 2) {
                                        System.out.println("Voto limpo. Digite novamente.");
                                        confirma = false;
                                    } else {
                                        System.out.println("Opção inválida.");
                                        confirma = false;
                                    }
                                }
                            } else if (num == 1) {
                                sistema.votarBranco();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;

                            } else if (num == 0) {
                                sistema.votarNulo();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;
                            }
                        } while (!confirma);

                        do {
                            System.out.println("PRESIDENTE");
                            System.out.println("[0] - Voto nulo");
                            System.out.println("[1] - Voto em branco");
                            System.out.println("Digite o número do candidato [][]: ");
                            num = scan.nextInt();
                            if (num != 0 && num != 1) {
                                if (sistema.buscarCandidato(num) != null) {
                                    cand = sistema.buscarCandidato(num);
                                    System.out.println("---------------------------------------");
                                    System.out.println(cand.toString());
                                    System.out.println("---------------------------------------");
                                    System.out.println("[1] - Confirmar");
                                    System.out.println("[2] - Limpar");
                                    confirmar = scan.nextInt();
                                    if (confirmar == 1) {
                                        confirma = cand.adicionarVoto();
                                        System.out.println("PLIM!");
                                        i++;
                                    } else if (confirmar == 2) {
                                        System.out.println("Voto limpo. Digite novamente.");
                                        confirma = false;
                                    } else {
                                        System.out.println("Opção inválida.");
                                        confirma = false;
                                    }
                                }
                            } else if (num == 1) {
                                sistema.votarBranco();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;

                            } else if (num == 0) {
                                sistema.votarNulo();
                                confirma = true;
                                System.out.println("PLIM!");
                                i++;
                            }
                        } while (!confirma);
                    }
                    System.out.println("Deseja finalizar a votação? [1] - Sim | [2] - Não");
                    int finalizar = scan.nextInt();
                    if (finalizar == 1) {
                        System.out.println("Digite a senha para finalizar a votação:");
                        int senha = scan.nextInt();
                        if (senha == sistema.getSenha()) {
                            finalizarVotacao = true;
                            sistema.organizar();
                            sistema.exibirResultados();
                        } else {
                            System.out.println("Senha incorreta.");
                        }
                    } else if (finalizar == 2) {
                        finalizarVotacao = false;
                        i = 0;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                } while (!finalizarVotacao);

                break;
            case 0:
                System.out.println("Desligando urna...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    } while (!finalizarVotacao); 
        scan.close();
    }

    private static void popularExemplos(Sistema sistema) {
        sistema.cadastrarCandidato("Kleinubing", "Deputado Federal", "PL", 2288);
        sistema.cadastrarCandidato("Marcos", "Deputado Estadual", "PT", 13333);
        sistema.cadastrarCandidato("Amin", "Senador", "PP", 111);
        sistema.cadastrarCandidato("Merísio", "Governador", "PSB", 40);
        sistema.cadastrarCandidato("Lula", "Presidente", "PT", 13);

        sistema.cadastrarCandidato("Micael", "Deputado Federal", "PSDB", 6767);
        sistema.cadastrarCandidato("Belzebub", "Deputado Estadual", "PL", 22000);
        sistema.cadastrarCandidato("Décio", "Senador", "PT", 133);
        sistema.cadastrarCandidato("Lobisomen", "Governador", "PSOL", 50);
        sistema.cadastrarCandidato("Tranca Rua", "Presidente", "PA", 07);

    }
}
