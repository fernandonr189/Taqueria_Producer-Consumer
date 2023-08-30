import static java.lang.Thread.sleep;

public class Buffer {
    private String[] buffer;
    private int next;
    private boolean isFull;
    private boolean isEmpty;
    private int length;

    private boolean printLength;
    public Buffer() {
        this.length = (int)(Math.random() * (20) + 10);
        this.buffer = new String[this.length];
        this.next = 0;
        this.isEmpty = true;
        this.isFull = false;
        this.printLength = true;
    }

    public int getIndex() {
        return this.next;
    }

    public void updateLength() {
        this.length = (int)(Math.random() * (20) + 10);
        this.buffer = new String[this.length];
        this.printLength = true;
    }

    public synchronized String consume() {
        while(isEmpty) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            sleep((int)(Math.random() * 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        next--;
        if(next == 0) {
            String holder = buffer[next];
            isEmpty = true;
            isFull = false;
            updateLength();
            notifyAll();
            return holder;
        }
        return buffer[next];
    }

    public synchronized void produce(String _taco) {
        while (isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



        if(printLength) {
            System.out.println("New length: " + this.length);
            this.printLength = false;
        }

        buffer[next] = _taco + " (" + next + ")";
        next++;

        if(next == this.buffer.length) {
            isFull = true;
            isEmpty = false;
            notifyAll();
        }
    }
}
