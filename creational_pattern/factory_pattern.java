// /**
//  * factory_pattern
//  */
// public class factory_pattern {

//     F16Engine engine;
//     F16Cockpit cockpit;

//     protected void makeF16() {
//         engine = new F16Engine();
//         cockpit = new F16Cockpit();
//     }

//     public void fly() {
//         makeF16();
//         System.out.println("F16 with bad design flying");
//     }
// }

// public class Client {

//     public void main() {

//         // We instantiate from a concrete class, thus tying
//         // ourselves to it
//         F16 f16 = new F16();
//         f16.fly();
//     }
// }

// public class F16SimpleFactory {

//     public F16 makeF16(String variant) {

//         switch (variant) {
//         case "A":
//             return new F16A();
//         case "B":
//             return new F16B();
//         default:
//             return new F16();
//         }
//     }
// }

public class F16 {

    IEngine engine;
    ICockpit cockpit;

    protected F16 makeF16() {
        engine = new F16Engine();
        cockpit = new F16Cockpit();
        return this;
    }

    public void taxi() {
        System.out.println("F16 is taxing on the runway !");
    }

    public void fly() {
        // Note here carefully, the superclass F16 doesn't know
        // what type of F-16 variant it was returned.
        F16 f16 = makeF16();
        f16.taxi();
        System.out.println("F16 is in the air !");
    }
}

public class F16A extends F16 {

    @Override
    public F16 makeF16() {
        super.makeF16();
        engine = new F16AEngine();
        return this;
    }
}

public class F16B extends F16 {

    @Override
    public F16 makeF16() {
        super.makeF16();
        engine = new F16BEngine();
        return this;
    }
}