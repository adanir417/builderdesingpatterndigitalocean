package artificialintelligentexample;

public class OuterClass {

    private String name ;
    private int age;

    public OuterClass(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    public static class InnerClass {

        //private String name;
        //private int age;

        private String name = "isim girilmemiş";
        private int age = 0;

        public InnerClass withName(String name) {
            this.name = name;
            return this;
        }

        public InnerClass withAge(int age) {
            this.age = age;
            return this;
        }

        public OuterClass build() {
            return new OuterClass(name, age);
        }
    }
}
