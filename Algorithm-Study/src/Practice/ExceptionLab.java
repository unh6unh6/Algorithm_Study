package Practice;

public class ExceptionLab {
    public static void main(String[] args) throws Exception{

        throwEx();
        System.out.println("pass");

    }

    public static void throwEx() throws Exception {
        throw new RuntimeException();
    }
}
