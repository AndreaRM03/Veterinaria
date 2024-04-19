package BackEnd;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        Perritos perrito = new Perritos("Tayron", "Pastor belga", "cafe", 30, 1.5, "Eduardo");
        System.out.println(perrito);
        
        PerritosDAO perritoDAO = new PerritosDAO();
        int resultado = perritoDAO.insertarPerrito(perrito);
        
        if(resultado == 1){
            System.out.println("El perrito fue creado exitosamente");
        }else{
            System.out.println("No se pudo crear el perrito");
        }
    }
}
