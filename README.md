# 🍳 Fridgy - Your AI-Powered Kitchen Assistant

**Fridgy** is a full-stack web application designed to reduce food waste. It allows users to manage a virtual pantry and transform available ingredients into professional, step-by-step recipes using the **OpenAI API**.

---

## 🚀 Key Features

* **Smart Ingredient Selection:** A visual grid interface where users select ingredients to add to their "virtual fridge."
* **AI Recipe Generation:** Integrated **OpenAI API** that processes selected items to generate unique recipes with preparation times and cooking steps.
* **Community Explore:** A public feed where users can discover and view recipes created by others in the community.
* **User Accounts & Favorites:** Secure registration system where users can save their favorite AI-generated recipes.
* **Review System:** An interactive feature for users to rate and comment on recipes.
* **Ingredient Suggestion:** A flow for users to request new ingredients, which are then sent to the admin for approval.

---

## 🛡️ Live Admin Dashboard (Admin Only)

The application includes a restricted **Admin Panel** designed for platform management. Only users with the **Admin role** can access this area to see:
* **Live Statistics:** Real-time data on total users, recipes created, and total favorites across the platform.
* **Trending Ingredients:** Live tracking of which ingredients are most frequently used by the community.
* **Moderation Tools:** A dedicated interface to approve or reject new ingredient requests and manage the user database.

---

## 🛠️ Detailed Tech Stack

### **Backend (Spring Boot - MVC Architecture)**
The backend is built using a clean **MVC (Model-View-Controller)** pattern to ensure scalability and organized code:
* **Controllers:** Handle incoming REST API requests and manage communication with the frontend.
* **Services:** The "brain" of the app, where the business logic and OpenAI API integration live.
* **Repositories:** Interface with the MySQL database using Spring Data JPA.
* **Models/Entities:** Define the data structures for Users, Ingredients, and Recipes.
* **Spring Security:** Handles authentication and role-based access (Admin vs. Regular User).

### **Frontend (React.js)**
The user interface is built for speed and a smooth experience:
* **Component-Based Architecture:** Reusable UI components (buttons, cards, modals) for a consistent design.
* **Modern UI/UX:** A responsive layout with a clean grid system for ingredient selection.
* **State Management:** Efficiently handles user input, ingredient lists, and real-time UI updates.

### **AI & Database**
* **OpenAI API:** Used as the core logic for turning ingredient lists into high-quality culinary recipes.
* **MySQL:** A relational database used for persistent storage of all application data.

---

## 🧠 System Logic: How it Works

1.  **Selection:** The user picks ingredients from the React interface.
2.  **Request:** The **Controller** receives the data and passes it to the **Service** layer.
3.  **AI Integration:** The Service layer builds a prompt and calls the **OpenAI API**.
4.  **Live Updates:** Once a recipe is saved, the **Admin Dashboard** updates its statistics in real-time.

---

## 📸 Screenshots

### 🏠 User Experience & Core Flow
| Home & Landing | How it Works |
| :--- | :--- |
| ![Home](screenshots/HomePage1.jpg) | ![Guide](screenshots/HowItWorks.jpg) |

| Ingredient Selection | AI Recipe Output |
| :--- | :--- |
| ![Grid](screenshots/IngredientsSection.jpg) | ![Recipe](screenshots/Recipe.jpg) |

### 🛡️ Live Admin Panel (Restricted)
| Real-time Statistics | Ingredient Moderation |
| :--- | :--- |
| ![Stats](screenshots/Dashboard1.jpg) | ![Moderation](screenshots/Dashboard2.jpg) |

| User Database | New Ingredient Request |
| :--- | :--- |
| ![Users](screenshots/Dashboard3.jpg) | ![Suggest](screenshots/AddIngredients.jpg) |

### 🔐 Community & Authentication
| Community Feed | Reviews & Feedback |
| :--- | :--- |
| ![Explore](screenshots/Explore.jpg) | ![Reviews](screenshots/Review.jpg) |

| Login Interface | User Profile |
| :--- | :--- |
| ![Login](screenshots/LogIn.jpg) | ![Profile](screenshots/Profile.jpg) |

---
© 2025 Fridgy - Smart recipes from your ingredients.
