package edu.umb.cs680.hw15;

public class ServoMotorManufacturing implements ElectricalPartsManufacturingStrategy{
    @Override
    public String MaterialsRequired () {
        return "Steel,wires,screws,rubber,coil";
    }

    @Override
    public String ProductAssembly () {
        return "Motor is being Assembled";
    }

    @Override
    public String ProductTesting () {
        return "Motor is being Tested";
    }

    @Override
    public String ProductPackaging () {
        return "Motor is packed";
    }
}
