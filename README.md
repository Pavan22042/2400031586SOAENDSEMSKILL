# Tourist Records API — JWT Token Validation + Swagger UI

Spring Boot REST API that validates a JWT Bearer token before returning all tourist records.

## Requirements
- Java 17+
- Maven 3.8+

## Run
```bash
mvn spring-boot:run
```
Application runs at `http://localhost:8080`.

## Step 1 — Inspect / obtain a token
Generate a demo JWT:
```bash
curl -X POST http://localhost:8080/api/auth/token \
  -H "Content-Type: application/json" \
  -d '{"username":"student","password":"password123"}'
```
Demo credentials: `student` / `password123`. The response contains `accessToken`.
The JWT filter reads the `Authorization: Bearer <token>` header and verifies the
signature and expiration. Invalid/expired tokens receive HTTP 401.

## Step 2 — Fetch all tourist records
```bash
curl http://localhost:8080/api/tourists \
  -H "Authorization: Bearer YOUR_ACCESS_TOKEN"
```
Expected sample data includes Aarav (Taj Mahal), Mia (Eiffel Tower), and Noah (Great Wall).
Calling this endpoint without a valid token returns HTTP 401.

## Step 3 — Test with Swagger UI
1. Open `http://localhost:8080/swagger-ui/index.html`.
2. First call `POST /api/auth/token` with:
   ```json
   {"username":"student","password":"password123"}
   ```
3. Copy the `accessToken` from the response.
4. Click **Authorize** and paste the token (or `Bearer <token>`, depending on the UI prompt).
5. Execute `GET /api/tourists` and confirm the records are returned.

## Endpoints
| Method | Endpoint | Authentication |
|---|---|---|
| POST | `/api/auth/token` | Public demo token endpoint |
| GET | `/api/tourists` | JWT Bearer token required |

> Demo note: credentials and signing secret are for local learning only. For production,
> use a persistent user store, externalized secret management, HTTPS, and role-based access.
