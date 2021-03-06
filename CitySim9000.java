import java.util.*;

public class CitySim9000
{
    static LCG lcg;
    static Drivers drivers;
    
    public static void main(String args[])
    {        
        if(args.length != 1)
            System.out.println("Please provide number for random number generator seed.");
            
        else
        {
            mainInit(Integer.parseInt(args[0])); //setup necessary objects
            driveSim();
        }
    }
    
    //Creates LCG, Drivers, and randomly makes the 5 drivers
    public static void mainInit(int seed)
    {
    	lcg = new LCG(seed); //create lcg with seed as input
        drivers = new Drivers(lcg); //init drivers object
        drivers.genDrivers(); //generate random location for list of drivers
    }
    
    //Iterates over the 5 drivers, each driving randomly until location returns as "Outside City" and outputs to console what is happening
    public static void driveSim()
    {
    	for(int i=0; i<5; i++)
        {
            do //do-while used so drivers starting from outside city get to drive at least once before termination
            {
                drivers.drive(i); //drive function will print out to command line what is occuring
            } while(!drivers.getDriverLoc(i).equals("Outside City"));
            System.out.printf("Driver " + i + " has left the city!\n-----\n");
        }
    }
}
