/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EVPS;

import java.security.Key;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author darda
 */
public class PasswordCrypto
{
    private static final String ALGO = "AES";
    private byte[] keyValue;
    
    public PasswordCrypto(String key)
    {
        keyValue = key.getBytes();
    }
    
    public String encrypt(String data) throws Exception
    {  
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
    
    public String decrypt(String data)throws Exception
    {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedValue = new BASE64Decoder().decodeBuffer(data);
        byte[] decValue = c.doFinal(decryptedValue);
        String decryptedString = new String(decValue);
        return decryptedString;
    }
    
    private Key generateKey()throws Exception
    {
        Key key = new SecretKeySpec(keyValue,ALGO);
        return key;
    }
    
    
    
    public static void main(String [] arg)
    {
        try
        {
            PasswordCrypto pc = new PasswordCrypto("1111111111111111");
            String fjala;
            Scanner sc = new Scanner(System.in);
        
        
            System.out.print("Shtyp nje fjale: ");
            fjala = sc.next();
            
            System.out.println("");
            
            sc.nextLine();
            String fjalaCrip = pc.encrypt(fjala);
            String fjalaDecr = pc.decrypt(fjalaCrip);
            String s = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii\n" +
"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
            System.out.println("Fjala e kriptuar: " + fjalaCrip);
            System.out.println("Fjala e dekriptuar: " + fjalaDecr);
            System.out.println(s.length());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
               
    }
}
