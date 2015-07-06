/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.Date;

/**
 *
 * @author ricardo_jose_santana
 */
public class Documento {
   private int idDocumento;
    private int Protocolo;
    private TipoDocumento tipo;
    private Date dataCadatroDoc;
    private int quantidadeDeFolhas;
    private int formatoDoPapel;
    private boolean Sigilo;
    private String Descricao;
}
