public class SingletonCitire {
    private static Read read = null;
    public static synchronized Read getInstanceRead(){
        if(read == null)
            read = new Read();
        return read;
    }
}
