/**
 * factory_pattern
 */
public class factory_pattern {

    F16Engine engine;
    F16Cockpit cockpit;

    protected void makeF16() {
        engine = new F16Engine();
        cockpit = new F16Cockpit();
    }

    public void fly() {
        makeF16();
        System.out.println("F16 with bad design flying");
    }
}

public class Client {

    public void main() {

        // We instantiate from a concrete class, thus tying
        // ourselves to it
        F16 f16 = new F16();
        f16.fly();
    }
}