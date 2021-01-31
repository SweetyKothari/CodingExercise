
public class PubSubTest {
    public static void  main(String args[]) {
        PubSub.getInstance().subscribe("rand_int", new PubSubTest()::randIntCallback);
        PubSub.getInstance().subscribe("rand_int1", new PubSubTest()::randIntCallback);
        PubSub.getInstance().publish("rand_int", 46);
        PubSub.getInstance().publish("rand_int1", 48);
        PubSub.getInstance().publish("rand_int", 89);

    }

    public void randIntCallback(int number) {
        System.out.println(number);
    }
}