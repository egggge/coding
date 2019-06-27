
package BaseJava;
import java.io.Serializable;


/**
 * @Author: egg
 * @Date: 2019-06-25 20:26
 */
public class EmployeeSer implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}
