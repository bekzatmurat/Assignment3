import java.util.Random;

public class Test {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random random = new Random();
        int numberOfElements = 10000;

        for (int i = 0; i < numberOfElements; i++) {
            String key = "key" + random.nextInt(1000000);
            String value = "value" + i;
            table.put(new MyTestingClass(key), value);
        }

        for (int i = 0; i < 16; i++) {
            int count = table.getBucketSize(i);
            System.out.println("Bucket " + i + " contains " + count + " elements.");
        }
    }
}

