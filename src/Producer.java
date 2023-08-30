

public class Producer extends Thread {
    String[] tiposDeTaco = new String[]{
            "Pastor",
            "Chorizo",
            "Suadero",
            "Bistec,",
            "Carnaza"
    };
    private Buffer buffer;
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
            String order = "orden de " + ((int)(Math.random() * (14) + 1)) + " tacos de " + tiposDeTaco[((int)(Math.random() * (tiposDeTaco.length)))];
            buffer.produce(order);
            System.out.println("(" + buffer.getIndex() + ") " + "Agregada " + order);
        }
    }
}
