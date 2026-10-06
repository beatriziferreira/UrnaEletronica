public class DeputadoEstadual extends Candidato {
    public DeputadoEstadual(String nome, String cargo, String partido, int numero) {
        super(nome, cargo, partido, numero);
        if (numero < 10000 || numero > 99999) {
            throw new IllegalArgumentException("Número do deputado estadual deve ter 5 dígitos.");
        }  
    } 
}
