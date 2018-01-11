package tekhne.com.peliculaspractica.modelo;

/**
 * Created by desarrollo on 09-12-17.
 */

public class Pelicula {

    private int id;
    private String nombre;
    private String Tipo;
    private String Duracion;
    private String Descripcion;
    private String Calificacion;
    private String imagen;

    public Pelicula(){
        this.id = 0;
        this.nombre = "";
        this.Descripcion = "";

    }


    public Pelicula(int id, String nombre, String tipo, String duracion, String descripcion, String calificacion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        Tipo = tipo;
        Duracion = duracion;
        Descripcion = descripcion;
        Calificacion = calificacion;
        this.imagen = imagen;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String calificacion) {
        Calificacion = calificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public static String[] listaPeliculas ={"Liga de la justicia",
            "Pelicula 2",
            "Planeta de los simios",
            "X-men"};
    public static String[] detallePeliculas = {"Unos tipos peleando",
                                                "Nada",
                                                "Monos mutantes",
                                                "Mutantes"};

}
