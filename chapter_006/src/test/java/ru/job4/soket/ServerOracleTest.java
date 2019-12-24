package ru.job4.soket;
import com.google.common.base.Joiner;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * ServerOracleTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ServerOracleTest {
    private static final String LN = System.getProperty("line.separator");
    @Test
  public void whenReceiveExitThenClientAreFailed() throws IOException {
       this.testServerOracle("exit", "");
    }
    @Test
    public void whenReceiveQuestionThenSendSmartResponse() throws IOException {
        this.testServerOracle(Joiner.on(LN).join(
                "hello",
                "what's up",
                "exit"), String.format("Hello, dear friend, I'm a oracle.%s%s%s%s%s", LN, LN,
                "I'm wise, I can answer everything", LN, LN));
    }
    @Test
    public void whenReceiveQuestionThenSendAskMore() throws IOException {
        this.testServerOracle(Joiner.on(LN).join(
                "unsuppoted ask",
                "exit"), String.format("ask me something else.%s%s", LN, LN));
    }
    private void testServerOracle(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ServerOracle server = new ServerOracle(socket);
        server.connect();
        assertThat(out.toString(), is(expected));
    }
}