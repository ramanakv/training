package web.socket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatServer {
    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();
    
    @OnOpen
    public void onOpen(Session session) {
       String id = session.getId();
      
        sessions.add(session);
        session.getAsyncRemote().sendText("Welcome!");
        broadcastMessage("New user has joined the chat");
    }
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        sessions.remove(session);
        broadcastMessage("User has left the chat");
    }
    @OnError
    public void onError(Session session, Throwable ex) {
        logger.log(Level.INFO, "Web Socket Error",ex);
        session.getAsyncRemote().sendText(ex.getMessage()); 
    }
    @OnMessage
    public void onMessage(String message) {
        if(message == null || message.length() == 0){
            throw new RuntimeException("No actual message received");
        }
        broadcastMessage(message);
    }
    private void broadcastMessage(String message) {
        sessions.stream().forEach(s -> s.getAsyncRemote().sendText(message));
    }
    
}
