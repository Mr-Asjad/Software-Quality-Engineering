- open maven from right sidebar

# JaCoCo
`mvn clean test jacoco:report`

# SonarQube 
- `mvn clean verify sonar:sonar -Dsonar.projectKey=flight-reservation-system -Dsonar.projectName='flight-reservation-system' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_25ca30d07246d3f355f42787cdc26e822934b27d`