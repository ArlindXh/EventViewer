/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EVPS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author darda
 */
public class WriteInNote
{
    private String text;
    private String path;
    
    FileWriter fw;
    BufferedWriter bw;
    
    public WriteInNote(String text,String path)throws WriteInNoteException
    {
        if(text == null || text.isEmpty())
            throw new WriteInNoteException("Teksti te cilin deshironi ta shkruani ne file eshte i zbrazet.");
        if(path == null || path.isEmpty())
            throw new WriteInNoteException("Pathi i folderit i zbrazet.");
        
        this.text = text;
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }

    public void setPath(String path)throws WriteInNoteException
    {
        if(path == null || path.isEmpty())
            throw new WriteInNoteException("Pathi i folderit i zbrazet.");
        
        this.path = path;
    }
    
    public void setText(String text)throws WriteInNoteException
    {
        if(text == null || text.isEmpty())
            throw new WriteInNoteException("Teksti te cilin deshironi ta shkruani ne file eshte i zbrazet.");
        
        this.text = text;
    }
    
    public String getText()
    {
        return this.text;
    }
   
    
    public void write()throws IOException
    {
        fw = new FileWriter(this.path);
        bw = new BufferedWriter(fw);
        bw.write(text);
        
        bw.flush();
        bw.close();
    }
    
    public static void main(String [] arg)
    {
       try
       {
           WriteInNote wN = new WriteInNote("Shkruj ne folderin e caktuar","C:\\Users\\darda\\Desktop\\notesWrite.doc");
           wN.write();
           
       }catch(IOException | WriteInNoteException io)
       {
           io.printStackTrace();
       }
       
    }
}
