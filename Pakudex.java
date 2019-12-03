import java.util.Arrays;
import java.util.Comparator;

public class Pakudex {
    //list of private variables used
    private Pakuri[] pakuris;
    private String[] size;
    private int capacity;
    private int[] stats = {0, 0, 0};
    private int numberOfPakuriAdded = 0;

    //sets the pakudex at 20 when called
    public Pakudex() {
        pakuris = new Pakuri[20];
        //this.size = new String[20];
    }
    //sets the pakudex to size 'capacity'
    public Pakudex(int capacity) {
        pakuris = new Pakuri[capacity];
        //this.size = new String[capacity];
    }
    //gets the number of pakuri in pakudex
    public int getSize() {
        for (int i = 0; i < pakuris.length; i++) {
            if (pakuris[i] != null) {
                capacity++;
            }
        }
        return this.capacity;

    }
    //gets total capacity
    public int getCapacity() {
        return pakuris.length;

    }
    //changes the pakuri array into a string array
    public String[] getSpeciesArray() {
        if (pakuris.length > 0 && pakuris[0] == null) {
            return null;
        }
        //makes the string size the total number of pakuris added to account for extra null values
        size = new String[numberOfPakuriAdded];
        if (pakuris[0] != null) {
            for (int i = 0; i < pakuris.length; i++) {
                if (pakuris[i] != null) {
                    size[i] = pakuris[i].getSpecies();
                }
            }
        }
        return size;
    }
    //returns the stats of the pakuri if it exists otherwise returns null
    public int[] getStats(String species) {
        for (int i = 0; i < pakuris.length; i++) {
            if (pakuris[i] != null && species.equals(pakuris[i].getSpecies())) {
                stats[0] = pakuris[i].getAttack();
                stats[1] = pakuris[i].getDefense();
                stats[2] = pakuris[i].getSpeed();
                return stats;
            }
        }
        return null;
    }
    //sorts pakuri in lexilogical ordering using insertion sorting
    public void sortPakuri() {
        for (int i = 1; i < pakuris.length; i++) {
            int previousIndex = i - 1;
            Pakuri currentPakuri = pakuris[i];

            if (currentPakuri == null) {
                break;
            }
            while (previousIndex >= 0 && currentPakuri.compareTo(pakuris[previousIndex]) < 0) {
                Pakuri previousPakuri = pakuris[previousIndex];
                pakuris[previousIndex] = currentPakuri;
                pakuris[previousIndex + 1] = previousPakuri;
                previousIndex--;
            }
        }
    }
    //adds a pakuri 'species' to the next available space in the pakudex
    public boolean addPakuri(String species) {
        for (int i = 0; i < pakuris.length; i++) {
            if (pakuris[i] != null && pakuris[i].getSpecies().equals(species)) {
                System.out.print("Error: Pakudex already contains this species!");
                return false;
            }
            if (pakuris[i] == null) {
                pakuris[i] = new Pakuri(species);
                numberOfPakuriAdded++;
                return true;
            }
        }
        //if no space are available in the pakudex this message is printed
        System.out.print("Error: Pakudex is full!");
        return false;
    }
    //evolves species if it exists in the pakudex
    public boolean evolveSpecies(String species) {
        for (int i = 0; i < pakuris.length; i++) {
            if (pakuris[i] != null && species.equals(pakuris[i].getSpecies())) {
                pakuris[i].evolve();
                return true;
            }

        }
        //returns false if it is not in the pakudex
        return false;
    }
}