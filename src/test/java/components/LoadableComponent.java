package components;

public abstract class LoadableComponent<T> {

    protected abstract void isLoaded();

    @SuppressWarnings("unchecked")
    public T load() {
        isLoaded();
        return (T) this;
    }
}
