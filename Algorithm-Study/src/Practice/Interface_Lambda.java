package Practice;

interface Hello {
    public void hello();
}

interface TestLambda {
    public int plue(int a, int b);
}
class Korean implements Hello{
    @Override
    public void hello() {
        System.out.println("안녕하세요");
    }
}

class Japan implements  Hello {
    @Override
    public void hello() {
        System.out.println("곤니치와");
    }

}
public class Interface_Lambda {
    public static void main(String[] args) {
        Hello hello = new Korean();
        hello.hello();

        hello = new Japan();
        hello.hello();

        hello = new Hello() {
            @Override
            public void hello() {
                System.out.println("hi");
            }
        };
        hello.hello();

        Hello lambda = () -> {
            System.out.println("lambda hello");
        };

        lambda.hello();;


        TestLambda lambdaPlus = (a,b) -> a+b;
        test99 t = new test99();
        System.out.println(t.testLambda(lambdaPlus));
    }

}

class test99 {
    int testLambda(TestLambda newlambda) {
        int a = 5;
        int b = 3;
        return newlambda.plue(a,b);
    }

}
