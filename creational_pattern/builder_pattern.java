public class builder_pattern {
    public abstract class AircraftBuilder {
        public void buildEngine() {
    
        }

        public void buildWings(){

        }

        public void buildCockpit() {

        }

        public void biuldBathrooms() {

        }

        abstract public IAircraft getResult();
    }

    /**
     * Innerbuilder_pattern
     */
    public class Boeing747Builder extends AircraftBuilder {
        Boeing747 boeing747;

        @Override
        public void buildCockpit() {

        }

        @Override
        public void buildEngine() {

        }

        @Override
        public void buildWings() {

        }

        @Override
        public void biuldBathrooms() {

        }

        public IAircraft getResult() {
            return boeing747;
        }
        
    }

    /**
     * Innerbuilder_pattern
     */
    public class F16Builder extends AircraftBuilder {
        F16 f16;

        @Override
        public void buildEngine() {
            // get F-16 an engine
            // f16.engine = new F16Engine();
        }
    
        @Override
        public void buildWings() {
            // get F-16 wings
            // f16.wings = new F16Wings();
        }
    
        @Override
        public void buildCockpit() {
            f16 = new F16();
            // get F-16 a cockpit
            // f16.cockpit = new F16Cockpit();
        }
    
        public IAircraft getResult() {
            return f16;
        }
        
    }

    public class Director {

        AircraftBuilder aircraftBuilder;
    
        public Director(AircraftBuilder aircraftBuilder) {
            this.aircraftBuilder = aircraftBuilder;
        }
    
        public void construct(boolean isPassenger) {
            aircraftBuilder.buildCockpit();
            aircraftBuilder.buildEngine();
            aircraftBuilder.buildWings();
    
            if (isPassenger)
                aircraftBuilder.buildBathrooms();
        }
    }

    public class Client {

        public void main() {
    
            F16Builder f16Builder = new F16Builder();
            Director director = new Director(f16Builder);
            director.construct(false);
    
            IAircraft f16 = f16Builder.getResult();
        }
    }

    // Other examples
    public IDocument construct(DocumentBuilder documentBuilder) {

        documentBuilder.addTitle("Why use design patterns");
        documentBuilder.addBody("blah blah blah... more blah blah blah");
        documentBuilder.addAuthor("C. H. Afzal");
        documentBuilder.addConclusion("Happy Coding!");
        
        // Return the document and depending on the concrete
        // implementation of the DocumentBuilder, we could return
        // either a pdf or html document.
        return documentBuilder.buildDocument();
        
    }
    
}

// public class builder_pattern {
//     public static void main(String[] args) {
//         System.out.println("Hello World!");
//     }
// }