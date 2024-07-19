public class Potok extends Object{
    private String faculty;
    private int year;

    public Potok(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Potok() {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return faculty + "до" + year;
    }


    public boolean equalsSt(Potok obj) {
        if (this.year == obj.getYear() && this.faculty.equals(obj.getFaculty())){
            return true;
        }else {
            return false;
        }
    }



}

