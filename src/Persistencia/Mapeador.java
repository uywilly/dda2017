/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author docenteFI
 */
public interface Mapeador {

    public int getOid();

    public void setOid(int oid);
    
    public ArrayList<String> getSqlInsert();

    public ArrayList<String> getSqlUpdate();

    public String getSqlDelete();

    public String getSqlSelect();

    public void crearNuevo();

    public void cargarDatos(ResultSet rs) throws SQLException;

    public Object getObjeto();
    
}
