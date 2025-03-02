package org.example.Logic;
import org.example.Model.Server;
import org.example.Model.Task;
import java.util.List;
import java.util.concurrent.BlockingQueue;
public class ConcreteStrategyTime implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
        Server shortestTimeServer = servers.get(0);
        for (Server server : servers) {
            if (server.getWaitingPeriod().intValue() < shortestTimeServer.getWaitingPeriod().intValue()) {
                shortestTimeServer = server;
            }
        }
        shortestTimeServer.addTask(t);
    }
}
