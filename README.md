# robot-apocalypse

## The spring boot ROBOT apocalypse application

### Main features:
1.  Add survivors to the database
- A survivor must have a name, age, gender, ID and last location (latitude, longitude).
- A survivor also has an inventory of resources declared upon registration.


2. Update survivor location
- A survivor must have the ability to update their last location

3. Flag survivor as infected
- we need to flag infected survivors.
- A survivor is marked as infected when at least three other survivors report their contamination.

4. Connect to the Robot CPU system

5. Reports

#### Clone the repository
git clone https://gitlab.com/devphilip/robot-apocalypse.git
#### Move into the cloned directory
cd robot-apocalypse
#### Run the app with maven
mvn spring-boot:run

### Swagger documentation
http://localhost:8080/api/robot-apocalypse/swagger-ui.html

### Testing with curl

#### Add survivor
```
curl --request POST 'http://localhost:8080/api/robot-apocalypse/survivors' --header 'Content-Type: application/json' --data-raw '{"id": 14, "name": "Ada James","gender": "FEMALE", "age": 28, "resources": ["WATER", "FOOD", "MEDICATION", "AMMUNITION"], "location": {"latitude": 18.2345671, "longitude": 42.3213432}}'
```
#### View all survivors
```
curl --request POST 'http://localhost:8080/api/robot-apocalypse/survivors'
```

#### Update survivor's location
```
curl --request PUT 'http://localhost:8080/api/robot-apocalypse/survivors/1/location' --header 'Content-Type: application/json' --data-raw '{"latitude": 18.2345671, "longitude": 42.3213432}'
```

#### Flag survivor as infected
```
curl --location --request PUT 'http://localhost:8080/api/robot-apocalypse/survivors/1/mark-as-infected'
```
