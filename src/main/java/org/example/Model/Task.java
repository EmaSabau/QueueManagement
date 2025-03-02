package org.example.Model;
public class Task {
    private int id;
    private int arrivalTime;
    private int processingTime;
    public Task(int id, int arrivalTime, int processingTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }
    public int getId() {
        return id;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getProcessingTime() {
        return processingTime;
    }
    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }
    @Override
    public String toString() {
        //return "Task ID: " + id + ", Arrival Time: " + arrivalTime + ", Processing Time: " + processingTime;
        return "(" + id + ", " + arrivalTime + ", " + processingTime + ") ";
    }
}
