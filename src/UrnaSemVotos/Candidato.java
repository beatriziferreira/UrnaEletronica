

public abstract class Candidato {
    private final String nome;
    private final String cargo;
    private final String partido;
    private final int numero;
    private int votos;

    public Candidato(String nome, String cargo, String partido, int numero) {
        this.nome = nome;
        this.cargo = cargo;
        this.partido = partido;
        this.numero = numero;
        this.votos = 0;
        
        if (numero < 0) {
            throw new IllegalArgumentException("Número do candidato não pode ser negativo.");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do candidato não pode ser nulo ou vazio.");
        }
        if (cargo == null || cargo.isEmpty()) {
            throw new IllegalArgumentException("Cargo do candidato não pode ser nulo ou vazio.");
        }
        if (partido == null || partido.isEmpty()) {
            throw new IllegalArgumentException("Partido do candidato não pode ser nulo ou vazio.");
        }

    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPartido() {
        return partido;
    }

    public int getNumero() {
        return numero;
    }

    public int getVotos() {
        return votos;
    }


    public boolean adicionarVoto() {
        votos++;
        return true;
    }

    @Override
    public String toString() {
        return "[" + numero + "] " + nome + " - " + partido.toUpperCase();
    }


}
