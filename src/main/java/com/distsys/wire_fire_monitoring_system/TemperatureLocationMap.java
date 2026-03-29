package com.distsys.wire_fire_monitoring_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a helper class to simulate tracking temperatures for various locations in the Zoo
 * Each location is mapped to one or more temperature values
 */
public class TemperatureLocationMap {

    Map<String, List<Integer>> mapTempLocation;

    /**
     * The temperature location map is initialised with some values
     */

    public TemperatureLocationMap() {

        mapTempLocation = new HashMap<String, List<Integer>>();

        // mock data for zones A
        List<Integer> AList = new ArrayList<>();
        AList.add(22);
        AList.add(21);
        AList.add(21);
        AList.add(22);
        AList.add(23);
        AList.add(22);
        AList.add(23);
        AList.add(20);
        AList.add(23);
        AList.add(21);
        mapTempLocation.put("Zone A", AList);

        // mock data for zones B
        List<Integer> BList = new ArrayList<>();
        BList.add(32);
        BList.add(31);
        BList.add(31);
        BList.add(32);
        BList.add(33);
        BList.add(32);
        BList.add(33);
        BList.add(30);
        BList.add(33);
        BList.add(31);
        mapTempLocation.put("Zone B", BList);

        // mock data for zones C
        List<Integer> CList = new ArrayList<>();
        CList.add(58);
        CList.add(57);
        CList.add(56);
        CList.add(53);
        CList.add(58);
        CList.add(57);
        CList.add(57);
        CList.add(57);
        CList.add(54);
        CList.add(53);
        mapTempLocation.put("Zone C", CList);

        // mock data for zones D
        List<Integer> DList = new ArrayList<>();
        DList.add(48);
        DList.add(44);
        DList.add(44);
        DList.add(45);
        DList.add(47);
        DList.add(44);
        DList.add(45);
        DList.add(43);
        DList.add(44);
        DList.add(45);
        mapTempLocation.put("Zone D", DList);

        System.out.println("Initial Temperature Info: ");
        mapTempLocation.forEach((key,values) ->
        System.out.println("Location:" + key +  "Temp: " + values));
    }
    
    /**
     * 
     * @param location
     * @return a list of temperature values for the location 
     */

    public List<Integer> getAllTemperaturesByLocation(String location) {
        return (List<Integer>) mapTempLocation.get(location);
    }
    
    
    /**
     * 
     * @param location
     * @return returns the last value in the list of temperatures for the given location
     */
       public Integer getCurrentTemperatureByLocation (String location) {

           List<Integer> theList = (List<Integer>) mapTempLocation.get(location);
           return theList.getLast();
    }

   
   
   /**
    * adds a temperature value to the set of values for the location
    * if the location does not exist - does nothing
    * @param location
    * @param tempValue 
    */
   public void setTemperature (String location,Integer tempValue ) {
       System.out.println("Update Temp at " + location + " to " + tempValue);
       List<Integer> theList = (List<Integer>) mapTempLocation.get(location);
       theList.add(tempValue);
       mapTempLocation.put(location, theList);
   }
   
}