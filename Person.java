public class Person {

    private String firstName;   
    private String lastName;    
    private int age;            

    // == Getters and Setters ==
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName != null) ? firstName : "";  
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName != null) ? lastName : "";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = (age < 0 || age > 100) ? 0 : age;
    }

    // == Utility Methods ==
    public boolean isTeen() {
        return age > 12 && age < 20;
    }

    public String getFullName() {
        if ((firstName == null || firstName.isEmpty()) && 
            (lastName == null || lastName.isEmpty())) {
            return "";
        }

        return String.join(" ", firstName, lastName).trim();
    }

    @Override
    public String toString() {
        return String.format("Person [FullName: %s, Age: %d, Teen: %b]", 
                getFullName(), age, isTeen());
    }

    // == Main Method for Testing ==
    public static void main(String[] args) {
        Person person = new Person();
        
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAge(18);
        
        System.out.println(person);
        
        person.setAge(150);  // Invalid age -> should set to 0
        System.out.println(person);

        person.setFirstName(null);  // Null safety check
        person.setLastName(null);
        System.out.println("Full Name: " + person.getFullName());
    }
}
