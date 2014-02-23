/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mpiglas.envejb.client;

import javax.ejb.Remote;

/**
 *
 * @author Milosz Piglas
 */
@Remote // implementations of this interface accepts remote calls (for example from client)
public interface TestStringRemote {

    public String concatenateString(String aString) throws TransformException;
    
    public String transformString(String aString) throws TransformException;
}
