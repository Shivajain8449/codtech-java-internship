# Task 3: Java Multithreaded Chat Application

## 📌 Objective:
Create a terminal-based Java application where:
- A server handles multiple clients using threads
- Clients can send and receive chat messages in real-time

## 🛠 Technologies:
- Java Sockets (`Socket`, `ServerSocket`)
- Java Threads
- Terminal I/O

## 📄 Files:
- `ChatServer.java` - Listens for and broadcasts messages to clients
- `ChatClient.java` - Connects to server and sends/receives messages

## ▶️ How to Run

## Compile:
```bash
javac ChatServer.java
javac ChatClient.java

## 🧪 Sample Output:
'''Server:
arduino
Copy
Edit
🔌 Server is running...
✅ Client connected: Socket[addr=/127.0.0.1,port=XXXXX,localport=1234]
📨 Received: Hello everyone!
Client:
pgsql
Copy
Edit
✅ Connected to server!
Hello everyone!
👥 Hello everyone!'''
