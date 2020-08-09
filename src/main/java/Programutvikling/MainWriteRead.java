package Programutvikling;

import Programutvikling.Model.MyArrays;
import Programutvikling.Model.MyDate;
import Programutvikling.Model.Writers.DeleteFromFile;
import Programutvikling.Model.Customer.InvalidPersonFormatException;
import Programutvikling.Model.newObjectCreator;

import java.io.*;

import static java.util.Calendar.getInstance;


public class MainWriteRead {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidPersonFormatException {

        //System.out.println(MyArrays.AccidentReportListscsv());
        //deleteFromFile.deleteObjectFromFile("1111B003");
        newObjectCreator.AccidentReportCreator(new MyDate(), "0016H001","type",
                "Description",10000,100000);
        /*newObjectCreator.houseInsuranceCreator(1,10000,20000,new MyDate(),
                "insuranceConditions/BoatInsuranceConditions_34243.pdf","Home",
                "Singel","Construction","Weak",200,
                10000,10000);*/

        /*ArrayList<Object> cList = new ArrayList();
        Customer c = new Customer("Lars", "Lien","97485326",
                      "Email","sgs","sdfsdf","ssdf");
        Customer o = new Customer("Lars", "Lien","97485326",
                "Email","sgs","sdfsdf","ssdf");
        c.customerInfoArray();
        cList.add(c);
        cList.add(o);
        ObjectWriterJOBJ.writeObjects(cList,new File("customerObjects.jobj"));

        for(Object a : MyArrays.customerListsjobj()){
            System.out.println(a);
        };*/
        //o.customerInfoArray();
        //ObjectWriterJOBJ.writeObjects(o.arrOut(),new File("customerObjects.jobj"));

        //System.out.println(ObjectReaderJOBJ.readObjects("customerObjects.jobj","Customer"));
        //for(Object ob : ObjectReaderJOBJ.readObjects("customerObjects.jobj","Customer")) {
        //    System.out.println(ob);
        //}
        /*newObjectCreator.BoatInsuranceCreator(1111, 10000, 10000,
                new MyDate(26,03,2020),
                "insuranceConditions/BoatInsuranceConditions_34243.pdf","dsfds",
                "sdfsdfds","sdf123","sdf","sdfsdf",6,
                1999,"dfsdfsdf");
        ObjectReaderCSV.readObjects("boatInsuranceObjects.csv", "BoatInsurance");
        //newObjectCreator.customerCreatorJOBJ("lars","lien","97485325","email",*/
          //      "hjemme", "2092", "Oslo");

       // ObjectWriterCSV.writeObjects(customerList, new File("customerObjects.csv"));

        //Customer customer = new Customer("Lars", "Lien","97485326",
          //      "Email","sgs","sdfsdf","ssdf");
        //ObjectWriterJOBJ.writeObjects(customer.arrOut(),new File("customerObjects.jobj"));
        //fillCustomerArray();

        //customerList = null;
        //System.out.println();

        //ArrayList arr = new ArrayList(MyArrays.customerListsjobj());

        //for(Object o : arr) {
       //     System.out.println(o); }

        /*Person person = new Person("limen","Liten","97485326",
                "lars.vidar.lien@gmail.com");
        Person person2 = new Person("Simen","Liten","97485326",
                "lars.vidar.lien@gmail.com");
        File path = new File("personObjects.txt");
        ArrayList<Object> people = new ArrayList<>();
        people.add(person);
        people.add(person2);

        ChooseObjectWriter ow = new ChooseObjectWriter();
        ow.chooseObjectWriterJOBJ(people,path);
        //ow.chooseObjectWriterCSV(people,path);

        ChooseObjectReader c = new ChooseObjectReader();
        c.chooseObjectReaderJOBJ(path);
        //c.chooseObjectReaderCSV(path, "Person");
        //people.add(person);

       // ChooseObjectReader e = new ChooseObjectReader();
        //e.chooseObjectWriterJOBJ(people, path);



       /* ArrayList<Object> persons;
        persons = ObjectReaderJOBJ.readObjects(path);
        for(Object e : persons) {
            System.out.println(e);
        }*/

        /*try (FileInputStream fin = new FileInputStream(path);
             ObjectInputStream oin = new ObjectInputStream(fin)) {
            Object loadedPerson = oin.readObject();
            System.out.println("Person from loaded jobj file:\n" + loadedPerson);
        } catch(IOException x) {
            System.err.println("Could not read file. Cause: " + x.getCause());
        } catch(ClassNotFoundException q) {
            System.err.println("Could not convert Object");
        }
/*
        /*List<Person> persons = null;
        String path = "personObjects.csv";
        try {
            persons = PersonReader.readPersons(path);
        } catch (IOException o) {
            System.err.println("Could not read the requested file. Cause: " + o.getCause());
        } catch (InvalidPersonFormatException o) {
            System.err.println("The data is not formatted correctly. Message: " + o.getMessage());
        }

        if(persons == null) { // some error has occurred
            System.exit(1);
        }

        System.out.println(persons);


        /*PersonObjectWriter.java cow = new PersonObjectWriter.java(person);
        cow.personObjectWriter();*/


        //PersonObjectReaderJOBJ por = new PersonObjectReaderJOBJ();
        // por.personObjectReader();

       // por.personObjectReaders(path);

        //por.personObjectReaderer();

    }
}
