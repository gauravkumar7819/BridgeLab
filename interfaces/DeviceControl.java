package interfaces;

public interface DeviceControl {
    void turnOn();
    void turnOff();
}

// Light Device Implementation
class Light implements DeviceControl {
    @Override
    public void turnOn() {
        System.out.println("Light turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Light turned off");
    }
}

// AC Device Implementation
class AC implements DeviceControl {
    @Override
    public void turnOn() {
        System.out.println("AC turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("AC turned off");
    }
}