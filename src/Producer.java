

public class Producer extends Thread {
    String[] typeOfTaco = new String[]{
            "Pastor",
            "Chorizo",
            "Suadero",
            "Bistec,",
            "Carnaza"
    };
    private final Buffer buffer;
    public Producer(Buffer _buffer) {
        this.buffer = _buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String order = "orden de " + ((int)(Math.random() * (14) + 1)) + " tacos de " + typeOfTaco[((int)(Math.random() * (typeOfTaco.length)))];
            buffer.produce(order);
            System.out.println("(" + buffer.getIndex() + ") " + "Agregada " + order);
        }
    }
}
