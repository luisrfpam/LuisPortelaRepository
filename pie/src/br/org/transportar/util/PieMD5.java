/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.transportar.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author LUISPORTELA
 */
public class PieMD5 {
    
    public static String convertStringToMd5(String valor) {
        
        MessageDigest mDigest;
        try {
            
            // Instanciamos o nosso HASH MD5, poderíamos usar outro
            // SHA, por exemplo, mas optamos por MD5.            
            mDigest = MessageDigest.getInstance("MD5");
            
            //Convert a String valor para um array de bytes em MD5
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
            
            //Convertemos os bytes para hexadecimal, assim podemos salvar 
            //no banco para posterior comparação se senhas
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5){
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));                
            }
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }        
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
}
