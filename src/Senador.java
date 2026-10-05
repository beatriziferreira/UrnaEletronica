public class Senador extends Candidato {
    private String suplente1;
    private String suplente2;

    public Senador(String nome, String cargo, String partido, int numero, String suplente1, String suplente2) {
        super(nome, cargo, partido, numero);
        this.suplente1 = suplente1;
        this.suplente2 = suplente2;
        if (numero < 100 || numero > 999) {
            throw new IllegalArgumentException("Número do senador deve ter apenas 3 dígitos.");
        }
        if (suplente1 == null || suplente1.isEmpty() || suplente2 == null || suplente2.isEmpty()) {
            throw new IllegalArgumentException("Nome do suplente não pode ser nulo ou vazio.");
        }

    }

    public String getSuplente1() {
        return suplente1;
    }

    public String getSuplente2() {
        return suplente2;
    }

    @Override
    public String toString() {
        return super.toString() + " [Suplentes: " + getSuplente1() + " e " + getSuplente2() + "]";
    }

}
