package Services;

import java.io.IOException;

public interface Deletable {
    void StergereClient();
    void StergereClientMinCSV() throws IOException;
    void StergereClientMajCSV() throws IOException;
}
