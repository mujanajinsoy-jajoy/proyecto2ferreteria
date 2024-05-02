public class producto {
    private String nombre;
    private String describcion;
    private double precio;
    private int cantidad;
    private String materialElaboracion;
    private String ejemploUso;
    private String herramientaNecesaria;
    
    public producto(String nombre, String describcion, double precio, int cantidad, String materialElaboracion,
            String ejemploUso, String herramientaNecesaria) {
        this.nombre = nombre;
        this.describcion = describcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.materialElaboracion = materialElaboracion;
        this.ejemploUso = ejemploUso;
        this.herramientaNecesaria = herramientaNecesaria;
    }

    public producto(String nombre2, String descripcion, double precio2, int cantidad2) {
        //TODO Auto-generated constructor stub
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescribcion() {
        return describcion;
    }

    public void setDescribcion(String describcion) {
        this.describcion = describcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMaterialElaboracion() {
        return materialElaboracion;
    }

    public void setMaterialElaboracion(String materialElaboracion) {
        this.materialElaboracion = materialElaboracion;
    }

    public String getEjemploUso() {
        return ejemploUso;
    }

    public void setEjemploUso(String ejemploUso) {
        this.ejemploUso = ejemploUso;
    }

    public String getHerramientaNecesaria() {
        return herramientaNecesaria;
    }

    public void setHerramientaNecesaria(String herramientaNecesaria) {
        this.herramientaNecesaria = herramientaNecesaria;
    }

    
    
}