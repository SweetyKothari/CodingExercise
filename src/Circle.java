public class Circle implements Shape {

    private String color="ROUND";
    @Override
    public void draw() {
       System.out.println("Inside Circle "+color);
    }
}
