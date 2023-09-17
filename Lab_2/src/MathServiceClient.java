import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import java.net.*;

public class MathServiceClient
{
    public static void main(String[] args)
            throws Exception
    {
        Service service = new Service();
        Call call = (Call)service.createCall();
        String endpoint =
                "http://localhost:8080/MathService.jws";
        //call.setTargetEndpointAddress(new URL(endpoint.replaceAll(" ", "%20")));
        call.setTargetEndpointAddress(new URL(endpoint));
        call.setOperationName("calc");
        int a=0; int b=0;
        try{
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }
        catch(Exception e)
        {System.out.println("Error: "+e);}

        int prod =
                (Integer)call.invoke(new Object[]{a,b});
        System.out.println("Prod "+a+" * "+ b+ " = " + prod);
    }
}