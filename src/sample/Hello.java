package sample;

public class Hello {
    public Hello() {

    }

    private void sim() {

    }

    public void say() {
        {
            System.out.println("enter:" + System.currentTimeMillis() + "|class:" + getClass().getSimpleName() + "|Thread:" + Thread.currentThread().getId());
        }

        {
            System.out.println("exit:" + System.currentTimeMillis() + "|class:" + getClass().getSimpleName() + "|Thread:" + Thread.currentThread().getId());
        }
    }

    public void laugh() {

    }
}

