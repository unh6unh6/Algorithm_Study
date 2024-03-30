package Practice;


class Car {
    String model;
    double x, vx;
    boolean ngin = false;
    Car(String model) {
        this.model = model;
    }

    void info() {
        System.out.println(model + "입니다.");
    }
    void start() {
        ngin = true;
        System.out.println("~~부릉~~");
    }
    double spurt() {
        return (Math.random() - 0.3) * 30;
    }
    boolean move() {
        vx = spurt();
        x += vx;
        display();
        System.out.println(model + " at " + (int)x);
        return ingoal();
    }
    boolean ingoal() {
        return x>200;
    }

    void display() {
        for (int i = 0; i < x; i+=5)
            System.out.print("-");
        System.out.println(":=:-");
    }
}

public class CarRace {
    Car one, two, three;
    CarRace() {
        one = new Car("car1");
        two = new Car("car2");
        three = new Car("car3");
    }
    void rollcall() {
        one.info();
        two.info();
        three.info();
    }

    void start() {
        one.start();
        two.start();
        three.start();
    }

    void run() {
        Car winner = null;
        int t = 0;
        do {
            System.out.println(++t);
            if(one.move())
                winner = one;
            if(two.move())
                winner = two;
            if(three.move())
                winner = three;
            try {
                Thread.sleep(400);
            } catch (Exception e) {}

            System.out.println();
            System.out.println();
        } while(winner == null);
        System.out.print("The Winner is ");
        winner.info();
    }
    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        carRace.rollcall();
        carRace.start();
        carRace.run();
    }
}
