public class Pakuri {
    private String species;
    private int attack, defense, speed;

    //basic constructor for pakuri
    public Pakuri(String species){
        this.species = species;
        this.attack = (this.species.length() * 7) + 9;
        this.defense = (this.species.length() * 5) + 17;
        this.speed = (this.species.length() * 6) + 13;
    }
    //returns species as a string instead of type pakuri
    public String getSpecies() {
        return species;
    }
    //a getter
    public int getAttack() {
        return attack;
    }
    //a getter
    public int getDefense() {
        return defense;
    }
    //a getter
    public int getSpeed() {
        return speed;
    }
    //sets the attack to newAttack
    public void setAttack(int newAttack) {
        this.attack = newAttack;
    }
    //evolves teh pakuri by changing its stats
    public void evolve() {
        this.attack = attack * 2;
        this.defense = defense * 4;
        this.speed = speed * 3;
    }
    //method for comparing pakuri
    public int compareTo(Pakuri pakuri) {
        if (pakuri == null) {
            return 1;
        }

        return species.compareTo(pakuri.getSpecies());
    }
}
