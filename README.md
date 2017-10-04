# spellchecker
Spellchecker application using elasticsearch. The application uses spring data elasticsearch library.
On startup it creates index called **dictionary** and inserts few documents needed for testing.

### Starting application
 
    ./gradlew bootrun
 
### Configurations
 
 Application needs to connect to elasticsearch, the host and port can be configured in **application.properites** file.
 
 The elasticsearch version should be 2.4 as 5.x does not have spring-data-elasticsearch release yet.
 
 
### Testing the application
 
    Url: http://localhost:8080/spellCheck?word=disapint
    Response : {"word":"disapint","spellCheckWords":["disappoint"]}
 
 
### Info

  Few documents are inserted on startup in the file **SpellCorrectorApplication.java** file.
  Feel free to change or insert your own data.
  
  Mappings are present in the mappings file inside resources folder.