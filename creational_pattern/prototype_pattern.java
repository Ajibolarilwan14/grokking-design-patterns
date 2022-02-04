/**
 * prototype_pattern
 */
public interface prototype_pattern {

    void fly();

    IAircraftPrototype clone();

    void setEngine(F16Engine f16Engine);
}