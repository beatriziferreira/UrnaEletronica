import java.util.ArrayList;

public class Sistema {
    private final ArrayList<Candidato> candidatos = new ArrayList<>();
    private int votosTotais;
    private int votosNulos;
    private int votosBrancos;
    private final int senha;

    public Sistema() {
        this.votosTotais = 0;
        this.votosNulos = 10000;
        this.votosBrancos = 9800;
        this.senha = 1234;
    }

    public void cadastrarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public Candidato buscarCandidato(int numero, String cargo) {
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numero && candidato.getCargo().equalsIgnoreCase(cargo)) {
                return candidato;
            }
        }
        System.out.println("Candidato não encontrado.");
        return null;
    }

    public void votarNulo() {
        votosNulos++;
    }

    public void votarBranco() {
        votosBrancos++;
    }

    public int getVotosTotais() {
        votosTotais = votosNulos + votosBrancos;
        for (Candidato candidato : candidatos) {
            votosTotais += candidato.getVotos();
        }
        return votosTotais;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    public int getVotosBrancos() {
        return votosBrancos;
    }

    public int getSenha() {
        return senha;
    }

    public void ordenarPorVotos(ArrayList<Candidato> lista) {

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {

                if (lista.get(j).getVotos() < lista.get(j + 1).getVotos()) {

                    Candidato aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);
                }
            }
        }

    }

    public int getVotosTotaisPorCargo(Class<?> tipoCargo) {

        int total = 0;

        for (Candidato candidato : candidatos) {
            if (tipoCargo.isInstance(candidato)) {
                total += candidato.getVotos();
            }
        }

        return total;
    }

    public ArrayList<Candidato> getCandidatosPorCargo(Class<?> tipoCargo) {

        ArrayList<Candidato> lista = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            if (tipoCargo.isInstance(candidato)) {
                lista.add(candidato);
            }
        }

        return lista;
    }

    public void exibirCargo(String nomeCargo, Class<?> tipoCargo, int quantidadeEleitos) {

        ArrayList<Candidato> lista = getCandidatosPorCargo(tipoCargo);

        ordenarPorVotos(lista);

        int totalVotos = getVotosTotaisPorCargo(tipoCargo);

        System.out.println();
        System.out.println("========================================");
        System.out.println(nomeCargo);
        System.out.println("========================================");

        System.out.println("Total de votos no cargo: " + totalVotos);
        System.out.println();

        for (int i = 0; i < lista.size(); i++) {

            Candidato candidato = lista.get(i);

            double porcentagem = 0;

            if (totalVotos > 0) {
                porcentagem = (candidato.getVotos() / (double) totalVotos) * 100;
            }

            System.out.printf(
                    "%dº - %s: %.2f%% [%d votos]",
                    i + 1,
                    candidato.toString(),
                    porcentagem,
                    candidato.getVotos());

            if (i < quantidadeEleitos) {
                System.out.print("");
            }

            System.out.println();
        }
    }

    public void exibirResultados() {

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("       RESULTADOS DA ELEIÇÃO");
        System.out.println("----------------------------------------");

        exibirCargo(
                "PRESIDENTE",
                Presidente.class,
                1);

        exibirCargo(
                "GOVERNADOR (SC)",
                Governador.class,
                1);

        exibirCargo(
                "SENADOR (SC)",
                Senador.class,
                1);

        exibirCargo(
                "DEPUTADOS ESTADUAIS (SC)",
                DeputadoEstadual.class,
                8);

        exibirCargo(
                "DEPUTADOS FEDERAIS (SC)",
                DeputadoFederal.class,
                8);

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("VOTOS GERAIS");
        System.out.println("----------------------------------------");

        int total = getVotosTotais();

        System.out.println("Votos Nulos: [" + votosNulos + "]");

        System.out.println("Votos Brancos: [" + votosBrancos + "]");

        System.out.println("Total de Votos: [" + total + "]");
    }

}
