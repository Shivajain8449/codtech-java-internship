# Task 2: Java REST API Client

## 📌 Objective:
Create a Java application that:
- Sends an HTTP GET request to a public REST API
- Parses the JSON response
- Displays the data in a structured format

## 🌐 API Used:
- `https://jsonplaceholder.typicode.com/posts/1`  
  (Returns JSON object containing post `id`, `title`, and `body`)

## 🛠 Technologies Used:
- Java `HttpURLConnection` for sending HTTP requests
- **Gson** library for parsing JSON (`gson-2.10.1.jar`)

## 🧪 Sample Output:
'''ID: 1
Title: sunt aut facere repellat provident occaecati excepturi optio reprehenderit
Body: quia et suscipit
suscipit recusandae consequuntur expedita et cum
reprehenderit molestiae ut ut quas totam
nostrum rerum est autem sunt rem eveniet architecto'''