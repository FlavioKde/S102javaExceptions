# Cinema Seat Reservation System

## 📄 Description - Exercise Statement

This project involves developing an application for reserving seats in a cinema. The application will be used by ticket sellers to manage reservations.

### Functionality
- The application asks for the number of rows and seats per row in the cinema.
- A menu provides the following options:
  1. Show all reserved seats.
  2. Show seats reserved by a specific person.
  3. Reserve a seat.
  4. Cancel a seat reservation.
  5. Cancel all reservations by a person.
  0. Exit.

## 💻 Technologies Used
- Java
- Java Exception Handling
- Object-Oriented Programming (OOP)
- File Handling (for loading example reservations)
- Collections (ArrayList)

## 📋 Requirements
- Java Development Kit (JDK) 8 or higher
- An IDE such as IntelliJ IDEA or Eclipse

## 🛠️ Installation
1. Clone this repository:
   ```sh
   git clone https://github.com/your-repository/cinema-reservation.git
   ```
2. Navigate to the project directory:
   ```sh
   cd cinema-reservation
   ```
3. Open the project in your preferred Java IDE.

## ▶️ Execution
1. Run the `Main` class in your IDE.
2. Follow the on-screen prompts to interact with the reservation system.

## 🌐 Deployment
- The project can be packaged as a `.jar` file and run using the Java command line.
- If needed, integrate with a database or a web service for broader functionality.

## 🤝 Contributions
Contributions are welcome! Follow these steps:
1. Fork the repository.
2. Create a new branch: `git checkout -b feature/NewFeature`
3. Commit your changes: `git commit -m 'Add New Feature'`
4. Push to your branch: `git push origin feature/NewFeature`
5. Create a Pull Request.

---

# Additional Exercises

## Exercise 1: Product and Sales System
### Description
Create a `Product` class with attributes `name` and `price`. Implement a `Sale` class that contains a collection of products and the total sale price. 

### Exception Handling
- The `Sale` class includes a `calculateTotal()` method.
- If the product collection is empty, throw a custom exception `EmptySaleException` with the message "To make a sale, you must add products first."
- If products are present, calculate and store the total price.
- Create and catch an `IndexOutOfBoundsException` as part of the implementation.

## Exercise 2: User Input Handling
### Description
Create an `Input` class to handle keyboard input exceptions using `Scanner`. Implement static methods to read various data types, ensuring correct input format.

### Methods
- `readByte(String message)`
- `readInt(String message)`
- `readFloat(String message)`
- `readDouble(String message)`
- `readChar(String message)`
- `readString(String message)`
- `readYesNo(String message)`, where "s" returns `true` and "n" returns `false`.

### Exception Handling
- Use `InputMismatchException` for handling incorrect formats.
- If the input contains numbers instead of letters for names, throw a custom exception `InvalidNameException`.
- Keep prompting the user until valid input is provided.

## Exercise 3: Cinema Seat Reservation System
(As described above)

---

## 📌 Objective
Learn how to manage Java exceptions to build robust applications.

