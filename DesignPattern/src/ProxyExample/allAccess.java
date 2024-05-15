package ProxyExample;

public class allAccess implements access{
    @Override
    public void check(String validity) {

        if(validity.equals("Admin")){
            System.out.println(validity + " is valid");
        }
        else{
            System.out.println("Access Denied");
        }
    }
}
