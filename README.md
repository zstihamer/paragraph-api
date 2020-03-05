# docu-paginator
A document paginator JAVA REST API for an angular virtual scrolling demo project: https://github.com/zstihamer/ag-inifitie-reader

## Set CORS 
Set CORS at ParagraphService.java 
`@CrossOrigin(origins = "http://localhost:4200")`
 
## Server port settings
At  `application.properties` default port is `server.port=8182`

## Run in localhost
Win CMD 
Run: mvnw spring-boot:run or in IDEA spring-boot plugin run

## Test
The server is available at http://localhost:8182/paragraphs
