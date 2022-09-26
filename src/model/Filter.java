package model;

public abstract class Filter {

    private Filter next;

    protected abstract Object process(Object inputData);

    public Object execute(Object inputData) {
        Object value = process(inputData);
        if (this.next != null)
            value = this.next.execute(value);
        return value;
    }

    public void register(Filter nextFilter) {
        if (this.next == null)
            this.next = nextFilter;
        else
            this.next.register(nextFilter);
    }
}
