public class Teacher {
    private String name;
    private String surname;
    private String position;
    private short age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name ==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty!");
        }
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname =surname;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position =position;
    }
    public int getAge(){
        return age;
    }
    public void setAge(short age){
        if (age<0 || age > 150){
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("Teacher{name='%s', surname='%s' , position='%s', age='%d'" ,name,surname,position,age);
    }
}
