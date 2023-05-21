package edu.umb.cs680.hw15;

public class ControlPanelManufacturing implements ElectricalPartsManufacturingStrategy{
    @Override
    public String MaterialsRequired () {
        return "Panel,steel,wires,switches";
    }

    @Override
    public String ProductAssembly () {
        return "Panel is being assembled";
    }

    @Override
    public String ProductTesting () {
        return "Panel will be tested";
    }

    @Override
    public String ProductPackaging () {
        return "Panel is packed";
    }
}
