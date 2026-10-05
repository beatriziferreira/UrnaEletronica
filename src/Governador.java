public class Governador extends Candidato {

    private String vice;

    public Governador(String nome, String cargo, String partido, int numero, String vice) {
        super(nome, cargo, partido, numero);
        this.vice = vice;
        if (numero < 10 || numero > 99) {
            throw new IllegalArgumentException("Número do governador deve ter 2 dígitos.");
        }  
    } 

    public String getVice() {
        return vice;
    }
    
    @Override 
    public String toString(){
        return super.toString() + " [Vice: " + getVice() + "]";
    }


}
