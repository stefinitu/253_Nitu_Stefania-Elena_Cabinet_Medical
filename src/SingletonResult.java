public class SingletonResult {
    private static Write write = null;
    public static synchronized Write getInstance(){
        if(write == null)
            write = new Write(0);
        return write;
    }
}
