package kas.concurrente;

public class QNode {
    public volatile boolean locked;

    public QNode() {
        locked = false;
    }
}
