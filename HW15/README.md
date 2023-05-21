Electrical Parts Manufacturing Appliaction

This Java application demonstrates strategic design patterns in the context of an electrical component manufacturing process. This application models the manufacturing of different types of electrical devices, each type of device requiring a different manufacturing process. This application provides an 
ElectricalPartsManufacturingStrategy interface with methods for material preparation, product assembly, product testing, and product packaging.

Three devices are currently in use:
Control panel, MCB, servo motor. Each device type has its own class that implements the ElectricalPartsManufacturingStrategy interface, specifically his ControlPanelManufacturing, MCBManufacturing, and ServoMotorManufacturing. File
Here is a list of important files in the application:


ElectricalPartsManufacturingStrategy.java:
This interface defines how each manufacturing strategy should implement.

ControlPanelManufacturing.java:
This class represents the manufacturing process of the control panel.

MCB Manufacturing.java:
This class represents the manufacturing process of an MCB.

Servo motor manufacturing.java:
A class that represents the manufacturing process of a servo motor.

Test Cases
The application includes a set of JUnit5 test cases. These test cases verify the correct functioning of each strategy.

