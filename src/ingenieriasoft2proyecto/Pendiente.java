/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingenieriasoft2proyecto;

/**
 *
 * @author Note250
 */
public class Pendiente {
    private int idTelefono;
    private int idReparacion;
    private int StockRepuesto;
/**
 * 
 * @param idTelefono
 * @param idReparacion
 * @param StockRepuesto 
 */
    public Pendiente(int idTelefono, int idReparacion, int StockRepuesto) {
        this.idTelefono = idTelefono;
        this.idReparacion = idReparacion;
        this.StockRepuesto = StockRepuesto;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public int getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }

    public int getStockRepuesto() {
        return StockRepuesto;
    }

    public void setStockRepuesto(int StockRepuesto) {
        this.StockRepuesto = StockRepuesto;
    }
    
}

