import java.io.IOException;

public interface IUSSD {
    public Account userAuth() throws IOException;
    public void startApplication() throws IOException;
    public void exit();
    public int appMenu();
    public int authMenu() throws IOException;
}
