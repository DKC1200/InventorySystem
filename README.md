# Inventory System

A desktop **inventory management system built with Java and JavaFX** that provides a graphical interface for managing and tracking inventory items. The application enables users to create, update and organize inventory records through a structured and user-friendly interface.
Although this project is still under development, it demonstrates a modular architecture using object-oriented design principles combined with a responsive JavaFX interface suitable for desktop-based management tools.

---

# Overview

The Inventory System is designed to simplify inventory tracking and item management.  
It provides a clear interface for viewing and modifying inventory data while maintaining a separation between the application logic and the graphical interface.

The system focuses on maintainability and extensibility, allowing additional functionality such as persistent storage or advanced search capabilities to be integrated in future versions.

This project is currently under development.

---

# Key Features

- Create and manage inventory items
- Display items through a graphical user interface
- Edit existing item records
- Remove items from the inventory
- Track item quantities
- Modular Java application structure

---

# System Architecture

The project follows a structured layout separating responsibilities between application logic, data models, and user interface components.

```
src/
 ├── application      # Application entry point
 ├── controllers      # UI controllers and interaction logic
 ├── models           # Inventory and item data models
 └── views            # JavaFX UI components
```

This separation improves maintainability and supports future system expansion.

---

# Future Enhancements

Potential improvements include:

- Persistent data storage (SQLite or another database)
- Inventory search and filtering
- Item categorization
- Data import/export (CSV or JSON)
- total price column
- automatic color acording to quantity
- total items and total value
