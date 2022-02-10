package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> LoginValidData() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"lina@gmail.com", "Lina12345$"});
        list.add(new Object[]{"lina@gmail.com", "Lina12345$"});
        list.add(new Object[]{"lina@gmail.com", "Lina12345$"});

        return list.iterator();//kollekciya iterator
    }


    @DataProvider
    public Iterator<Object[]> LoginValidDataCSV() throws IOException {
//TEST VUCHITKA IZ FAILA cherez user
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login.csv")));
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});

            line = reader.readLine();
        }

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> LoginValidDataCSV2() throws IOException {//DOMASHKA!!!!!!!!!!!!!!!!!!!!
//TEST VUCHITKA IZ FAILA cherez 2 String
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login.csv")));
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{split[0],split[1]});

            line = reader.readLine();
        }
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> ContactValidData() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Hay", "Low", "1256335", "hay@gmail.com", "haifa", "work"});
        list.add(new Object[]{"Hay", "Low", "1256335", "hay@gmail.com", "haifa", "work"});
        list.add(new Object[]{"Hay", "Low", "1256335", "hay@gmail.com", "haifa", "work"});


        return list.iterator();//kollekciya iterator
    }


    @DataProvider
    public Iterator<Object[]> LoginValidDataModel() {

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("lina@gmail.com").withPassword("Lina12345$")});
        list.add(new Object[]{new User().withEmail("lina@gmail.com").withPassword("Lina12345$")});
        list.add(new Object[]{new User().withEmail("lina@gmail.com").withPassword("Lina12345$")});

        return list.iterator();//kollekciya iterator
    }

    @DataProvider
    public Iterator<Object[]> addContactValidDataModel() {
//net testa dlya ispolzovaniya itogo methoda
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder().name("John").lastName("Wic").phone("44444455555777").email("wick@gmail.com").address("Ness Ziona").description("friend").build()});
        list.add(new Object[]{Contact.builder().name("John").lastName("Wic").phone("44444455555774").email("wick1@gmail.com").address("Ness Ziona").description("friend").build()});


        return list.iterator();//kollekciya iterator
    }


    @DataProvider
    public Iterator<Object[]> addContactValidDataCSV() throws IOException {
//TEST VUCHITKA IZ FAILA
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine(); //Mona,Dow,32145678965,mona@gmail.com,Rehovot,university friend

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();//nachinaet snova chtatj sleduyshie linii/stroki poka oni estj
        }

        return list.iterator();//kollekciya iterator
    }
}
