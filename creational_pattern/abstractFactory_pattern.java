// public class abstractFactory_pattern {
//     public void main() {
//         F16Cockpit f16Cockpit = new F16Cockpit();
//         F16Engine f16Engine = new F16Engine();
//         F16Wings f16Wings = new F16Wings();
    
//         List<F16Engine> engines = new ArrayList<>();
//         engines.add(f16Engine);
//         for (F16Engine engine : engines) {
//             engine.start();
//         }
//     }
// }

public interface IEngine {

    void start();
}

public class F16Engine implements IEngine {

    @Override
    public void start() {
        System.out.println("F16 engine on");
    }
}
