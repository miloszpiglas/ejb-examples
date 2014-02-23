package pl.mpiglas.envejb.beans;

import javax.ejb.Stateless;
import pl.mpiglas.envejb.client.StringBean;
import pl.mpiglas.envejb.client.TransformException;

/**
 *
 * @author Milosz Piglas
 */
@Stateless( name="upperCase")
public class UpperCaseStringBean implements StringBean{

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
        return aString.toUpperCase();
    }


}
