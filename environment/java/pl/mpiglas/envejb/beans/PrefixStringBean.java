package pl.mpiglas.envejb.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import pl.mpiglas.envejb.client.StringBean;
import pl.mpiglas.envejb.client.TransformException;

/**
 * Example implementation of Stateless bean. We decalare name of bean with annotation
 * @Stateless, which we can use whenever we have to refer to instance of this class.
 *
 * Using beans names instead their classes names to injecting resources has strong
 * advantage, because we can change implementation of bean without modifying caller's 
 * code.
 * @author Milosz Piglas
 */
@Stateless(
        name="prefix" 
        )
public class PrefixStringBean implements StringBean{

    @Resource String prefixValue = "abc_"; // this value is replaced with new one in ejb decriptor file
    
    @Override
    public String transform(String aString) throws TransformException {
        if (aString == null)
        {
            throw new TransformException("Cannot transform null object");
        }
        else if (aString.isEmpty())
        {
            throw new TransformException("Cannot transform empty string");
        }
        
        return prefixValue+aString;
    }
    
}
