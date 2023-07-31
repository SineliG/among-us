public abstract class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;

    //CONSTRUCTORS

    public BlueAstronaut (String name, int susLevel, int numTasks, int taskSpeed) {
          // set the name, susLevel, numTasks, and taskSpeed attributes
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
      
        // constructor that takes in just the name and assigns default values to the other variables
    public BlueAstronaut(String name) {
          // set the name and default values for susLevel, numTasks, and taskSpeed
        this(name, 15, 6, 10);
    }

    
    //METHODS

    public Object getnumTask() { //idk
        return numTasks;
    }

    public void setnumTask(int newnumTask) { //idk
        taskSpeed = newnumTask;
    }

    public Object gettaskSpeed() { //idk
        return taskSpeed;
    }

    public void settaskSpeed(int newtaskSpeed) { //idk
        taskSpeed = newtaskSpeed;
    }

    public void emergencyMeeting() {
        // check if the BlueAstronaut is frozen
        if (!this.isFrozen()) {
          // if the BlueAstronaut is not frozen, find the most suspicious player
          Player mostSuspicious = null;
          for (Player p : getPlayers()) {
            if (!p.isFrozen()) {
              // consider only players that are not frozen
              if (mostSuspicious == null || p.getSusLevel() > mostSuspicious.getSusLevel()) {
                // if the current player is more suspicious than the most suspicious player, update the most suspicious player
                mostSuspicious = p;
              }
            }
          }
          if (mostSuspicious != null) {
            // if there is a most suspicious player, vote them off
            mostSuspicious.setFrozen(true);
          }
        }
        gameOver();
      }

    @Override
    public void completeTask() {
        // check if the BlueAstronaut is frozen
        if (!this.isFrozen()) {
          // if the BlueAstronaut is not frozen, check the task speed
            if (this.taskSpeed > 20) {
            // if the task speed is greater than 20, decrement the number of tasks by 2
            this.numTasks -= 2;
        } else {
            // if the task speed is less than or equal to 20, decrement the number of tasks by 1
            this.numTasks--;
        }
    
          // check if the number of tasks is less than 0
        if (this.numTasks < 0) {
            // if the number of tasks is less than 0, set it to 0
            this.numTasks = 0;
        }
    
          // check if the number of tasks is 0
        if (this.numTasks == 0) {
            // if the number of tasks is 0, print a message
            System.out.println("I have completed all my tasks");
            this.setSusLevel((int) (getSusLevel()*0.5));
        }
      

    public void completeTask() { //done i think
		if (!this.isFrozen()) {
            if (taskSpeed > 20) {
                numTasks = numTasks - 2;
                if (numTasks <= 0) {
                    numTasks = 0;
                    System.out.println("I have completed all my tasks");
                    setSusLevel(this.getSusLevel()/2);
                }
            }
            else {
                numTasks = numTasks - 1;
                if (numTasks <= 0) {
                    numTasks = 0;
                    System.out.println("I have completed all my tasks");
                    setSusLevel(this.getSusLevel()/2);
                }
            }
        }
    }

    public boolean equals(Object o) { //done i think
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.getName().equals(player.getName()) && this.isFrozen() == player.isFrozen()
                    && this.getSusLevel() == player.getSusLevel() && this.getnumTask().equals(player.getnumTask())
                    && this.gettaskSpeed().equals(player.gettaskSpeed()); 
        }
        return false;
    }

    public String toString() { //done
        String frozenString = isFrozen() ? "frozen" : "not frozen";
        return "My name is " + this.getName() + ", and I have a susLevel of " + this.getSusLevel() + ". I am currently " + frozenString + ". I have " + getnumTask() + " left over.";
		
    }
}
