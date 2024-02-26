import artificialintelligentexample.OuterClass;
import builder.Computer;

public class Main {
    public static void main(String[] args) {

       /**

        Bir adet builder isimli bir paket oluşturacağım.
        Daha sonra klasörün ne içerdiğini anlamak adına.
        Paket içerisinde bir adet bilgisayar sınıfımız olacak.

        Konum(Location)
        src/builder.Computer


        */

        // 26.02.2024 - 1 ABD Doları - 31,12 Türk Lirası

        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        Computer comp = new Computer.ComputerBuilder(
                "AMD Ryzen 9 7950X3D ",
                "Goodram IRDM 64 GB (2x32) 6400 MHz DDR5 CL32",
                "ROG CROSSHAIR X670E EXTREME",
                "ROG Strix GeForce RTX 4090 OC Edition 24GB GDDR6X",
                "ROG-THOR-1600T-GAMING",
                "ROG Hyperion EVA-02 Edition")
                .setWifiAndBluetoothEnabled(true) //Tüm mesele burada oluyor işte. Burada wifi'i set edilmiş bir instance geldi ama zincir devam ediyor.
                .setGraphicsCardEnabled(true)
                .setSoundCardEnabled(true)
                .build();

        Computer comp2 = new Computer.ComputerBuilder(
                "AMD Ryzen 9 7950X3D ",
                "Goodram IRDM 64 GB (2x32) 6400 MHz DDR5 CL32",
                "ROG CROSSHAIR X670E EXTREME",
                "ROG Strix GeForce RTX 4090 OC Edition 24GB GDDR6X",
                "ROG-THOR-1600T-GAMING",
                "ROG Hyperion EVA-02 Edition")
                .setWifiAndBluetoothEnabled(true)// Burada grafik ve ses kartları methodlarını çağırmadan build ediyorum.
                .build();

        System.out.println("comp1 : " + comp.isGraphicsCardEnabled()); // true
        System.out.println("comp2 : " + comp2.isGraphicsCardEnabled());// false

        // comp2 bilgisayarında ekran kartı methodunu içeren bir instance(örnek)  katmadığımız için build methodu sonrası
        // default değerler ile karşımıza getirdi.

        //Builder Desing Pattern böyle birşey.
        // Basitçe bir de Google'ın yapay zekası önerdiği örneği de yapalım. Çeşitlilik olsun.

        OuterClass outer = new OuterClass.InnerClass().withName("John").withAge(30).build();
        OuterClass outer2 = new OuterClass.InnerClass().withName("John").build();
        OuterClass outer3 = new OuterClass.InnerClass().withAge(30).build();

        OuterClass outer4 = new OuterClass.InnerClass().build();

        System.out.println("name : " + outer.getName());
        System.out.println("age : " + outer.getAge());

        System.out.println("name2 : " + outer2.getName());
        System.out.println("age2 : " + outer2.getAge());

        System.out.println("name3 : " + outer3.getName());
        System.out.println("age3 : " + outer3.getAge());

        System.out.println("name4 : " + outer4.getName());
        System.out.println("age4 : " + outer4.getAge());

        // göründüğü üzere builder kullanarak yapılandırdığımız değerlerde set edilmeyenler default olarak döndü.
        // default parametreleri değiştirerek başka sonuç alabiliriz mesela isimde null yerine isim girilmemiş.
        // bunun içinde builder içindeki değişkenleri set ediyoruz.


    }
}