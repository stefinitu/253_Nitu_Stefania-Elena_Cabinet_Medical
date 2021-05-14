public class SingletonBD {
    private static BDClientMajor bdClientMajor = null;
    private static BDClientMinor bdClientMinor = null;
    private static BDMedic bdMedic = null;
    private static BDProgramareMaj bdProgramareMaj=null;
    private static BDProgramareMin bdProgramareMin=null;
    public static synchronized BDClientMajor getInstanceMaj(){
        if(bdClientMajor == null)
            bdClientMajor = new BDClientMajor();
        return bdClientMajor;
    }

    public static synchronized BDClientMinor getInstanceMin(){
        if(bdClientMinor == null)
            bdClientMinor = new BDClientMinor();
        return bdClientMinor;
    }

    public static synchronized BDMedic getInstanceMed(){
        if(bdMedic == null)
            bdMedic = new BDMedic();
        return bdMedic;
    }

    public static synchronized BDProgramareMaj getInstancePrMaj(){
        if(bdProgramareMaj == null)
            bdProgramareMaj = new BDProgramareMaj();
        return bdProgramareMaj;
    }

    public static synchronized BDProgramareMin getInstancePrMin(){
        if(bdProgramareMin == null)
            bdProgramareMin = new BDProgramareMin();
        return bdProgramareMin;
    }
}
