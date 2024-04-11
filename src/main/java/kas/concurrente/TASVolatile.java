package kas.concurrente;

import java.util.concurrent.atomic.AtomicBoolean;

public class TASVolatile implements Lock {
    private volatile boolean state = false;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getAndSet(boolean state) {
        boolean actual = this.state;
        this.state = state;
        return actual;
    }

    @Override
    public void lock() {
        while (this.getAndSet(state))
            ;
    }

    @Override
    public void unlock() {
        this.setState(false);

    }

}
