public class Presidente extends Candidato {

    private final String vice;

    public Presidente(String nome, String cargo, String partido, int numero, String vice) {
        super(nome, cargo, partido, numero);
        this.vice = vice;
        if (numero < 10 || numero > 99) {
            throw new IllegalArgumentException("Número do presidente deve ter 2 dígitos.");
        }if (vice == null || vice.isEmpty()) {
            throw new IllegalArgumentException("Nome do vice não pode ser nulo ou vazio.");
        }  
    } 
    

    @Override 
    public String toString(){
        return super.toString() + " [Vice: " + getVice() + "]";
    }


    public String getVice() {
        return vice;
    }

    


    
    
}
