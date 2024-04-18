package BackEnd;

/**
 *
 * @author user
 */
public class Perritos {
  
    //Atributos
    private int idPerrito;
    private String nombre;
    private String raza;
    private String color;
    private double peso;
    private double altura;
    private String dueno;

    //Constructores
    public Perritos(){
        
    }
    
    public Perritos(String nombre, String raza, String color, double peso, double altura, String dueno){
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.peso = peso;
        this.altura = altura;
        this.dueno = dueno;
    }
    
    //Getters and setters
    
    public int getIdPerrito() {
        return idPerrito;
    }

    public void setIdPerrito(int idPerrito) {
        this.idPerrito = idPerrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    @Override
    public String toString() {
        return "Perritos{" + "idPerrito=" + idPerrito + ", nombre=" + nombre + ", raza=" + raza + ", color=" + color + ", peso=" + peso + ", altura=" + altura + ", dueno=" + dueno + '}';
    }
    
    
}
