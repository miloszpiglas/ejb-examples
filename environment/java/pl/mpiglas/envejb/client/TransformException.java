package pl.mpiglas.envejb.client;

import javax.ejb.ApplicationException;

/**
 * Example exception mareked with annotation ApplicationException. All exceptions
 * declared in such way are reported to caller. If exception is not annotated,
 * client will get EJBException, if bussiness method cannot be completed.
 * 
 * @author Milosz Piglas
 */
@ApplicationException( 
        rollback = false
        ) 
public class TransformException extends RuntimeException {

    public TransformException(String aMessage) {
        super(aMessage);
    }
}
