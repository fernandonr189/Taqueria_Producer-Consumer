public class Consumer extends Thread{
    private Buffer buffer;
    private int id;
    public Consumer(Buffer _buffer, int _id) {
        this.buffer = _buffer;
        this.id = _id;
    }

    @Override
    public void run() {
        while(true) {
            String order = buffer.consume();
            System.out.println("(" + (buffer.getIndex() + 1) + ") " + "Consumida " + order + " por mesero " + id);
        }
    }
}
