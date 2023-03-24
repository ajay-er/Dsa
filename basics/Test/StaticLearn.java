   public class StaticLearn {
        int age ;
        String name ;
        static int car;

        public StaticLearn(int age, String name) {
            this.age = age;
            this.name = name;
            StaticLearn.car += 1;
        }
        
        public StaticLearn() {
        }

        public static void main(String[] ar){
            // StaticLearn s =new StaticLearn(18,"arun");
            // StaticLearn s1 =new StaticLearn(23,"jithin");
            // System.out.println(s.name);
            // System.out.println(s.age);
            // System.out.println(StaticLearn.car);


            //  StaticLearn s =new StaticLearn();
            //  s.method();

            method();

        }

        static  void method(){
            System.out.println("hi");
        }
    }   
