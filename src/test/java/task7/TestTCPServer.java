package task7;

import com.epam.perkovdenys.task7.factory.TCPFactory;

import com.epam.perkovdenys.task7.server.Client;
import com.epam.perkovdenys.task7.server.Server;
import com.epam.perkovdenys.task7.utils.ServerConstants;

import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class TestTCPServer {

    @Before
    public void startServers(){

       Server server = new Server(ServerConstants.TCP_PORT);


      /* *//**//* MailService mailService = EasyMock.createMock(MailService.class);
        ContactServiceImpl contactService = new ContactServiceImpl();
        contactService.setMailService(mailService);
        expect(mailService.send("Hello", "Hello, world", "user@mail.com")).andReturn(true);
        EasyMock.replay(mailService);
        contactService.setEmail("user@mail.com");
        contactService.sendEmail("Hello", "Hello, world");
        EasyMock.verify(mailService);*//**//**/
    }

    @Test
    public void shutdownTCP() throws IOException {
     //   Server server = new Server(ServerConstants.TCP_PORT);
        Server.shutdownTCP();
    }

    @Test
    public void getCount() throws IOException {
        Client asker = mock(Client.class);
        Client.main(null);
        when(asker.readCommand()).thenReturn(anyString());


    }



}
