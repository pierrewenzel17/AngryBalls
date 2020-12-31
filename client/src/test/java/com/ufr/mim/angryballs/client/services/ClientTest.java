package com.ufr.mim.angryballs.client.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.net.Socket;

import static org.mockito.Mockito.mock;

public class ClientTest {

    @Mock
    private Socket socket;

    @Test
    public void initListBalls() {
        /*Collection<SimpleBallDTO> simpleBallDTOCollection = new ArrayList<>();
        final SimpleBallDTO simpleBallDTO = new SimpleBallDTO(12, 50,"23", new Vecteur(50,50));
        simpleBallDTOCollection.add(simpleBallDTO);

        try (MockedStatic<SocketManager> mockedStatic = Mockito.mockStatic(SocketManager.class)) {
            mockedStatic
              .when(() -> SocketManager.initializeListBalls(simpleBallDTOCollection))
              .thenReturn(simpleBallDTO);

            Collection<SimpleBallDTO> result = SocketManager.initializeListBalls(simpleBallDTOCollection);

            assertEquals(simpleBallDTO, result.iterator().next());
        }*/


        // Using Mockito
        /*final Socket socket = mock(Socket.class);

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);



        assertEquals(simpleBallDTO, SocketManager.initializeListBalls(simpleBallDTOCollection));*/


        //assertTrue("Message sent successfully", SocketManager.initializeListBalls(simpleBallDTOCollection));
        //assertEquals("whatever you wanted to send".getBytes(), byteArrayOutputStream.toByteArray())




        /*final Socket socket = mock(Socket.class);

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        assertEquals(SocketDevice.sendJSONObject(socket, simpleBallDTO), );
        assertEquals(SocketDevice.receiveJSONObject(socket), );*/

        // Using Mockito
        //final Socket socket = mock(Socket.class);
        //final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);

        /*MovingBalls move = new MovingBalls(new DrawBallsWithFx(Collections.emptyList())) {
            @Override
            protected Socket createSocket() {
                return socket;
            }
        };

        assertNotNull(move.createTask());*/
        //assertEquals(true, move.createTask().getValue());
        //assertEquals(gson.toJson(simpleBallDTO).getBytes(), byteArrayOutputStream.toByteArray());
    }
}
