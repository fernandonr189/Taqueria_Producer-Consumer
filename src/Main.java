// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer[] consumers = new Consumer[8];
        producer.start();
        for(int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer(buffer, i);
            consumers[i].start();
        }
    }
}