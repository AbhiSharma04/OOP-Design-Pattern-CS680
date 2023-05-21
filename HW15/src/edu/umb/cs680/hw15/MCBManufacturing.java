package edu.umb.cs680.hw15;

public class MCBManufacturing implements ElectricalPartsManufacturingStrategy{
    @Override
    public String MaterialsRequired () {
        return "Semiconductor,screws,relay,transistor";
    }

    @Override
    public String ProductAssembly () {
        return "MCB is being assembled";
    }

    @Override
    public String ProductTesting () {
        return "MCB is ready to test";
    }

    @Override
    public String ProductPackaging () {
        return "MCB is packed";
    }
}
