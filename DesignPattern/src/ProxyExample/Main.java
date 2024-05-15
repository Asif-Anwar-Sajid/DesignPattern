package ProxyExample;


public class Main {
    public static void main(String[] args) {
        access accessObj = new proxyAccess();
        accessObj.check("Admin");
        accessObj.check("user");
    }
}