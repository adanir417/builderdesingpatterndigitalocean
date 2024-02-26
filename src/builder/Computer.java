package builder;

public class Computer {

    //required parameters
    //Gerekli parametreler(bu arkadaşlar bilgisayar toplarken gerekli parçalar.)
    //işlemci(central process unit)
    private String cpu;
    //ram(random access memory(ram))
    private String ram;
    //anakart
    private String motherboard;
    //ekran kartı(graphic process unit(gpu))
    private String gpu;
    //güç kaynağı(power supply unit(psu))
    private String psu;

    //Tabi son olarak bu parçaların hepsini tutacak bir kasa
    private String computerCase;


    //optional parameters
    //İsteğe bağlı parametreler(bu arkadaşlar bilgisayar toplarken olmazsa olmaz parçalardan değildir.)
    private boolean isGraphicsCardEnabled;
    private boolean isWifiAndBluetoothEnabled;
    private boolean isSoundCardEnabled;

    //Burası çokomelli
    //Getter oluşturuyoruz ve set etme işini innerclass'a bırakıyoruz
    // inner class ne ola ki. Tamamen aşağıda :D


    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getGpu() {
        return gpu;
    }

    public String getPsu() {
        return psu;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isWifiAndBluetoothEnabled() {
        return isWifiAndBluetoothEnabled;
    }

    public boolean isSoundCardEnabled() {
        return isSoundCardEnabled;
    }

    public String getComputerCase() {
        return computerCase;
    }

    //Burada bir yapılandırıcımız olacak.
    // Ve bizim için set işlemini yani atama işini yapacak.
    // Liyakat desen var. Düzen desen var :D
    //There is constructor here.
    // And this constructor job is to set values to recommended variable.
    private Computer(ComputerBuilder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.motherboard = builder.motherboard;
        this.gpu = builder.gpu;
        this.psu = builder.psu;
        this.computerCase = builder.computerCase;

        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isWifiAndBluetoothEnabled = builder.isWifiAndBluetoothEnabled;
        this.isSoundCardEnabled = builder.isSoundCardEnabled;

    }

    // Şimdi inner class oluşturma vakti
    //Builder Class
    public static class ComputerBuilder{
        //required parameters
        //Gerekli parametreler(bu arkadaşlar bilgisayar toplarken gerekli parçalar.)
        //işlemci(central process unit)
        private String cpu;
        //ram(random access memory(ram))
        private String ram;
        //anakart
        private String motherboard;
        //ekran kartı(graphic process unit(gpu))
        private String gpu;
        //güç kaynağı(power supply unit(psu))
        private String psu;

        //Tabi son olarak bu parçaların hepsini tutacak bir kasa
        private String computerCase;


        //optional parameters
        //İsteğe bağlı parametreler(bu arkadaşlar bilgisayar toplarken olmazsa olmaz parçalardan değildir.)
        private boolean isGraphicsCardEnabled;
        private boolean isWifiAndBluetoothEnabled;
        private boolean isSoundCardEnabled;


        //Olmazsa olmaz parçaları parametre olarak alıyoruz
        // Tabi ki bu bir constructor.
        public ComputerBuilder(String cpu, String ram, String motherboard, String gpu, String psu, String computerCase) {
            this.cpu = cpu;
            this.ram = ram;
            this.motherboard = motherboard;
            this.gpu = gpu;
            this.psu = psu;
            this.computerCase = computerCase;
        }

        //Bu setter sınıflarda void değilde ComputerBuilder döndüğümüze dikkat edelim.
        public ComputerBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            isGraphicsCardEnabled = graphicsCardEnabled;
            return this;

        }

        //Bu setter sınıflarda void değilde ComputerBuilder döndüğümüze dikkat edelim.
        public ComputerBuilder setWifiAndBluetoothEnabled(boolean wifiAndBluetoothEnabled) {
            isWifiAndBluetoothEnabled = wifiAndBluetoothEnabled;
            return this;
        }

        //Bu setter sınıflarda void değilde ComputerBuilder döndüğümüze dikkat edelim.
        public ComputerBuilder setSoundCardEnabled(boolean soundCardEnabled) {
            isSoundCardEnabled = soundCardEnabled;
            return this;
        }

        //Bu setterlar return this ifadesi inner class'ın bir instance'ını dönecek.

        // tamam biz bir örnek gönderdik ama en son yapılanmış örneği nasıl elde edeceğiz.
        // o da tam burada

        public Computer build() {
            //private Computer(ComputerBuilder builder){...}
            //Bu arkadaş tamda bu yapılandırıcıyı bu örnek ile toplayıp kapatacak.
            // Yani biz main üzerinde .build() ile yapılandırmayı sonlandırdığımızda build önceki instancelar var ya da yok
            // fark etmeksizin buradan bir Computer instance'ını main içine gönderip set edecek.

            return new Computer(this);
        }

    }


}
