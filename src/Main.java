import java.util.*;
import java.util.Map.Entry;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student one = new Student("ваня", new Potok("ИС", 2));
        Student two = new Student("петя",  new Potok("ИС", 1));
        Student three = new Student("дима",  new Potok("ИС", 2));
        Student four = new Student("саша",  new Potok("ИС", 1));
        Student five = new Student("мага",  new Potok("НГ", 2));
        Student six = new Student("наташа",  new Potok("НГ", 1));
        Student seven = new Student("коля",  new Potok("НГ", 2));
        Student eight = new Student("кирилл",  new Potok("НГ", 1));
        Student arrSt[] = new Student[]{one, two, three, four, five, six, seven, eight};

        HashMap<Potok, ArrayList<Student>> studentList = setReturn(arrSt);
        System.out.println(studentList);
        System.out.println("\n");
        System.out.println("все программисты: \n" + searchStudentF("ИС", studentList));
        System.out.println("все нефтегазовики: \n" + searchStudentF("НГ", studentList));

        System.out.println("\n");
        System.out.println("все второкурсники: \n" + searchStudent(2, studentList));
        System.out.println("\n");
        System.out.println("все первокурсники: \n" + searchStudent(1, studentList));
        System.out.println("\n");
        System.out.println("ваня: \n" + searchStudent("ваня", studentList));
        System.out.println("\n");
        System.out.println(delateStudent("саша", studentList));
        System.out.println("\n");
        System.out.println(delateStudent(new Potok("НГ", 2), studentList));
        Potok potok = new Potok("НГ" , 2);
        System.out.println(seven.getPotok().equals(potok));
    }

    public static HashMap<Potok, ArrayList<Student>> addStudent(Student student, HashMap<Potok, ArrayList<Student>> map){
        if (!map.isEmpty()){
            boolean bool = true;
            for (Entry<Potok, ArrayList<Student>> entry : map.entrySet()){
                if (entry.getKey().equalsSt(student.getPotok())){
                    entry.getValue().add(student);
                    bool = false;
                }
            }
            if (bool){
                map.put(student.getPotok(), new ArrayList<>());
                map.get(student.getPotok()).add(student);
            }
        }else {
            map.put(student.getPotok(), new ArrayList<>());
            map.get(student.getPotok()).add(student);
        }
        return map;
    }
    public static HashMap<Potok, ArrayList<Student>> setReturn(Student[] students){
        HashMap<Potok, ArrayList<Student>> result = new HashMap<>();
        for (int i = 0; i < students.length; i++){
            result = addStudent(students[i], result);
        }
        return result;
    }
    public static HashMap<Potok, ArrayList<Student>> delateStudent(String name , HashMap<Potok, ArrayList<Student>> map){
        for (Entry<Potok, ArrayList<Student>> entry : map.entrySet()){
            Iterator<Student> iterator = entry.getValue().iterator();
            while (iterator.hasNext()){
                Student nextSt = iterator.next();
                if (nextSt.getName().equals(name)){
                    iterator.remove();
                }
            }
        }
        return map;
    }
    public static HashMap<Potok, ArrayList<Student>> delateStudent(Potok potok, HashMap<Potok, ArrayList<Student>> map){

        Iterator<Map.Entry<Potok, ArrayList<Student>>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Potok, ArrayList<Student>> entry = entryIterator.next();
            if (entry.getKey().getYear() == potok.getYear() && entry.getKey().getFaculty().equals(potok.getFaculty())){
                entryIterator.remove();
            }
        }

        return map;
    }
    public static ArrayList<Student> searchStudentF(String faculty, HashMap<Potok, ArrayList<Student>> map){
        ArrayList<Student> students = new ArrayList<>();
        for (Entry<Potok, ArrayList<Student>> entry : map.entrySet()){
            if (entry.getKey().getFaculty() == faculty){
                Iterator<Student> iterator = entry.getValue().iterator();
                while (iterator.hasNext()){
                    Student nextSt = iterator.next();
                    students.add(nextSt);
                }
            }
        }
        return students;
    }
    public static ArrayList<Student> searchStudent(int year, HashMap<Potok, ArrayList<Student>> map){
        ArrayList<Student> students = new ArrayList<>();
        for (Entry<Potok, ArrayList<Student>> entry : map.entrySet()){
            if (entry.getKey().getYear() == year){
                Iterator<Student> iterator = entry.getValue().iterator();
                while (iterator.hasNext()){
                    Student nextSt = iterator.next();
                    students.add(nextSt);
                }
            }
        }
        return students;
    }
    public static ArrayList<Student> searchStudent(String name, HashMap<Potok, ArrayList<Student>> map){
        ArrayList<Student> students = new ArrayList<>();

        for (Entry<Potok, ArrayList<Student>> entry : map.entrySet()){
            Iterator<Student> iterator = entry.getValue().iterator();
            while (iterator.hasNext()){
                Student nextSt = iterator.next();
                if (nextSt.getName().equals(name)){
                    students.add(nextSt);
                }
            }
        }

        return students;
    }}

