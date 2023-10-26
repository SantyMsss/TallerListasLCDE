
package taller6listas;

/*
 * TALLER 6 LISTAS DESARROLADO EN CLASE
 * SANTIAGO MARTINEZ 230222014
 * SANTIAGO ALEJANDRO SANTACRUZ 230222033
 * LAURA SOFIA TORO GARCIA 230222021
*/

import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;

public class Listas {
    private List<taller6Listas> lcde = new LinkedList<>();
    private int currentIndex = 0; 

    public Listas() {
        int opcion;
        do {
            String input = JOptionPane.showInputDialog("Menú:\n"
        + "1. Adicionar registro\n"
        + "2. Listar registros\n"
        + "3. Consultar por PK\n"
        + "4. Modificar por PK\n"
        + "5. Eliminar por PK\n"
        + "6. Eliminar registros por campo y valor\n"
        + "7. Modificar registros por campo y valor\n"
        + "8. Recorrer LCDE\n"
        + "9. INFO PROGRAMADORES\n"
        + "0. Salir");

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    adicionarRegistro();
                    break;
                case 2:
                    listarRegistros();
                    break;
                case 3:
                    consultarPorPK();
                    break;
                case 4:
                    modificarPorPK();
                    break;
                case 5:
                    eliminarPorPK();
                    break;
                case 6:
                    eliminarPorCampoYValor();
                    break;
                case 7: modificarPorCampoYValor();
                    break;
                case 8: recorrerLCDE();
                    break;
            
                case 9: JOptionPane.showMessageDialog(null, "Equipo de Desarrollo:\n" +
                            "Santiago Martinez Serna \n" +
                            "Santiago Alejandro Santacruz \n" +
                            "Laura Sofia Toro Garcia \n");
                                        break;   
                
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void adicionarRegistro() {
        int pk;
        boolean pkRepetida;
    
        do {
            pkRepetida = false;
            pk = Integer.parseInt(JOptionPane.showInputDialog("Ingrese PK:"));
    
            for (taller6Listas registro : lcde) {
                if (registro.getPk() == pk) {
                    pkRepetida = true;
                    break;
                }
            }
    
            if (pkRepetida) {
                JOptionPane.showMessageDialog(null, "La (PK) ingresada ya existe.");
            }
        } while (pkRepetida);
    
        String vehiculo = JOptionPane.showInputDialog("Ingrese vehiculo:");
        String marca = JOptionPane.showInputDialog("Ingrese marca:");
        String pais = JOptionPane.showInputDialog("Ingrese pais");
    
        taller6Listas nuevoRegistro = new taller6Listas(pk, vehiculo, marca, pais);
        lcde.add(nuevoRegistro);
        JOptionPane.showMessageDialog(null, "Registro agregado.");
    }
    

    


    private void listarRegistros() {
        StringBuilder listStr = new StringBuilder();
        for (taller6Listas registro : lcde) {
            listStr.append(registro).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Registros:\n" + listStr.toString());
    }

    private void consultarPorPK() {
        int pkConsulta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la PK a consultar:"));
        for (taller6Listas registro : lcde) {
            if (registro.getPk() == pkConsulta) {
                JOptionPane.showMessageDialog(null, "Registro encontrado:\n" + registro);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Registro no encontrado.");
    }

    private void modificarPorPK() {
        int pkModificar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese PK para modificar pais:"));
        for (taller6Listas registro : lcde) {
            if (registro.getPk() == pkModificar) {
                String nuevapais = JOptionPane.showInputDialog("Ingrese el nuevo pais:");
                registro.setpais(nuevapais);
                JOptionPane.showMessageDialog(null, "Registro modificado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Registro no encontrado.");
    }

    private void eliminarPorPK() {
        int pkEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la PK a eliminar:"));
        boolean registroEncontrado = false;
    
        for (taller6Listas registro : lcde) {
            if (registro.getPk() == pkEliminar) {
                lcde.removeIf(registro1 -> registro1.getPk() == pkEliminar);
                registroEncontrado = true;
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
                break;
            }
        }
    
        if (!registroEncontrado) {
            JOptionPane.showMessageDialog(null, "Registro no encontrado.");
        }
    }
    

    private void eliminarPorCampoYValor() {
        String campoBuscar = JOptionPane.showInputDialog("Ingrese el campo a buscar:");
        String valorBuscar = JOptionPane.showInputDialog("Ingrese "+campoBuscar+" a eliminar:");

        lcde.removeIf(registro -> {
            if ("vehiculo".equals(campoBuscar) && registro.getvehiculo().equals(valorBuscar)) {
                return true;
            } else if ("marca".equals(campoBuscar) && registro.getmarca().equals(valorBuscar)) {
                return true;
            } else if ("pais".equals(campoBuscar) && registro.getpais().equals(valorBuscar)) {
                return true;
            }
            return false;
        });

        JOptionPane.showMessageDialog(null, "Registros eliminados.");
    }

    private void modificarPorCampoYValor() {
        String campoBuscar = JOptionPane.showInputDialog("Ingrese el campo a buscar:");
        String valorBuscar = JOptionPane.showInputDialog("Ingrese " + campoBuscar + " a modificar:");
        String nuevoValor = JOptionPane.showInputDialog("Ingrese el nuevo valor:");
    
        lcde.forEach(registro -> {
            if ("vehiculo".equals(campoBuscar) && registro.getvehiculo().equals(valorBuscar)) {
                registro.setvehiculo(nuevoValor);
            } else if ("marca".equals(campoBuscar) && registro.getmarca().equals(valorBuscar)) {
                registro.setmarca(nuevoValor);
            } else if ("pais".equals(campoBuscar) && registro.getpais().equals(valorBuscar)) {
                registro.setpais(nuevoValor);
            }
        });
    
        JOptionPane.showMessageDialog(null, "Registros modificados.");
    }



    

private void recorrerLCDE() {
    String[] options = {"Primero", "Anterior", "Siguiente", "Ultimo"};
    int result;

    if (lcde.isEmpty()) {
        JOptionPane.showMessageDialog(null, "La LCDE está vacía.");
        return;
    }

    do {
        result = JOptionPane.showOptionDialog(null,  lcde.get(currentIndex),
                "Recorriendo LCDE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        switch (result) {
            case 0: // Primero
                currentIndex = 0;
                break;
            case 1: // Anterior
                if (currentIndex == 0) {
                    currentIndex = lcde.size() - 1; // Circular hacia el final
                } else if (currentIndex > 0) {
                    currentIndex--;
                }
                break;
            case 2: // Siguiente
                if (currentIndex == lcde.size() - 1) {
                    currentIndex = 0; // Circular hacia el principio
                } else if (currentIndex >= 0) {
                    currentIndex++;
                }
                break;
            case 3: // Ultimo
                currentIndex = lcde.size() - 1;
                break;
        }

        

    } while (result != -1);
}




    public static void main(String[] args) {
        new Listas();
    }
}
