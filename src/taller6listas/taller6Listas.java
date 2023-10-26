
package taller6listas;

public class taller6Listas {
    private int pk; // Llave primaria
    private String vehiculo;
    private String marca;
    private String pais;

    public taller6Listas(int pk, String vehiculo, String marca, String pais) {
        this.pk = pk;
        this.vehiculo = vehiculo;
        this.marca = marca;
        this.pais = pais;
    }

    public int getPk() {
        return pk;
    }

    public String getvehiculo() {
        return vehiculo;
    }

    public void setvehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getpais() {
        return pais;
    }

    public void setpais(String pais) {
        this.pais = pais;
    }

    public String toString() {
        return "PK: " + pk + ", vehiculo: " + vehiculo + ", marca: " + marca + ", pais: " + pais;
    }
}
