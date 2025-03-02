package org.example.Logic;
import org.example.Model.Server;
import org.example.Model.Task;
import java.util.List;
import java.util.concurrent.BlockingQueue;
public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
        Server smallestQueueServer = servers.get(0);
        for (Server server : servers) {
            if (server.getQueueSize() < smallestQueueServer.getQueueSize()) {
                smallestQueueServer = server;
            }
        }
        smallestQueueServer.addTask(t);

    }
}
