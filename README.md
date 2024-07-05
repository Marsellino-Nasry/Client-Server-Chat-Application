# Project : Client-Server Chat Application

#### Objective
Create a chat application where two computers can communicate with each other over a local network (LAN) or a shared hotspot without requiring an internet connection.

#### Components
1. **Server Computer**
   - Runs a server application that listens for incoming connections from clients.
   - Handles multiple client connections (if needed).
   - Facilitates message forwarding between clients.

2. **Client Computer**
   - Runs a client application that connects to the server.
   - Sends and receives messages to and from the server.
     
# Python Example :
### Implementation Steps

1. **Setting Up the Server**
   - **Initialize the Server Socket**: Create a socket object and bind it to a specific IP address and port.
   - **Listen for Connections**: Set the server to listen mode to accept incoming client connections.
   - **Handle Client Connections**: For each client connection, create a new thread to handle communication independently.

   ```python
   import socket
   import threading

   def handle_client(client_socket):
       while True:
           message = client_socket.recv(1024).decode('utf-8')
           if not message:
               break
           print(f"Received: {message}")
           client_socket.send(f"Echo: {message}".encode('utf-8'))
       client_socket.close()

   server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
   server.bind(('0.0.0.0', 5555))
   server.listen(5)
   print("Server listening on port 5555")

   while True:
       client_socket, addr = server.accept()
       print(f"Accepted connection from {addr}")
       client_handler = threading.Thread(target=handle_client, args=(client_socket,))
       client_handler.start()
   ```

2. **Setting Up the Client**
   - **Initialize the Client Socket**: Create a socket object and connect it to the server's IP address and port.
   - **Send and Receive Messages**: Implement a loop to send user-input messages to the server and display server responses.

   ```python
   import socket

   client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
   client.connect(('server_ip_address', 5555))

   def send_messages():
       while True:
           message = input("Enter message: ")
           client.send(message.encode('utf-8'))
           response = client.recv(1024).decode('utf-8')
           print(f"Server: {response}")

   send_messages()
   ```

3. **Testing the Connection**
   - **Set Up Network**: Ensure both computers are connected to the same LAN or hotspot.
   - **Run the Server**: Execute the server script on the server computer.
   - **Run the Client**: Execute the client script on the client computer.

4. **Enhancements**
   - **User Interface**: Develop a simple GUI using Tkinter (Python) or Java Swing for a more user-friendly chat interface.
   - **Encryption**: Implement basic encryption for message security using libraries like `ssl` (Python) or `javax.net.ssl` (Java).
   - **Multiclient Handling**: Extend server capabilities to handle multiple clients and broadcast messages.

# Summary
This project demonstrates the fundamental concepts of socket programming and network communication. By setting up a server-client architecture, you can create a simple yet powerful offline chat application that functions over a LAN or hotspot, making it ideal for environments without internet access.

Feel free to reach out if you need more details or help with specific parts of the implementation!
