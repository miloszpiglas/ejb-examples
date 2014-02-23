package pl.mpiglas.envejb.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import pl.mpiglas.envejb.client.StringBean;
import pl.mpiglas.envejb.client.TransformException;

/**
 * Example of implementation of stateless bean. We didn't declared its's name, so 
 * when creating new reference we have to use class name.
 */
@Stateless
public class SufixStringBean implements StringBean{

    @Resource(name="sufixValue") String sufix = "_xyz"; // named resource. Its default value
                                                    // is replaced in ejb descriptor
    
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
        return aString+sufix;
    }
}
