package me.zhang.coreJava.io;

import me.zhang.coreJava.Employee;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static me.zhang.coreJava.io.DataIO.readFixedString;
import static me.zhang.coreJava.io.DataIO.writeFixedString;

/**
 * Created by zhangxiangdong on 2017/12/16.
 */
public class RandomAccessTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        final String filename = "employee.dat";

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            // save all employee records to the file employee.dat
            for (Employee e : staff) writeData(out, e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (RandomAccessFile in = new RandomAccessFile(filename, "r")) {
            // retrieve all records into a new array

            // compute the array size
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];

            // read employees in reverse order
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            // print the newly read employee records
            for (Employee e : newStaff) System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(DataOutput out, Employee e) throws IOException {
        writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDay());
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH) + 1);
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }

    private static Employee readData(DataInput in) throws IOException {
        String name = readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m - 1, d);
    }

}
