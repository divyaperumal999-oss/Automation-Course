package EduSmart;

//interface
interface ProgressTrackable
{
	void trackProgress();
}
//abstract class
abstract class User
	{
	private String name;
	private String email;
	private int userid;
	public User(String name, String email, int userId) {
        this.name = name;
        this.email = email;
        this.userid = userId;
    }
	abstract void viewProfile();
//getters 
	public String getName() { return name; }
	public String getEmail() { return email; }
	public int getUserid() { return userid; }
//setters
	public void setName(String name) { this.name = name; }
	public void setEmail(String email) { this.email = email; }
	public void setUserid(int userid) { this.userid = userid; }
	
	final void displayWelcome()
	{
		System.out.println("Welcome "+this.name +" to Edumart Learning Studio!");
	}
	}
//Student class
class Student extends User implements ProgressTrackable
{
private String enrolledCourse1;
private String enrolledCourse2;

public Student(String name, String email, int userid) {
    super(name, email, userid);
    this.enrolledCourse1 = null;
    this.enrolledCourse2 = null;
}
public void enrollCourse(String courseName) {
    if (this.enrolledCourse1 == null) {
        this.enrolledCourse1 = courseName;
        System.out.println(getName() + " enrolled in " + courseName);
    }
    else if (this.enrolledCourse2 == null) {
        this.enrolledCourse2 = courseName;
        System.out.println(getName() + " enrolled in " + courseName);
    }
}
 void viewProfile() {
	        System.out.println("\n Student Profile ");
	        System.out.println("Name: " + getName());
	        System.out.println("Email: " + getEmail());
	        System.out.println("Course 1: " + enrolledCourse1);
	        System.out.println("Course 2: " + enrolledCourse2);
	    }
public void trackProgress() {
    System.out.println(getName() + "'s Progress: 50% completed!");
}
}
 class Instructor extends User
 {
	private String CreatedCourse1;
	private String CreatedCourse2;
	
	    public Instructor(String name, String email, int userId) {
	        super(name, email, userId);
	    }

	    public void createCourse(String courseName) {
	        if (CreatedCourse1 == null) {
	            CreatedCourse1 = courseName;
	            System.out.println(getName() + " created course: " + courseName);
	        }
	        else if (CreatedCourse2 == null) {
	            CreatedCourse2 = courseName;
	            System.out.println(getName() + " created course: " + courseName);
	        }
	        else {
	            System.out.println("❌ Cannot create more than 2 courses.");
	        }
	    }
	
	 void viewProfile() {
		  System.out.println("\n Instructor Profile ");
	        System.out.println("Name: " + getName());
	        System.out.println("Email: " + getEmail());
	        System.out.println("Created Course 1: " + CreatedCourse1);
	        System.out.println("Created Course 2: " + CreatedCourse2);
	 }
	 public String getCreatedCourse1() { return CreatedCourse1; }
	    public String getCreatedCourse2() { return CreatedCourse2; }
	}
 
 class Admin extends User
 {
	 public Admin(String name, String email, int userId) {
	        super(name, email, userId);
	    }

	    public void removeUser(User user) {
	        System.out.println("Admin removed user: " + user.getName());
	    }
	    void viewProfile() {
	        System.out.println("\n Admin Profile ");
	        System.out.println("Name: " + getName());
	        System.out.println("Email: " + getEmail());
	    }
	}	 
	 
 
 class Course {
	    private String title;
	    private int durationInHours;
	    private final int maxStudents;
	   public Course(String title, int duration, int maxStudents) {
	        this.title = title;
	        this.durationInHours = duration;
	        this.maxStudents = maxStudents;
	    }
	   public Course(String title)
	   {
		   this.maxStudents = 0;
		   this.title = title;
	   }
	   public void showCourseDetails() {
	        System.out.println("\n Course Details");
	        System.out.println("Title: " + title);
	        System.out.println("Duration: " + durationInHours + " hours");
	        System.out.println("Max Students: " + maxStudents);
	    }
 }
	   
public class EduSmartLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Student s1 = new Student("Divya", "dp402@gmail.com", 1000);
        Student s2 = new Student("Prasanna", "prasanna@mail.com", 1001);

        Instructor i1 = new Instructor("Latha", "latha@gmail.com", 2000);
        Instructor i2 = new Instructor("Maria", "maria@gmail.com", 2002);

        Admin admin = new Admin("Admin", "admin@gmail.com", 1);

        s1.displayWelcome();
        i1.displayWelcome();
        admin.displayWelcome();
        i1.createCourse("Java");
        i1.createCourse("AI");
        i2.createCourse("Digital Marketing ");
        i2.createCourse("Automation");

        s1.enrollCourse(i1.getCreatedCourse1());
        s1.enrollCourse(i2.getCreatedCourse1());

        s2.enrollCourse(i1.getCreatedCourse2());
        s2.enrollCourse(i2.getCreatedCourse2());

        s1.viewProfile();
        s2.viewProfile();
        i1.viewProfile();
        i2.viewProfile();
        admin.viewProfile();

        s1.trackProgress();
        s2.trackProgress();

        admin.removeUser(s2);

        Course c1 = new Course("Machine Learning", 40, 200);
        Course c2 = new Course("Environmental Science");

        c1.showCourseDetails();
        c2.showCourseDetails();
	}

}
