package pl.mpiglas.envejb.beans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pl.mpiglas.envejb.client.StringBean;
import pl.mpiglas.envejb.client.TestStringRemote;
import pl.mpiglas.envejb.client.TransformException;

/**
 * Stateless bean, which uses implementations of StringBean interface to perform
 * string operations
 * 
 * @author Milosz Piglas
 */
@Stateless(name="testBean")
@EJB(   name="ejb/transformBean", // declaration of reference. Specific implementation (defined in ejb descriptor)
        beanInterface = StringBean.class // is accessible with name 'ejb/transformBean
    )
public class TestStringBean implements TestStringRemote{

    @EJB(name = "ejb/concatenateBean", // declaration of reference. In this case Container should inject bean 'prefix'
            beanName = "prefix") // but as you can see in ejb-jar.xml it is replaced with SufifxStringBean
    StringBean stringSrv;
    
    @Override
    public String transformString(String aString) throws TransformException
    {
        try {
            //return stringSrv.transform(aString);
            InitialContext context = new InitialContext();
            Context ejbCtx = (Context) context.lookup("java:comp/env"); // looking for subcontext 'env'
            StringBean transformBean = (StringBean) ejbCtx.lookup("ejb/transformBean"); // looking for resource ejb/transformBean
            return transformBean.transform(aString);
        } catch (NamingException ex) {
            Logger.getLogger(TestStringBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String concatenateString(String aString) throws TransformException {
        return stringSrv.transform(aString);
    }
            

}
