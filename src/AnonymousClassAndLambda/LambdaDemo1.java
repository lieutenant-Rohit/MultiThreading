package AnonymousClassAndLambda;

interface Say{
    void Hello();
}
public class LambdaDemo1 {
    public static void main(String[] args) {
        Say s = ()-> System.out.println("Hello From Lambda");
        s.Hello();
    }
}
