package ProxyExample;

public class proxyAccess implements access{
    private allAccess allAccess;

    public proxyAccess(){
        allAccess = new allAccess();
    }

    public void check(String validity){
        if(validity.equals("Admin")){
            allAccess.check(validity);
        }
        else{
            System.out.println("Access Denied");
        }
    }


}