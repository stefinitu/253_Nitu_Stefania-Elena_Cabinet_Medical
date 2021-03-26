import java.util.UUID;

public interface IdentifiableCons {
default String generateID()
{
    return UUID.randomUUID().toString();
}
String genID();
}
