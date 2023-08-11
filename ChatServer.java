package web.socket;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.Extension;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/{name}")
public class ChatServer {

    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();
    private static final Map<String, String> map = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) {
        WebSocketContainer container = session.getContainer();
        // default session timeout is 6 secs. setting to -1 will never timeout
        // container.setDefaultMaxSessionIdleTimeout(-1);
        session.setMaxIdleTimeout(-1);
        String id = session.getId();
        logger.log(Level.INFO, "Connection opened");
        sessions.add(session);
        map.put(id, name);
        session.getAsyncRemote().sendText("Welcome " + name);
        broadcastMessage(session, name + " has joined the chat");
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        String id = session.getId();
        String name = map.get(id);
        sessions.remove(session);
        map.remove(id);
        broadcastMessage(session, name + " has left the chat");
    }

    @OnError
    public void onError(Session session, Throwable ex) {
        logger.log(Level.INFO, "Web Socket Error", ex);
        session.getAsyncRemote().sendText(ex.getMessage());
    }

    @OnMessage
    public void onMessage(Session session, String message) {

        if (message == null || message.length() == 0) {
            session.getAsyncRemote().sendText("You have sent empty message");
        } else {
            String name = map.get(session.getId());
            broadcastMessage(session, name + ":   " + message);
        }
    }

    private void broadcastMessage(Session session, String message) {
        sessions.stream()
                .filter(s -> !(s.getId().equals(session.getId())))
                .forEach(s -> s.getAsyncRemote().sendText(message));
    }

}
