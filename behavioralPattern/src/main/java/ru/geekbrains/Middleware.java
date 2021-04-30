package ru.geekbrains;

public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(Request request);

    protected boolean checkNext(Request request) {
        if (next == null) {
            return true;
        }
        return next.check(request);
    }
}
