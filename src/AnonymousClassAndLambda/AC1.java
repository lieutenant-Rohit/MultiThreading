package AnonymousClassAndLambda;

class Animal {
    void sound()
    {
        System.out.println("Animal Makes Sound");
    }
}
public class AC1
{
    public static void main(String[] args) {
        Animal a = new Animal(){
            void sound()
            {
                System.out.println("Anonymous Animal Makes Sound");
            }
        };

        a.sound();
    }
}
