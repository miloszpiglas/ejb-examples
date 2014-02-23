package pl.mpiglas.envejb.client;

import javax.ejb.Local;

/**
 *
 * @author Milosz Piglas
 */
@Local // implementations of this interface accepts only local calls
public interface StringBean {
    
    String transform(String aString) throws TransformException;
    
}
