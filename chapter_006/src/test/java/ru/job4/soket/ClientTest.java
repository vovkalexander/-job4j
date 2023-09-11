package ru.job4.soket;
import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.net.Socket;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
/**
 * ClientTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
class ClientTest {
   private static final String LN = System.getProperty("line.separator");

  @Test
    public void  whenSendSmartQuestionThenReceiveResponse() throws IOException {
       Socket socket = mock(Socket.class);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(String.format("Hello, dear friend, I'm a oracle.%s%s", LN, LN)
             .getBytes());
       when(socket.getInputStream()).thenReturn(in);
       when(socket.getOutputStream()).thenReturn(out);
       String string = Joiner.on(LN).join(
              "hello",
              "exit");
       BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(string.getBytes())));
       Client client = new Client(socket, reader);
       client.start();
       assertThat(out.toString(), is(String.format("hello%s%s%s",  LN,
               "exit",  LN)));
    }
}