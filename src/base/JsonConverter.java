/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.List;
import net.arnx.jsonic.JSON;

/**
 *
 * @author pawn
 */
public class JsonConverter<T> {
    
    public String encode(Object obj){
        return JSON.encode(obj);
    }
    
    public T decode(String str,Class classType){
        return (T) JSON.decode(str, classType);
    }
    public List<Class> decodeList(String str,Class classType){
        return (List<Class>)JSON.decode(str);
    }
    
}
