import java.util.ArrayList;

public class Sistema {
    private ArrayList<Candidato> candidatos = new ArrayList<>();
    private int votosTotais;
    private int votosNulos;
    private int votosBrancos;
    private int senha;

    public Sistema() {
        this.votosTotais = 0;
        this.votosNulos = 0;
        this.votosBrancos = 0;
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

    public void organizar() {
        for (int i = 0; i < candidatos.size() - 1; i++) {

            for (int j = 0; j < candidatos.size() - 1 - i; j++) {

                if (candidatos.get(j).getVotos() < candidatos.get(j + 1).getVotos()) {
                    Candidato aux = candidatos.get(j);
                    candidatos.set(j, candidatos.get(j + 1));
                    candidatos.set(j + 1, aux);
                }
            }
        }
    }

    public int getSenha() {
        return senha;
    }

    public void exibirResultados() {
        System.out.println("-----------------------");
        System.out.println("-RESULTADOS DA ELEIÇÃO-");
        System.out.println("-----------------------");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato.toString() + ": " + (candidato.getVotos() / (double) getVotosTotais() * 100) + "% [" + candidato.getVotos() + "]");
        }
        System.out.println("Votos Nulos: " + (getVotosNulos() / (double) getVotosTotais() * 100) + "% [" + votosNulos + "]");
        System.out.println("Votos Brancos: " + (getVotosBrancos() / (double) getVotosTotais() * 100) + "% [" + votosBrancos + "]");
        System.out.println("Total de Votos: " + "[" + getVotosTotais() + "]");
    }

}
