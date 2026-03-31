import java.util.Scanner;

class Main{
    private static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Teacher[] teachers = null;
        boolean running = true;

        while (running) {
            System.out.println("What operation do you want to perform?");
            System.out.println("0.Create first list \n" +
                    "1.Create a new one \n" +
                    "2.Update \n" +
                    "3.Delete \n" +
                    "4.Search \n" +
                    "5.Show all \n" +
                    "6.Exit");
            int action = scanner.nextInt();
            scanner.nextLine();
            teachers= switch (action){
                case 0 -> {
                    if (teachers == null){
                        yield initializeTeachers();
                    }else   System.out.println("Create a new one with option 1!"); yield teachers;

                }
                case 1 -> {
                    if (teachers == null){
                        System.out.println("First create a list with option 0!");
                        yield teachers;
                    }else  yield initializeNewTeachers(teachers);
                }
                case 2 -> {
                    Update(teachers);
                    yield teachers;
                }
                case 3 -> Delete(teachers);
                case 4 -> {
                    Search(teachers);
                    yield teachers;
                }
                case 5 -> {
                    ShowAll(teachers);
                    yield teachers;
                }
                case 6 -> {
                    running = false;
                    System.out.println("GoodBye");
                    yield teachers;
                }
                default -> {
                    System.out.println("Invalid option");
                    yield teachers;
                }
            };
        }
        scanner.close();
    }
    public static Teacher Create(){
        Teacher teacher = new Teacher();
        System.out.print("Please enter the Teacher's name: ");
        teacher.setName(scanner.nextLine());

        System.out.print("Please enter the Teacher's surname: ");
        teacher.setSurname(scanner.nextLine());

        System.out.print("Please enter the Teacher's position: ");
        teacher.setPosition(scanner.nextLine());

        System.out.print("Please enter the Teacher's age: ");
        teacher.setAge(scanner.nextShort());
        scanner.nextLine();
        return teacher;
    }
    public static Teacher[] initializeTeachers(){
        System.out.print("How many teachers will you register? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        Teacher[] teachers = new Teacher[count];

        for (int i=0; i<count; i++){
            teachers[i] = Create();
        }
        System.out.println("Registered teachers");
        ShowAll(teachers);
        return teachers;
    }
    public static Teacher[] initializeNewTeachers(Teacher[] oldteachers){
        System.out.print("How many teachers will you register? ");
        int new_count = scanner.nextInt();
        scanner.nextLine();
        Teacher[] teachers1 = new Teacher[new_count+oldteachers.length];
        for (int i=0; i<oldteachers.length; i++){
            teachers1[i] = oldteachers[i];
        }
        for (int i = oldteachers.length; i< teachers1.length; i++){
            teachers1[i] = Create();
        }
        return teachers1;
    }
    public static void Update(Teacher[] teachers){
        if (teachers == null) {
            System.out.println("First create a teacher list!");
            return;
        }
        System.out.print("Which teacher do you want to update? (1-" + teachers.length + ")");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index <0 || index >= teachers.length || teachers[index] == null){
            System.out.println("Invalid teacher");
            return;
        }
        Teacher teacher = teachers[index];
        System.out.print("Which cell do you want to change? (name,surname,position,age)");
        String updatedField = scanner.nextLine();
        if (updatedField.equals("name")){
            System.out.println("Enter the value you want to change: ");
            teacher.setName(scanner.nextLine());
        } else if (updatedField.equals("surname")) {
            System.out.println("Enter the value you want to change: ");
            teacher.setSurname(scanner.nextLine());
        } else if (updatedField.equals("position")) {
            System.out.println("Enter the value you want to change: ");
            teacher.setPosition(scanner.nextLine());
        } else if (updatedField.equals("age")) {
            System.out.println("Enter the value you want to change: ");
            teacher.setAge(scanner.nextShort());
        }
    }
    public static Teacher[] Delete(Teacher[] teachers){
        if (teachers == null) {
            System.out.println("First create a teacher list!");
            return null;
        }
        System.out.println("Which teacher do you want to delete? (1-" + teachers.length + ")");
        int index = scanner.nextInt() - 1;
        if (index<0|| index> teachers.length){
            System.out.println("Invalid index");
            return teachers;
        }
        Teacher[] newteachers = new Teacher[teachers.length -1];
        for (int i =0, j=0; i<teachers.length; i++){
            if (i != index){
                newteachers[j++] = teachers[i];
            }
        }
        System.out.println("Successful deleted");
        return newteachers;
    }
    public static void Search(Teacher[] teachers){
        if (teachers == null) {
            System.out.println("First create a teacher list!");
            return;
        }
        System.out.println("Who are you looking for?");
        String who = scanner.nextLine();
        boolean found = false;
        for (Teacher teacher: teachers ){
            if (teacher == null) continue;
            if (teacher.getName().equals(who) || teacher.getSurname().equals(who)){
                System.out.println(teacher);
                found = true;
            }
            if (!found){
                System.out.println("Not Found!");
                return;
            }

        }
    }
    public static void ShowAll(Teacher[] teachers){
        if (teachers == null) {
            System.out.println("First create a teacher list!");
            return;
        }
        for (int i =0; i<teachers.length; i++){
            if (teachers[i] ==null) continue;
            System.out.println((i+1)+ "." + teachers[i]);
        }
    }
}