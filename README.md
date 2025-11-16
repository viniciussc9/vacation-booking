# Landon Hotel – Multithreaded Cloud-Ready Scheduling App

A full-stack hotel scheduling application with a **Java / Spring Boot** back end and an **Angular** front end, enhanced with:

- Multithreaded **language localization** (English & French)
- **Time zone conversion** across ET, MT, and UTC
- Multi-currency **price display** (USD, CAD, EUR)
- A **Dockerized** deployment flow suitable for cloud hosting

Originally built as part of an advanced Java / Spring course, this project simulates a hotel reservation system for the fictional **Landon Hotel** in Toronto.

---

## Key Features

### 1. Multithreaded Localization (English & French)

- Uses **Java resource bundles** to support both English and French, as required in a Canadian setting.
- A **separate thread** is used for each language to demonstrate multithreaded behavior.
- Each thread loads its own resource bundle and prints a localized welcome message.

Example concept:

- Thread 1 → `messages_en.properties` → “Welcome to Landon Hotel!”
- Thread 2 → `messages_fr.properties` → “Bienvenue à l’hôtel Landon !”

This showcases:
- Resource bundle–driven i18n (internationalization)
- Safe, simple multithreaded access to localization logic

---

### 2. Multi-Currency Reservation Pricing

On the front end, reservation prices are displayed in three currencies on separate lines:

- **USD ($)**
- **CAD (C$)**
- **EUR (€)**

The focus is on front-end presentation and clear formatting, not live FX conversion. This demonstrates:

- Angular component templates and data binding
- Clean, user-friendly UI for multi-currency display

---

### 3. Time Zone Conversion (ET, MT, UTC)

The back end includes a Java method that converts times between:

- **Eastern Time (ET)**
- **Mountain Time (MT)**
- **Coordinated Universal Time (UTC)**

A message is generated that displays the time of an online, live presentation at Landon Hotel in all three time zones (hours and minutes), for example:

> “The presentation will be held at 14:00 ET / 12:00 MT / 19:00 UTC.”

This feature highlights:

- Use of the modern Java date/time API
- Time zone conversions with clear, user-facing formatting

---

### 4. Dockerized Full-Stack Application

The project includes a **Dockerfile** that builds a single image containing:

- The **Spring Boot** back end
- The **Angular** front end (built into static assets and served via the back end or a lightweight web server, depending on configuration)

This makes the application:

- Easy to run in a consistent environment
- Straightforward to deploy to a cloud provider (AWS, Azure, GCP, etc.)
- A practical example of containerizing a full-stack Java/Angular application

---

## Tech Stack

**Back End**

- Java
- Spring Boot
- Multithreading
- Java Resource Bundles (i18n)
- Java Time API for time zone handling

**Front End**

- Angular
- TypeScript
- HTML / CSS

**DevOps / Deployment**

- Docker
- Containerized full-stack build

---

## Project Structure (High-Level)

The exact folder names may vary slightly, but the project is organized roughly as follows:

```text
.
├── backend/                # Spring Boot source (Java packages, resources)
│   ├── src/main/java/...   # Controllers, services, time zone logic, threads
│   └── src/main/resources/
│       ├── messages_en.properties
│       └── messages_fr.properties
├── frontend/               # Angular application (components, services, assets)
├── Dockerfile              # Builds and runs the combined app
└── README.md

