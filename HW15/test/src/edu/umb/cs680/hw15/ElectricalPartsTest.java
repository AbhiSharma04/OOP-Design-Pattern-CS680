package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElectricalPartsTest {

    @Test
    public void ControlPanelTest() {
        ElectricalPartsManufacturingStrategy strategy = new ControlPanelManufacturing ();

        assertEquals("Panel,steel,wires,switches", strategy.MaterialsRequired ());
        assertEquals("Panel is being assembled", strategy.ProductAssembly ());
    }

    @Test
    public void MCBTest() {
        ElectricalPartsManufacturingStrategy strategy = new MCBManufacturing ();

        assertEquals("MCB is ready to test", strategy.ProductTesting ());
        assertEquals("MCB is packed", strategy.ProductPackaging ());
    }

    @Test
    public void ServoMotorTest () {
        ElectricalPartsManufacturingStrategy strategy = new ServoMotorManufacturing ();

        assertEquals("Steel,wires,screws,rubber,coil", strategy.MaterialsRequired ());
        assertEquals("Motor is packed", strategy.ProductPackaging ());
    }

    @Test
    public void CheckInstanceOfServoMotor(){
        ElectricalPartsManufacturingStrategy strategy = new ServoMotorManufacturing ();

        assertTrue (strategy instanceof ServoMotorManufacturing);
    }

    @Test
    public void CheckInstanceOfControlPanel(){
        ElectricalPartsManufacturingStrategy strategy = new ControlPanelManufacturing ();

        assertTrue (strategy instanceof ControlPanelManufacturing);
    }

    @Test
    public void CheckInstanceOfMCB(){
        ElectricalPartsManufacturingStrategy strategy = new MCBManufacturing ();
        assertTrue (strategy instanceof MCBManufacturing);
    }

}
