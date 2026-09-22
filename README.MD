# Todo API

**Date:** September 22, 2026

This project is a Spring Boot Todo API for managing categories through REST endpoints.

## GitHub Repository

[GitHub Repository](YOUR_GITHUB_REPOSITORY_LINK_HERE)

## Endpoints

| Method | Endpoint              | Example                                                   |
| ------ | --------------------- | --------------------------------------------------------- |
| `GET`  | `/api/hello`          | `/api/hello` → `"Hello World!"`                           |
| `GET`  | `/api/categories`     | `/api/categories` → `[{"id":1,"name":"Work"}]`            |
| `GET`  | `/api/chosencategory` | `/api/chosencategory?chosen=1` → `{"id":1,"name":"Work"}` |
| `POST` | `/api/postcategories` | `/api/postcategories` → `{"name":"Work"}`                 |

## Design Decisions

Was the most simple and effective approach September 22, 2026.


## Reasons Behind Each Decision

Was the most simple and effective approach September 22, 2026.


## What Went Right

The endpoints were successfully created and tested using Postman, including retrieving categories and adding new categories while preventing duplicates. September 22, 2026.


## Challenges Faced

I initially had problems with the POST request because I forgot to add the request body in Postman, which caused the category object to be received as `null`.  September 22, 2026.


## Part I Enjoyed Most

For now none September 22, 2026