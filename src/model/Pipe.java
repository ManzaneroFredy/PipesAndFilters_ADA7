package model;

public class Pipe {
    private Filter root;

    public Object execute(Object inputData) {
        return this.root.execute(inputData);
    }

    public Pipe register(Filter filter) {
        if (this.root == null)
            this.root = filter;
        else
            this.root.register(filter);
        return this;
    }
}
