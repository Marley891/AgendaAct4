package agendatelefonica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;



public final class AdminAgenda {
    
    HashMap<String, String> myContact = new HashMap<>();
    String[] arrayContacto;
    
    String inputFilename = "/Users/jesusantoniosanchezcaro/NetBeansProjects/AgendaTelefonica/src/agendatelefonica";
    String outputFilename = "/Users/jesusantoniosanchezcaro/NetBeansProjects/AgendaTelefonica/src/agendatelefonica";
    
    public AdminAgenda() {
    
  }
    
     public void cargarContactosFile() {
             BufferedReader bufferedReader=null;
             BufferedWriter bufferedWriter=null;
             
             try {
                bufferedReader = new BufferedReader (new FileReader(inputFilename));
                bufferedWriter = new BufferedWriter (new FileWriter(outputFilename));
                
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    arrayContacto= line.split(",");
                    myContact.put (arrayContacto[0], arrayContacto[1]);
                    
                }
             }
             
         catch(IOException e) {
             System.out.println("IOException catched while reading: " + e.getMessage());
             
         }
         finally {
             try {
                 if (bufferedReader != null) {
                     bufferedWriter.close();
                     
                 }
             }  
             catch  (IOException e) {
                 System.out.println("IOException catched while closing: " + e.getMessage());
             }
          }   
            
        }  
             
     public void mostrar() {
         myContact.entrySet().forEach(entry -> {
             String key = entry.getKey();
             String value = entry.getValue();
             
             System.out.println(key+ " " + value);
        });
         
     }

   public void addContacto(){
       System.out.println("Metodo addContacto ");
       myContact.put("33167893", "Daniel Sanchez");
       
  
   }
    
   public void actualizarContactosFile(){
       BufferedWriter bufferedWriter = null;
       
       try {
          bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));
         
          String line;
          for(HashMap.Entry<String,String> entry : myContact.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            
            line = key + "," +value;
            bufferedWriter.write(line+ "\n");
             
          }
           
       }
        catch  (IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        }
       finally {
           try {
               if (bufferedWriter != null) {
                     bufferedWriter.close();
           }
       }
       catch  (IOException e) {
            System.out.println("IOException catched while closing: " + e.getMessage());
   }
       }
   }
}
   

