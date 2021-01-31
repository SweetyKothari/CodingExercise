public class ChildClass extends  BaseClass {

    public void doStuff(BaseClass b){
     System.out.println("Inside BaseClass");
    }
    public void doStuff(ChildClass b){
        System.out.println("Inside ChildClass");
    }
}
