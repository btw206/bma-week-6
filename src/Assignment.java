
public class Assignment {

	public static void main(String[] args) {
		Task[] tasks = new Task[] {
			new WorkTask("Add page", 2, false, "Website Redesign"),
			new WorkTask(),
			new ShoppingTask("Get Milk", 7, true, "Stop and Shop"),
			new ShoppingTask(),
			new BuyGiftTask(4, true, "birthday", "Mom"),
			new BuyGiftTask(),
		};
		
		for(int i=0; i<tasks.length; i++) {
			printTask(tasks[i]);
		}
		
		System.out.println("Marking the work task complete...");
		tasks[0].markComplete();
		printTask(tasks[0]);
		
		System.out.println("Updating the due in days to 3 for the shopping task...");
		tasks[2].updateDueInDays(3);
		printTask(tasks[2]);
	}
	
	private static void printTask(Task taskName) {
		System.out.println(taskName);
	}
}

abstract class Task {
	private String description;
	private int dueInDays;
	private boolean complete;
	private boolean repeat;
	private boolean restrictedHours;
	
	Task(String description, int dueInDays, boolean repeat, boolean restrictedHours) {
		this.description = description;
		this.dueInDays = dueInDays;
		this.complete = false;
		this.repeat = repeat;
		this.restrictedHours = restrictedHours;
	}
	
	Task() {
		this("Needs description", 0, false, false);
	}
	
	public String toString() { 
		return "";
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getDueInDays() {
		return dueInDays;
	}
	
	public boolean getComplete() {
		return complete;
	}
	
	public boolean getRestrictedHours() {
		return restrictedHours;
	}
	
	public void markComplete() {
		this.complete = true;
	}
	
	public void updateDueInDays(int updatedDays) {
		this.dueInDays = updatedDays;
	}
}

class WorkTask extends Task {
	private String project;
	
	WorkTask() {
		super();
		project = "for what?";
	}
	
	WorkTask(String description, int dueInDays, boolean repeat, String project) {
		super(description, dueInDays, repeat, false);
		this.project = project;
	}
	
	public String toString() {
		return "Task - Description: " + getDescription() + ", " +
				"For: " + project + ", " +
				"Due In: " + getDueInDays() + 
				" days, Complete: " + getComplete();
	}
}

class ShoppingTask extends Task {
	private String store;
	
	ShoppingTask() {
		super();
		store = "where?";
	}
	
	ShoppingTask(String description, int dueInDays, boolean repeat, String store) {
		super(description, dueInDays, repeat, true);
		this.store = store;
	}
	
	public String toString() {
		return "Task - Description: " + getDescription() + ", " +
				"At: " + store + ", " +
				"Need Within: " + getDueInDays() + 
				" days, Complete: " + getComplete();
	}	
}

class BuyGiftTask extends Task {
	private String occasion;
	private String recipient;
	
	BuyGiftTask() {
		super();
		occasion = "what?";
		recipient = "whom?";
	}
	
	BuyGiftTask(int dueInDays, boolean restrictedHours, String occasion, String recipient) {
		super("Gift", dueInDays, false, restrictedHours);
		this.occasion = occasion;
		this.recipient = recipient;
	}
	
	public String toString() {
		return "Task - Description: " + getDescription() + ", " +
				"For: " + recipient + "'s " + occasion +
				", In: " + getDueInDays() + 
				" days, Can do anytime: " + getRestrictedHours();
	}
}
