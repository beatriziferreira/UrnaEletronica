public class DeputadoFederal extends Candidato{
    public DeputadoFederal(String nome, String cargo, String partido, int numero) {
        super(nome, cargo, partido, numero);
        if (numero < 1000 || numero > 9999) {
            throw new IllegalArgumentException("Número do deputado federal deve ter 4 dígitos.");
        }  
    } 
}
