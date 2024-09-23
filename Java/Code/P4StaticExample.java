public class P4StaticExample {
    private static int count = 0;
    
    private int instanceNumber;

    public P4StaticExample(){
        count++;
        instanceNumber = count;
    }

    public void display(){
        System.out.println("Instance Number:" + instanceNumber+"\n"+"Count: "+count);

    }

    public static void main(String[] args) {
        P4StaticExample obj1 = new P4StaticExample();
        obj1.display();
        P4StaticExample obj2 = new P4StaticExample();
        obj2.display();
        P4StaticExample obj3 = new P4StaticExample();
        obj3.display();
    }
  
}
