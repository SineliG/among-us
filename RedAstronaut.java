import java.util.Arrays;

public abstract class RedAstronaut extends Player implements Impostor {
    private String skill;
    private int susLevel;

    //Contructors
   /* public RedAstronaut (String name, int susLevel, String skill) {
        this.name = name;
        this.susLevel = susLevel;
        this.skill = skill;
    }
    */
    public RedAstronaut (String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
    }

    public RedAstronaut (String name) {
        this(name, 15, "experienced");
    }

    //Methods

    public String getSkill() {
        return skill;
    }

    public void emergencyMeeting() {
        // find the most suspicious player (i.e., the player with the highest susLevel)
        Player mostSuspicious = null;
        int maxSusLevel = -1;
        for (Player p : getPlayers()) {
            if (p == this) {
                continue;
            }
            if (!p.isFrozen() && p.getSusLevel() > maxSusLevel) {
                mostSuspicious = p;
                maxSusLevel = p.getSusLevel();
            }
        }
      
        // if a most suspicious player was found, vote them off
        if (mostSuspicious != null) {
          mostSuspicious.setFrozen(true);
        }
        gameOver();
      }
    
    @Override
    public void freeze(Player p) {
        // check if the passed-in Player object is an Impostor
        if (p instanceof Impostor) {
        // if the passed-in Player is an Impostor, end the method
        return;
        }

        // check if the passed-in Player is already frozen
        if (p.isFrozen()) {
        // if the passed-in Player is already frozen, end the method
        return;
        }

        // check if the freeze is successful
        if (this.getSusLevel() < p.getSusLevel()) {
        // if the freeze is successful, freeze the Player
            p.setFrozen(true);
        } else {
        // if the freeze is unsuccessful, double the RedAstronaut's susLevel
            this.susLevel *= 2;
        }
        gameOver();
    }   

    public void sabotage(Player p) {
        // check if the passed-in Player is an Impostor
        if (p instanceof Impostor) {
          // if the Player is an Impostor, do nothing and return
          return;
        }
      
        // check if the Player is frozen
        if (p.isFrozen()) {
            // if the passed-in Player is already frozen, end the method
            return;
        }
      
        // check if the RedAstronaut's susLevel is less than 20
        if (this.susLevel < 20) {

        }

          // if the RedAstronaut's susLevel is less than 20, increase the Player's susLevel by 50%
         
      

    
    /* 
    public void emergencyMeeting() {
        int[] testArray = new int[50];
        int max = testArray[0];
        for (int i = 0; i < getPlayers().length; i++) {
            if (!this.isFrozen()) {
                //this.getSusLevel();
                //Arrays.sort(getSusLevel());
                //Arrays.sort(getPlayers());
                testArray[i]=this.getSusLevel();
            }
                if (testArray[i] > max)
                    max = testArray[i];
            else {
                break;
            }
        }
        for (int i = 0; i < getPlayers().length; i++) {
            if (max == getSusLevel()) {
                this.isFrozen();
            }
        }
        gameOver();
    }

    public void freeze(Player p) {
        //freeze(p);
        for (Player i : getPlayers()) {
            if (this.getSusLevel() < Player.getSusLevel())
            if (i instanceof Impostor && !i.isFrozen()) {

            }
        }
    }

    public boolean equals(Object o) { //done i think
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.getSkill().equals(player.getSkill()); 
        }
        return false;
    }
    */

    public boolean equals(Object o) {
        // check if the passed-in Object is a RedAstronaut object
        if (o instanceof RedAstronaut) {
          RedAstronaut ra = (RedAstronaut) o;
          // compare the name, frozen, susLevel, and skill variables
          return this.getName().equals(ra.getName()) && this.isFrozen() == ra.isFrozen() && this.susLevel == ra.susLevel && this.skill.equals(ra.skill);
        } else {
          // if the passed-in Object is not a RedAstronaut, return false
          return false;
        }
      }
      

    public String toString() { //done
        String frozenString = isFrozen() ? "frozen" : "not frozen";
        
        if (this.getSusLevel() > 15) {
            String text = ("My name is " + this.getName() + ", and I have a susLevel of " + this.getSusLevel() + ". I am currently " + frozenString + ". I am an " + getSkill() + " player!");
            return text.toUpperCase();
        }
        else {
            return "My name is " + this.getName() + ", and I have a susLevel of " + this.getSusLevel() + ". I am currently " + frozenString + ". I am an " + getSkill() + " player!";
        }
		
    } 

}
