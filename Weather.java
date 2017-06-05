import java.util.Random;
import java.sql.*;


class Randomid {
  
  static int randomInt(int max){
    
    //Generate a random integer between 0 and max value
      Random randomGenerator = new Random();
      int randomInt = randomGenerator.nextInt(max);
         
      return randomInt ;
     }
  


  // Genrate a random Double between min and max value
  static double randomInRange(double min, double max) {

   double range = max - min;
   Random random=new Random();
   double scaled = random.nextDouble() * range;
   double shifted = scaled + min;
   return shifted; // == (rand.nextDouble() * (max-min)) + min;
   }


}


class LocPosTime {

   // Initialising location and position array with 20 values
   // Can be modified to read from a seperate file
   String[] location = {"Sydney","Melbourne","Brisbane","Perth","Adelaide","Gold Coast","New Castle","Canberra","Sunshine Coast","Wollongong","Hobart","Geelong","Townsville","Cairns","Darwin","Toowoomba","Ballart","Bendigo","Albury","Launceston"} ;

   String[] position = {"-33.86,151.21,39","-37.83,144.98,7","-27.28,153.02,25","-31.57,115.51,9","-34.92,138.62,48","-28.01,153.24,18","-32.55,151.45,9","-35.18,149.07,557","-26.39,153.04,11","-34.25,150.52,5","-42.52,147.19,288","-38.09,144.21,14","-19.15,146.49,153","-16.55,145.46,78","-12.27,130.50,55","-27.34,151.57,691","-37.33,143.51,435","-36.45,144.16,225","-36.04,146.54,165","-41.26,147.8,33"} ;

   String getLocation(int indx) {

      String loc = location[indx] ;

      return loc ;     

   }

   String getPosition(int indx) {

      String pos = position[indx] ;

      return pos ;     

   }


   Timestamp getTime() {

     //Start datetime for reading timestamps  
     long offset = Timestamp.valueOf("2016-06-02 00:00:00").getTime();

     //End datetime for reading timestamps
     long end = Timestamp.valueOf("2017-06-02 00:00:00").getTime();

     long diff = end - offset + 1;

     Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));

     return rand ;

   }

} 

class Weather {
    
   // Initialising weather conditions  array with 5 string values
   // Can be modified to read from a seperate file
   String[] condition = {"Sunny","Cloudy","Rain","Snow","Storm"} ;

   String getCondition(int indx) {

      String con = condition[indx] ;

      return con ;     

   }


   double getTemp(int indx) {
      
      // generating temperature value depending on the type of weather condition mentioned 
      String con = condition[indx] ;
      double temp = 0;
      switch (con) {
      
         case "Sunny":

              temp =  Randomid.randomInRange(28.00,45.00) ;

              break ; 

         case "Cloudy":

              temp =  Randomid.randomInRange(22.00,35.00) ;

              break ;

         case "Rain":

              temp =  Randomid.randomInRange(18.00,25.00) ;

              break ;
      
         case "Snow":

              temp =  Randomid.randomInRange(-10.00,-1.00) ;

              break ;

         case "Storm":

              temp =  Randomid.randomInRange(5.00,12.00) ;

              break ;
      
      }

      return temp ;     

   }


    double getPressure(int indx) {
      
      // generating pressure value depending on the type of weather condition mentioned  
      String con = condition[indx] ;
      double pres = 0;
      switch (con) {
      
         case "Sunny":

              pres =  Randomid.randomInRange(1200.00,1400.00) ;

              break ; 

         case "Cloudy":

              pres =  Randomid.randomInRange(1000.00,1200.00) ;

              break ;

         case "Rain":

              pres =  Randomid.randomInRange(800.00,1000.00) ;

              break ;
      
         case "Snow":

              pres =  Randomid.randomInRange(600.00,800.00) ;

              break ;

         case "Storm":

              pres =  Randomid.randomInRange(200,600.00) ;

              break ;
      
      }

      return pres ;     

   }


    double getHumidity(int indx) {

      // generating Humidity value depending on the type of weather condition mentioned  
      String con = condition[indx] ;
      double humid = 0;
      switch (con) {
      
         case "Sunny":

              humid =  Randomid.randomInRange(10.00,30.00) ;

              break ; 

         case "Cloudy":

              humid =  Randomid.randomInRange(70.00,90.00) ;

              break ;

         case "Rain":

              humid =  Randomid.randomInRange(90.00,99.00) ;

              break ;
      
         case "Snow":

              humid =  Randomid.randomInRange(30.00,70.00) ;

              break ;

         case "Storm":

              humid =  Randomid.randomInRange(5.00,10.00) ;

              break ;
      
      }

      return humid ;     

   }


    public static void main(String [ ] args)

   {
      LocPosTime lpt = new LocPosTime();
    
      Weather wthr  = new Weather();     

      for(int i=0; i<100; i++){
          
      
              //Generating a random integer in the 0-19 range to choose location from the 20 value location array
              int indx = Randomid.randomInt(19);
              
              //Generating a random integer in the 0-4 range to choose location from the 5 value weather condition array
              int indx2 = Randomid.randomInt(4);

              String l = lpt.getLocation(indx) ;

              String p = lpt.getPosition(indx) ;

              Timestamp t = lpt.getTime() ;

              String c = wthr.getCondition(indx2) ;

              double temp = (double) Math.round(wthr.getTemp(indx2)* 10) / 10;

              double pres = (double) Math.round(wthr.getPressure(indx2)* 10) / 10;
                            
              int humid = (int) Math.round(wthr.getHumidity(indx2)) ;
              
              
              // Printing readings from weather simulation in the defined format
              // Can be modified to write to a file or any other desired method of output 
              System.out.println(l + " | " + p + " | " + t + " | " + c + " | " + temp + " | " + pres + " | " + humid + "\n" );
         }

    }

}