public abstract class Transport {
    public abstract void deliver();
    public Transport transport() {
        System.out.println("Transporting goods");
    }
} 

public class Truck extends Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by land in a box");
    }
}

public class Ship extends Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by sea in a container");
    }
}

public interface TransportMethod {
    Transport createTransport();

    void deliver();
}


public class TruckTransport implements TransportMethod {
    @Override
    public Transport createTransport() {
        return new Truck();
    }

    @Override
    public void deliver() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

public class ShipTransport implements TransportMethod {
    @Override
    public Transport createTransport() {
        return new Ship();
    }

    @Override
    public void deliver() {
        Transport transport = createTransport();
        transport.deliver();
    }
}


public class Executor {

    private static final String TRANSPORT_TYPE = "Truck"; // Change to "Ship" for ShipTransport

    public static void main(String[] args){
        TransportMethod transportMethod;

        if (TRANSPORT_TYPE.equals("Truck")) {
            transportMethod = new TruckTransport();
        } else if (TRANSPORT_TYPE.equals("Ship")) {
            transportMethod = new ShipTransport();
        } else {
            throw new IllegalArgumentException("Invalid transport type");
        }
        transportMethod.deliver();
    }
}p