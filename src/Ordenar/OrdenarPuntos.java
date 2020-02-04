/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenar;

import java.util.Comparator;
import rusia2018.Octavos;

/**
 *
 * @author Diego Gamboa
 */
public class OrdenarPuntos implements Comparator <Octavos>{
   
    public int compare(Octavos o1,Octavos o2)
    {
        return(o2.getPuntos()-o1.getPuntos());
    }
}
