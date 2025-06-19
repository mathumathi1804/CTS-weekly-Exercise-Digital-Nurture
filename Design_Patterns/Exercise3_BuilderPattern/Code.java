class Computer {
    private String cpu;
    private String Ram;
    private String storage;
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;

    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.Ram= builder.Ram;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    
    public void showSpecs() {
        System.out.println("cpu: " + cpu);
        System.out.println("Ram: " + Ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + (hasGraphicsCard ? "yes" : "no"));
        System.out.println("Bluetooth: " + (hasBluetooth ? "yes" : "no"));
    }

   
    public static class Builder {
        private String cpu;
        private String Ram;
        private String storage;
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        public Builder setcpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String Ram) {
            this.Ram = Ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean value) {
            this.hasGraphicsCard = value;
            return this;
        }

        public Builder setBluetooth(boolean value) {
            this.hasBluetooth = value;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class Main {
    public static void main(String[] args) {
       
        Computer basicComputer = new Computer.Builder()
            .setcpu("Intel i4")
            .setRam("4GB")
            .setStorage("256GB SSD")
            .build();

        System.out.println("**Basic Computer**");
        basicComputer.showSpecs();

        
        Computer gamingComputer = new Computer.Builder()
            .setcpu("Intel i8")
            .setRam("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard(true)
            .setBluetooth(true)
            .build();

        System.out.println("\n**Gaming Computer**");
        gamingComputer.showSpecs();
        System.out.println("Builder pattern implementation by Mathumathi");

    }
}
