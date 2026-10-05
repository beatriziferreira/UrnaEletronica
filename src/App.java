import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int opcao = 0;
        Scanner scan = new Scanner(System.in);
        Sistema sistema = new Sistema();
        App.popular(sistema);
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
                    try {
                        String vice = null;
                        System.out.println("Digite o nome do candidato: ");
                        String nome = scan.next();
                        System.out.println("Digite o cargo do candidato: ");
                        String cargo = scan.next();
                        System.out.println("Digite o partido do candidato: ");
                        String partido = scan.next();
                        System.out.println("Digite o número do candidato: ");
                        int numero = Integer.parseInt(scan.next());

                        if (cargo.equalsIgnoreCase("Presidente")) {
                            System.out.println("Digite o vice do candidato: ");
                            vice = scan.next();
                            Candidato c1 = new Presidente(nome, cargo, partido, numero, vice);
                            sistema.cadastrarCandidato(c1);
                        } else if (cargo.equalsIgnoreCase("Governador")){
                            System.out.println("Digite o vice do candidato: ");
                            vice = scan.next();
                            Candidato c1 = new Governador(nome, cargo, partido, numero, vice);
                            sistema.cadastrarCandidato(c1);
                        } else if (cargo.equalsIgnoreCase("Senador")){
                            System.out.println("Digite o suplente 1 do candidato: ");
                            String sup1 = scan.next();
                            System.out.println("Digite o suplente 2 do candidato: ");
                            String sup2 = scan.next();
                            Candidato c1 = new Senador(nome, cargo, partido, numero, sup1, sup2);
                            sistema.cadastrarCandidato(c1);
                        } else if (cargo.equalsIgnoreCase("DeputadoFederal")){
                            Candidato c1 = new DeputadoFederal(nome, cargo, partido, numero);
                            sistema.cadastrarCandidato(c1);
                        } else if (cargo.equalsIgnoreCase("DeputadoEstadual")){
                            Candidato c1 = new DeputadoEstadual(nome, cargo, partido, numero);
                            sistema.cadastrarCandidato(c1);
                        } else {
                            System.out.println("Cargo inválido.");
                        }

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
                    System.out.println("Desligando urna...");
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

    private static void popular(Sistema sistema) {
        // PRESIDENTES
        sistema.cadastrarCandidato(new Presidente("Tranca Rua", "Presidente", "PT", 13, "Tampa Buraco"));
        sistema.cadastrarCandidato(new Presidente("Zé do WiFi", "Presidente", "PIZZA", 22, "Senha Errada"));
        sistema.cadastrarCandidato(new Presidente("Tonho do Zap", "Presidente", "ZAP", 33, "Grupo Silenciado"));
        sistema.cadastrarCandidato(new Presidente("Capitão Miojo", "Presidente", "MAC", 44, "Tempero Pronto"));
        sistema.cadastrarCandidato(new Presidente("Dona Planilha", "Presidente", "EXCEL", 55, "Ctrl C"));
        sistema.cadastrarCandidato(new Presidente("Professor Pardal", "Presidente", "GAMBI", 66, "Fio Desencapado"));
        sistema.cadastrarCandidato(new Presidente("Rei do Pix", "Presidente", "PIX", 77, "QR Code"));
        sistema.cadastrarCandidato(new Presidente("Seu Madruga", "Presidente", "BAR", 88, "Dona Florinda"));
        sistema.cadastrarCandidato(new Presidente("Cabo da Internet", "Presidente", "NET", 99, "Roteador"));
        sistema.cadastrarCandidato(new Presidente("Jair do Pastel", "Presidente", "PASTEL", 11, "Caldo de Cana"));

        // GOVERNADORES
        sistema.cadastrarCandidato(new Governador("Farmador de Aura", "Governador", "AURA", 12, "Brabo do Bairro"));
        sistema.cadastrarCandidato(new Governador("Rei do Pedágio", "Governador", "PEDAGIO", 23, "Sem Troco"));
        sistema.cadastrarCandidato(new Governador("Zé do Asfalto", "Governador", "BURACO", 34, "Mestre da Obra"));
        sistema.cadastrarCandidato(new Governador("Doutor Gambiarra", "Governador", "FIO", 45, "Fita Isolante"));
        sistema.cadastrarCandidato(new Governador("Tio do Churrasco", "Governador", "CARVAO", 56, "Linguiça"));
        sistema.cadastrarCandidato(new Governador("Influencer do Bairro", "Governador", "LIKE", 67, "Seguidor Fiel"));
        sistema.cadastrarCandidato(new Governador("Mestre do Café", "Governador", "CAFE", 78, "Pao de Queijo"));
        sistema.cadastrarCandidato(new Governador("Professor de Educação Física", "Governador", "FIT", 89, "Personal Treino"));
        sistema.cadastrarCandidato(new Governador("Fiscal do Sono", "Governador", "ZZZ", 90, "Travesseiro"));
        sistema.cadastrarCandidato(new Governador("Senhor Estaciona Aqui", "Governador", "VAGA", 21, "Pisca Alerta"));

        // SENADORES
        sistema.cadastrarCandidato(new Senador("Lobao", "Senador", "UIVO", 101, "Lobinho Um", "Lobinho Dois"));
        sistema.cadastrarCandidato(new Senador("Rei do Tererê", "Senador", "GELA", 202, "Canudo", "Erva Mate"));
        sistema.cadastrarCandidato(new Senador("Zé do Boteco", "Senador", "PETISCO", 303, "Coxinha", "Pastelzinho"));
        sistema.cadastrarCandidato(new Senador("Dona do Grupo", "Senador", "ADM", 404, "Silenciado", "Removido"));
        sistema.cadastrarCandidato(new Senador("Mestre do Discord", "Senador", "VOICE", 505, "Mute", "Ban"));
        sistema.cadastrarCandidato(new Senador("Rei da Soneca", "Senador", "SONO", 606, "Cobertor", "Travesseiro"));
        sistema.cadastrarCandidato(new Senador("Tio do Pavê", "Senador", "PAVE", 707, "Pave", "Pra Comer"));
        sistema.cadastrarCandidato(new Senador("Fiscal do Churrasco", "Senador", "CARNE", 808, "Faca", "Garfo"));
        sistema.cadastrarCandidato(new Senador("Doutor do Zap", "Senador", "FAKE", 909, "Bom Dia", "Boa Noite"));
        sistema.cadastrarCandidato(new Senador("Mãe do Pix", "Senador", "PIX", 110, "TED", "DOC"));

        // DEPUTADOS FEDERAIS
        sistema.cadastrarCandidato(new DeputadoFederal("Ctrl C", "DeputadoFederal", "COPIA", 1001));
        sistema.cadastrarCandidato(new DeputadoFederal("Ctrl V", "DeputadoFederal", "COLA", 2002));
        sistema.cadastrarCandidato(new DeputadoFederal("Zé do Mouse", "DeputadoFederal", "CLICK", 3003));
        sistema.cadastrarCandidato(new DeputadoFederal("Senhor Print", "DeputadoFederal", "SCREEN", 4004));
        sistema.cadastrarCandidato(new DeputadoFederal("Rei do Alt Tab", "DeputadoFederal", "ALT", 5005));
        sistema.cadastrarCandidato(new DeputadoFederal("Tio do Pendrive", "DeputadoFederal", "USB", 6006));
        sistema.cadastrarCandidato(new DeputadoFederal("Doutor Google", "DeputadoFederal", "BUSCA", 7007));
        sistema.cadastrarCandidato(new DeputadoFederal("Mestre do Bug", "DeputadoFederal", "DEBUG", 8008));
        sistema.cadastrarCandidato(new DeputadoFederal("Professor Null", "DeputadoFederal", "NULL", 9009));
        sistema.cadastrarCandidato(new DeputadoFederal("Senhor Sem Sinal", "DeputadoFederal", "WIFI", 1010));

        // DEPUTADOS ESTADUAIS
        sistema.cadastrarCandidato(new DeputadoEstadual("Mestre da Gambiarra", "DeputadoEstadual", "GAMBI", 10001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Zé do Ctrl Z", "DeputadoEstadual", "DESFAZ", 20002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Dona do Excel", "DeputadoEstadual", "XLS", 30003));
        sistema.cadastrarCandidato(new DeputadoEstadual("Rei da Senha", "DeputadoEstadual", "12345", 40004));
        sistema.cadastrarCandidato(new DeputadoEstadual("Tio do Bluetooth", "DeputadoEstadual", "BLU", 50005));
        sistema.cadastrarCandidato(new DeputadoEstadual("Fiscal do WiFi", "DeputadoEstadual", "NET", 60006));
        sistema.cadastrarCandidato(new DeputadoEstadual("Doutor em Memes", "DeputadoEstadual", "MEME", 70007));
        sistema.cadastrarCandidato(new DeputadoEstadual("Professor de Quinta", "DeputadoEstadual", "QUINTA", 80008));
        sistema.cadastrarCandidato(new DeputadoEstadual("Rei do Cafezinho", "DeputadoEstadual", "CAFE", 90009));
        sistema.cadastrarCandidato(new DeputadoEstadual("Zé do Delivery", "DeputadoEstadual", "IFOD", 99999));

    }
}
