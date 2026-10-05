import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Sistema sistema = new Sistema();
        App.popular(sistema);
        boolean finalizarVotacao = false;
        System.out.println("Inicializando sistemas...");
        System.out.println("Sistema inicializado com sucesso!");
        System.out.println("-----------------------------------");
        System.out.println("URNA ELETRÔNICA - JUSTIÇA ELEITORAL");
        System.out.println("-----------------------------------");
        System.out.println("Versão 1.0.2");
        System.out.println("-----------------------------------");
        do {
            int num = 0;
            Candidato cand = null;
            boolean confirma = false;
            int confirmar = 0;
            do {
                System.out.println("ELEIÇÕES 2067 - SANTA CATARINA");
                System.out.println("-----------------------------------");
                System.out.println("DEPUTADO FEDERAL");
                System.out.println("[0] - Voto nulo");
                System.out.println("[1] - Voto em branco");
                System.out.println("Digite o número do candidato [][][][]: ");
                num = scan.nextInt();
                if (num != 0 && num != 1) {
                    if (sistema.buscarCandidato(num, "DeputadoFederal") != null) {
                        cand = sistema.buscarCandidato(num, "DeputadoFederal");
                        System.out.println("---------------------------------------");
                        System.out.println(cand.toString());
                        System.out.println("---------------------------------------");
                        System.out.println("[1] - Confirmar");
                        System.out.println("[2] - Limpar");
                        confirmar = scan.nextInt();
                        if (confirmar == 1) {
                            confirma = cand.adicionarVoto();
                            System.out.println("PLIM!");

                        } else if (confirmar == 2) {
                            System.out.println("Voto limpo. Digite novamente.");
                            confirma = false;
                        } else {
                            System.out.println("Opção inválida.");
                            confirma = false;
                        }

                    } else {
                        confirma = false;
                    }
                } else if (num == 1) {
                    sistema.votarBranco();
                    confirma = true;
                    System.out.println("PLIM!");

                } else if (num == 0) {
                    sistema.votarNulo();
                    confirma = true;
                    System.out.println("PLIM!");

                }
            } while (!confirma);

            do {
                System.out.println("DEPUTADO ESTADUAL");
                System.out.println("[0] - Voto nulo");
                System.out.println("[1] - Voto em branco");
                System.out.println("Digite o número do candidato [][][][][]: ");
                num = scan.nextInt();
                if (num != 0 && num != 1) {
                    if (sistema.buscarCandidato(num, "DeputadoEstadual") != null) {
                        cand = sistema.buscarCandidato(num, "DeputadoEstadual");
                        System.out.println("---------------------------------------");
                        System.out.println(cand.toString());
                        System.out.println("---------------------------------------");
                        System.out.println("[1] - Confirmar");
                        System.out.println("[2] - Limpar");
                        confirmar = scan.nextInt();
                        if (confirmar == 1) {
                            confirma = cand.adicionarVoto();
                            System.out.println("PLIM!");

                        } else if (confirmar == 2) {
                            System.out.println("Voto limpo. Digite novamente.");
                            confirma = false;
                        } else {
                            System.out.println("Opção inválida.");
                            confirma = false;
                        }
                    } else {
                        confirma = false;
                    }
                } else if (num == 1) {
                    sistema.votarBranco();
                    confirma = true;
                    System.out.println("PLIM!");

                } else if (num == 0) {
                    sistema.votarNulo();
                    confirma = true;
                    System.out.println("PLIM!");

                }
            } while (!confirma);

            do {
                System.out.println("SENADOR");
                System.out.println("[0] - Voto nulo");
                System.out.println("[1] - Voto em branco");
                System.out.println("Digite o número do candidato [][][]: ");
                num = scan.nextInt();
                if (num != 0 && num != 1) {
                    if (sistema.buscarCandidato(num, "Senador") != null) {
                        cand = sistema.buscarCandidato(num, "Senador");
                        System.out.println("---------------------------------------");
                        System.out.println(cand.toString());
                        System.out.println("---------------------------------------");
                        System.out.println("[1] - Confirmar");
                        System.out.println("[2] - Limpar");
                        confirmar = scan.nextInt();
                        if (confirmar == 1) {
                            confirma = cand.adicionarVoto();
                            System.out.println("PLIM!");

                        } else if (confirmar == 2) {
                            System.out.println("Voto limpo. Digite novamente.");
                            confirma = false;
                        } else {
                            System.out.println("Opção inválida.");
                            confirma = false;
                        }
                    }else {
                        confirma = false;
                    }
                } else if (num == 1) {
                    sistema.votarBranco();
                    confirma = true;
                    System.out.println("PLIM!");

                } else if (num == 0) {
                    sistema.votarNulo();
                    confirma = true;
                    System.out.println("PLIM!");

                }
            } while (!confirma);

            do {
                System.out.println("GOVERNADOR");
                System.out.println("[0] - Voto nulo");
                System.out.println("[1] - Voto em branco");
                System.out.println("Digite o número do candidato [][]: ");
                num = scan.nextInt();
                if (num != 0 && num != 1) {
                    if (sistema.buscarCandidato(num, "Governador") != null) {
                        cand = sistema.buscarCandidato(num, "Governador");
                        System.out.println("---------------------------------------");
                        System.out.println(cand.toString());
                        System.out.println("---------------------------------------");
                        System.out.println("[1] - Confirmar");
                        System.out.println("[2] - Limpar");
                        confirmar = scan.nextInt();
                        if (confirmar == 1) {
                            confirma = cand.adicionarVoto();
                            System.out.println("PLIM!");

                        } else if (confirmar == 2) {
                            System.out.println("Voto limpo. Digite novamente.");
                            confirma = false;
                        } else {
                            System.out.println("Opção inválida.");
                            confirma = false;
                        }
                    } else {
                        confirma = false;
                    }
                } else if (num == 1) {
                    sistema.votarBranco();
                    confirma = true;
                    System.out.println("PLIM!");

                } else if (num == 0) {
                    sistema.votarNulo();
                    confirma = true;
                    System.out.println("PLIM!");

                }
            } while (!confirma);

            do {
                System.out.println("PRESIDENTE");
                System.out.println("[0] - Voto nulo");
                System.out.println("[1] - Voto em branco");
                System.out.println("Digite o número do candidato [][]: ");
                num = scan.nextInt();
                if (num != 0 && num != 1) {
                    if (sistema.buscarCandidato(num, "Presidente") != null) {
                        cand = sistema.buscarCandidato(num, "Presidente");
                        System.out.println("---------------------------------------");
                        System.out.println(cand.toString());
                        System.out.println("---------------------------------------");
                        System.out.println("[1] - Confirmar");
                        System.out.println("[2] - Limpar");
                        confirmar = scan.nextInt();
                        if (confirmar == 1) {
                            confirma = cand.adicionarVoto();
                            System.out.println("PLIM!");

                        } else if (confirmar == 2) {
                            System.out.println("Voto limpo. Digite novamente.");
                            confirma = false;
                        } else {
                            System.out.println("Opção inválida.");
                            confirma = false;
                        }
                    } else {
                        confirma = false;
                    }
                } else if (num == 1) {
                    sistema.votarBranco();
                    confirma = true;
                    System.out.println("PLIM!");

                } else if (num == 0) {
                    sistema.votarNulo();
                    confirma = true;
                    System.out.println("PLIM!");

                }
            } while (!confirma);

            System.out.println(" ");
            System.out.println("FIM");
            System.out.println(" ");
            System.out.println("(Mesário) Deseja finalizar a votação? [1] - Sim | [2] - Não");
            int finalizar = scan.nextInt();
            if (finalizar == 1) {
                System.out.println("Digite a senha para finalizar a votação:");
                int senha = scan.nextInt();
                if (senha == sistema.getSenha()) {
                    finalizarVotacao = true;
                    sistema.exibirResultados();
                } else {
                    System.out.println("Senha incorreta.");
                    finalizarVotacao = false;
                }
            } else if (finalizar == 2) {
                finalizarVotacao = false;
            } else {
                System.out.println("Opção inválida.");
            }
        } while (!finalizarVotacao);
        System.out.println("Votação finalizada com sucesso! Desligando urna...");
        scan.close();

    }

    private static void popular(Sistema sistema) {
        
        // ==================== PRESIDENTES ====================

        sistema.cadastrarCandidato(new Presidente("Tranca Rua", "Presidente", "PUC", 10, "Exu Mirim"));
        sistema.cadastrarCandidato(new Presidente("Zé do WiFi", "Presidente", "PIZZA", 20, "Senha Errada"));
        sistema.cadastrarCandidato(new Presidente("Tonho do Zap", "Presidente", "ZAP", 30, "Grupo Silenciado"));
        sistema.cadastrarCandidato(new Presidente("Capitão Miojo", "Presidente", "GAMBI", 40, "Tempero Pronto"));
        sistema.cadastrarCandidato(new Presidente("Dona Planilha", "Presidente", "EXCEL", 50, "Ctrl C"));
        sistema.cadastrarCandidato(new Presidente("Professor Pardal", "Presidente", "PIX", 60, "Fio Desencapado"));
        sistema.cadastrarCandidato(new Presidente("Rei do Pix", "Presidente", "BAR", 70, "QR Code"));
        sistema.cadastrarCandidato(new Presidente("Seu Madruga", "Presidente", "PUC", 10, "Dona Florinda"));
        sistema.cadastrarCandidato(new Presidente("Cabo da Internet", "Presidente", "PIZZA", 20, "Roteador"));
        sistema.cadastrarCandidato(new Presidente("Jair do Pastel", "Presidente", "ZAP", 30, "Caldo de Cana"));

        // ==================== GOVERNADORES ====================

        sistema.cadastrarCandidato(new Governador("Farmador de Aura", "Governador", "GAMBI", 40, "Brabo do Bairro"));
        sistema.cadastrarCandidato(new Governador("Rei do Pedágio", "Governador", "PUC", 10, "Sem Troco"));
        sistema.cadastrarCandidato(new Governador("Zé do Asfalto", "Governador", "PIZZA", 20, "Mestre da Obra"));
        sistema.cadastrarCandidato(new Governador("Doutor Gambiarra", "Governador", "GAMBI", 40, "Fita Isolante"));
        sistema.cadastrarCandidato(new Governador("Tio do Churrasco", "Governador", "EXCEL", 50, "Linguiça"));
        sistema.cadastrarCandidato(new Governador("Influencer do Bairro", "Governador", "PIX", 60, "Seguidor Fiel"));
        sistema.cadastrarCandidato(new Governador("Mestre do Café", "Governador", "BAR", 70, "Pao de Queijo"));
        sistema.cadastrarCandidato(new Governador("Professor de Educação Física", "Governador", "PUC", 10, "Personal Treino"));
        sistema.cadastrarCandidato(new Governador("Fiscal do Sono", "Governador", "ZAP", 30, "Travesseiro"));
        sistema.cadastrarCandidato(new Governador("Senhor Estaciona Aqui", "Governador", "PIZZA", 20, "Pisca Alerta"));

        // ==================== SENADORES ====================

        sistema.cadastrarCandidato(new Senador("Lobao", "Senador", "PUC", 100, "Lobinho Um", "Lobinho Dois"));
        sistema.cadastrarCandidato(new Senador("Rei do Tererê", "Senador", "PIZZA", 200, "Canudo", "Erva Mate"));
        sistema.cadastrarCandidato(new Senador("Zé do Boteco", "Senador", "ZAP", 300, "Coxinha", "Pastelzinho"));
        sistema.cadastrarCandidato(new Senador("Dona do Grupo", "Senador", "GAMBI", 400, "Silenciado", "Removido"));
        sistema.cadastrarCandidato(new Senador("Mestre do Discord", "Senador", "EXCEL", 500, "Mute", "Ban"));
        sistema.cadastrarCandidato(new Senador("Rei da Soneca", "Senador", "PIX", 600, "Cobertor", "Travesseiro"));
        sistema.cadastrarCandidato(new Senador("Tio do Pavê", "Senador", "BAR", 700, "Pave", "Pra Comer"));
        sistema.cadastrarCandidato(new Senador("Fiscal do Churrasco", "Senador", "PUC", 100, "Faca", "Garfo"));
        sistema.cadastrarCandidato(new Senador("Doutor do Zap", "Senador", "PIZZA", 200, "Bom Dia", "Boa Noite"));
        sistema.cadastrarCandidato(new Senador("Mãe do Pix", "Senador", "ZAP", 300, "TED", "DOC"));

        // ==================== DEPUTADOS FEDERAIS ====================

        sistema.cadastrarCandidato(new DeputadoFederal("Ctrl C", "DeputadoFederal", "PUC", 1001));
        sistema.cadastrarCandidato(new DeputadoFederal("Ctrl V", "DeputadoFederal", "PIZZA", 2001));
        sistema.cadastrarCandidato(new DeputadoFederal("Zé do Mouse", "DeputadoFederal", "ZAP", 3001));
        sistema.cadastrarCandidato(new DeputadoFederal("Senhor Print", "DeputadoFederal", "GAMBI", 4001));
        sistema.cadastrarCandidato(new DeputadoFederal("Rei do Alt Tab", "DeputadoFederal", "EXCEL", 5001));
        sistema.cadastrarCandidato(new DeputadoFederal("Tio do Pendrive", "DeputadoFederal", "PIX", 6001));
        sistema.cadastrarCandidato(new DeputadoFederal("Doutor Google", "DeputadoFederal", "BAR", 7001));
        sistema.cadastrarCandidato(new DeputadoFederal("Mestre do Bug", "DeputadoFederal", "PUC", 1002));
        sistema.cadastrarCandidato(new DeputadoFederal("Professor Null", "DeputadoFederal", "PIZZA", 2002));
        sistema.cadastrarCandidato(new DeputadoFederal("Senhor Sem Sinal", "DeputadoFederal", "ZAP", 3002));
        sistema.cadastrarCandidato(new DeputadoFederal("Rei do Ctrl Alt Del", "DeputadoFederal", "GAMBI", 4002));
        sistema.cadastrarCandidato(new DeputadoFederal("Dona da Impressora", "DeputadoFederal", "EXCEL", 5002));
        sistema.cadastrarCandidato(new DeputadoFederal("Tio do Cabo HDMI", "DeputadoFederal", "PIX", 6002));
        sistema.cadastrarCandidato(new DeputadoFederal("Mestre do Bluetooth", "DeputadoFederal", "BAR", 7002));
        sistema.cadastrarCandidato(new DeputadoFederal("Zé do Download", "DeputadoFederal", "PUC", 1003));
        sistema.cadastrarCandidato(new DeputadoFederal("Professor do Google", "DeputadoFederal", "PIZZA", 2003));
        sistema.cadastrarCandidato(new DeputadoFederal("Fiscal do WiFi", "DeputadoFederal", "ZAP", 3003));
        sistema.cadastrarCandidato(new DeputadoFederal("Doutor do Backup", "DeputadoFederal", "GAMBI", 4003));
        sistema.cadastrarCandidato(new DeputadoFederal("Senhor Atualização", "DeputadoFederal", "EXCEL", 5003));
        sistema.cadastrarCandidato(new DeputadoFederal("Rei do Login", "DeputadoFederal", "PIX", 6003));

        // ==================== DEPUTADOS ESTADUAIS ====================

        sistema.cadastrarCandidato(new DeputadoEstadual("Mestre da Gambiarra", "DeputadoEstadual", "PUC", 10001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Zé do Ctrl Z", "DeputadoEstadual", "PIZZA", 20001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Dona do Excel", "DeputadoEstadual", "ZAP", 30001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Rei da Senha", "DeputadoEstadual", "GAMBI", 40001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Tio do Bluetooth", "DeputadoEstadual", "EXCEL", 50001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Fiscal do WiFi", "DeputadoEstadual", "PIX", 60001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Doutor em Memes", "DeputadoEstadual", "BAR", 70001));
        sistema.cadastrarCandidato(new DeputadoEstadual("Professor de Quinta", "DeputadoEstadual", "PUC", 10002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Rei do Cafezinho", "DeputadoEstadual", "PIZZA", 20002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Zé do Delivery", "DeputadoEstadual", "ZAP", 30002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Tio da Tomada", "DeputadoEstadual", "GAMBI", 40002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Dona do PowerPoint", "DeputadoEstadual", "EXCEL", 50002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Rei do Pix Parcelado", "DeputadoEstadual", "PIX", 60002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Fiscal da Calçada", "DeputadoEstadual", "BAR", 70002));
        sistema.cadastrarCandidato(new DeputadoEstadual("Mestre do WiFi", "DeputadoEstadual", "PUC", 10003));
        sistema.cadastrarCandidato(new DeputadoEstadual("Senhor do Cupom", "DeputadoEstadual", "PIZZA", 20003));
        sistema.cadastrarCandidato(new DeputadoEstadual("Doutor do Zap", "DeputadoEstadual", "ZAP", 30003));
        sistema.cadastrarCandidato(new DeputadoEstadual("Professor do Estágio", "DeputadoEstadual", "GAMBI", 40003));
        sistema.cadastrarCandidato(new DeputadoEstadual("Rei do Café Frio", "DeputadoEstadual", "EXCEL", 50003));
        sistema.cadastrarCandidato(new DeputadoEstadual("Zé do QR Code", "DeputadoEstadual", "PIX", 60003));
    }
}
