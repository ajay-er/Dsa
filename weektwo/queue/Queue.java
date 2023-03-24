package queue;

import java.util.LinkedList;

import repeat.linklistpart.QueueException;

public class Queue {

  private int capacity;
  private int[] data;
  private int front, rear;

  public Queue(int size) {
    data = new int[size];
    capacity = size;
    front = -1;
    rear = -1;
  }

  boolean isFull() {
    if (front == 0 && rear == capacity - 1) {
      return true;
    }
    return false;
  }

  public boolean isEmpty() {
    if (front == -1) {
      return true;
    }
    return false;
  }

  public void enQueue(int value) {
    if (isFull()) {
      System.out.println("Queue is full");
      return;
    } else {
      if (front == -1) {
        front = 0;
      }
      data[++rear] = value;
      System.out.println("item " + value + " inserted");
    }
  }

  public int deQueue() {
    int erase;

    if (isEmpty()) {
      System.out.println("Can't dequeue from empty array");
      return -1;
    }
    erase = data[front];
    if (rear == front) {
      rear = -1;
      front = -1;
    } else {
      front++;
    }
    return (erase);
  }

  public int peek() {
    int peek;

    if (isEmpty()) {
      System.out.println("Can't dequeue from empty array");
      return -1;
    }
    peek = data[front];
    return (peek);
  }

  void display() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return;
    } else {
      System.out.print("front " + front + "-->");
      for (int i = front; i <= rear; i++) {
        System.out.print(" " + data[i] + "-->");
      }
      System.out.println("rear " + rear);
    }
  }

}
