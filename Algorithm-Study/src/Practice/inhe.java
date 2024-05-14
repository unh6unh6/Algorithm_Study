package Practice;

public class inhe {
    public static void main(String[] args) {
        Parent test = new Test1("민경윤",25);
        test.showName();
        ((Test1)test).showName2();
    }
}

class Parent {
    String name;
    int age;
    Parent() {

    }
    Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void showName() {
        System.out.println(this.name);
    }
}

class Test1 extends Parent{
    Test1() {

    }
    Test1(String name) {
        this.name = name;
    }
    Test1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void showName() {
        System.out.println("자식");
    }

    void showName2() {
        System.out.println("child!!");
    }
}
